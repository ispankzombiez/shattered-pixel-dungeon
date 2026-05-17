# Sprouted Behavior Parity Backlog (Prioritized)

Priority legend: **P0** progression blocker, **P1** major branch parity, **P2** content parity/polish.

Session-level rollup checklist:
- `docs/sprouted-master-checklist.md`

## P0 – Progression blockers

| ID | Source behavior | Current behavior | Missing logic | Affected files | Dependencies | Acceptance criteria |
|---|---|---|---|---|---|---|
| P0-01 | Branch routes always resolve to intended Sprouted map classes | Missing route falls through to generic handling | Explicit failure guard + telemetry for missing routes | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/Dungeon.java`, `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/Layouts.java` | None | Invalid Sprouted branch depth can no longer silently route to unrelated flow |
| P0-02 | Large Sprouted-style floors by branch/depth | Implicit map size from room packing only | Explicit map-size profiles and scaled generation knobs | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/MapSizeProfiles.java`, `.../RegularLevel.java`, `.../painters/RegularPainter.java`, `.../SproutedArenaLevel.java`, `.../TenguHideoutLevel.java` | P0-01 | Representative floors produce larger maps without generation soft-locks |
| P0-03 | Deterministic parity checks available | No dedicated parity regression runner | Seed-based deterministic checks task | `core/build.gradle`, `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/validation/SproutedSeedRegressionChecks.java` | P0-01 | `:core:sproutedSeedChecks` runs and validates deterministic branch/layout invariants |
 - [x] P0-01: `Dungeon.newLevel()` now reports invalid Sprouted branch routes and falls back to `DeadEndLevel` instead of silently using unrelated flow
 - [x] P0-03: `:core:sproutedSeedChecks` exists and validates deterministic Town/Sokoban/teleport/vault layout selection plus exact Sprouted branch route mappings

## P1 – Major branch parity

| ID | Source behavior | Current behavior | Missing logic | Affected files | Dependencies | Acceptance criteria |
|---|---|---|---|---|---|---|
| P1-01 | Town-specific authored layout influence | Town layouts exist but were unused | Integrate TownLayouts into generated map surface | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/TownLevel.java`, `.../TownLayouts.java`, `.../SproutedLayoutStamp.java` | P0-02 | Town floor generation deterministically stamps authored layout motifs |
| P1-02 | Sokoban-authored puzzle layouts are in active flow | Sokoban levels used generic RegularLevel generation | Integrate Sokoban layout parsing/stamping into Sokoban levels | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/SokobanIntroLevel.java`, `.../SokobanPuzzlesLevel.java`, `.../SokobanPuzzles2Level.java`, `.../SokobanTeleportLevel.java`, `.../SokobanVaultLevel.java`, `.../SokobanLayouts.java`, `.../SokobanLayouts2.java`, `.../SproutedLayoutStamp.java` | P0-02 | Each Sokoban level uses deterministic authored layout symbols in map generation |
| P1-03 | Branch area pacing scales with floor area | Mob/trap/item scaling mostly fixed | Scale trap/mob/item/retry logic with explicit profile | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/RegularLevel.java`, `.../MapSizeProfiles.java` | P0-02 | Spawn/item density remains playable after map size increases |

## P2 – Remaining parity tickets (next wave) — ALL COMPLETE ✓

| ID | Source behavior | Current behavior | Missing logic | Affected files | Dependencies | Acceptance criteria |
|---|---|---|---|---|---|---|
| P2-01 | Behavior-accurate Town/Mine/Fortress/Catacomb generation/events | Mostly chapter inheritance + painter tweaks | Replace inherited generation with branch-authentic events and pacing | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/TownLevel.java`, `.../MineLevel.java`, `.../FortressLevel.java`, `.../CatacombLevel.java` | P1-01/P1-03 | Branch levels match Sprouted event cadence and unique interactions |
 - [x] TownLevel: safe hub (randomRespawnCell=-1), NPC spawning (Shopkeeper×2, Tinkerer4, Tinkerer5)
 - [x] FortressLevel: PEDESTAL entrance/exit, CHASM→EMPTY, SanChikarahLife drop at exit, Tinkerer3 NPC spawn
 - [x] CatacombLevel: PEDESTAL entrance/exit, CHASM→EMPTY, SanChikarahDeath drop at exit, sink drip visuals
 - [x] MineLevel: Tinkerer1 at depth 11 (intro scout), Tinkerer2 at depths 12-14 (mushroom trade)
 - [x] Dungeon: sanchikarahlife/sanchikarahdeath flags added with full bundle persistence
 - [x] TownLevel: storeRefresh() depth-gated shop inventory
 - [x] FortressLevel/CatacombLevel: SanChikarah flags cleared when item is picked up (SanChikarahLife/Death.doPickUp)
 - [x] Tinkerer NPC interact() dialogs (all five tinkerers)
| P2-02 | Full Sokoban puzzle accuracy | Symbol stamping only | Solve-specific puzzle entities, states, and completion rules | Sokoban levels + Sokoban NPC/mob/trap classes | P1-02 | Puzzle completion behavior and fail/retry flow match Sprouted reference |
 - [x] Sokoban sheep interactions: push/swap/stop behaviors for SheepSokoban, SheepSokobanCorner, SheepSokobanSwitch, SheepSokobanStop
 - [x] ChangeSheepTrap sheep-morph cycle: SheepSokoban → SheepSokobanCorner → SheepSokobanStop and SheepSokobanSwitch → SheepSokoban
 - [x] Sokoban portal activation wiring: switch traps (`v`) arm portal traps (`t`), and armed portals teleport hero to level exit
 - [x] Per-floor Sokoban completion rules on teleport/vault floors: exits stay locked until all Sokoban portal switches are consumed
 - [x] Destination-mapped portal networks: layout `d` markers pair switches to specific portal destinations by authored order
| P2-03 | Full non-map parity (quests/resources/pets/crafting loops) | Partial/unknown in several subsystems | Behavior audit and implementation per subsystem | Quest/resource/pet/crafting classes across `core/src/main/java/...` | P0/P1 complete | All audit items are marked behavior-verified with deterministic seeds |
 - [x] All P2-03 sub-items in master checklist confirmed complete (see docs/sprouted-master-checklist.md § P2-03)

## P3 – Post-parity backlog

| ID | Source behavior | Current behavior | Missing logic | Affected files | Acceptance criteria |
|---|---|---|---|---|---|
| P3-01 | Boss floors at designated branch depths | Boss-level classes exist as stubs; not routed | Wire MinesBossLevel/SkeletonBossLevel/CrabBossLevel/ThiefBossLevel/InfestBossLevel into Layouts.branchLevel() | `Layouts.java`, boss level classes | Boss floors are reachable via standard branch routing |
 - [x] InfestBossLevel routed at depth 15 (Mine boss: Gullin) — closes Mine 11-14 → Fortress 16-19 gap
- [x] MinesBossLevel verified as legacy/duplicate wrapper; active mine boss route remains `InfestBossLevel` at branch 2 depth 15
- [x] SkeletonBossLevel/CrabBossLevel/ThiefBossLevel verified as not routed by branch 0 or Sprouted branch flow; documented as reserved wrappers for future dedicated boss-floor expansion
| P3-02 | All level types are reachable or intentionally retired | DragonCaveLevel, ZotBossLevel, SokobanCastle, SafeLevel, SafeLevel1, VaultLevel exist but are unrouted | Route into branch/depth map OR add a comment marking them as legacy/reserved | Unrouted level classes, `Layouts.java` | No level class is silently unreachable without explicit documentation |
 - [x] VaultLevel: already routed in Dungeon.java (branch 1 quest level, depths 16-19) — not unrouted
 - [x] DragonCaveLevel: documented with SPROUTED_RESERVED comment (Mine dragon encounter, intended depth 12/13)
 - [x] ZotBossLevel: documented with SPROUTED_RESERVED comment (Catacomb boss, intended depth 23 pending depth-range shift)
 - [x] SokobanCastle: documented with SPROUTED_RESERVED comment (post-Sokoban castle challenge, intended depth 31)
 - [x] SafeLevel: documented with SPROUTED_RESERVED comment (pre-Mine safe floor, intended depth 10)
 - [x] SafeLevel1: documented with SPROUTED_RESERVED comment (second safe floor variant, future use)
| P3-03 | Tinkerer NPC narrative arc integrity | Tinkerer1 at depth 11, Tinkerer2 at 12-14 | Verify exact per-depth NPC trigger conditions in-game | `MineLevel.java` | Arc plays out as designed at each mine depth |
 - [x] Tinkerer1 dialog verified: "Oh wow, have you seen this dungeon? I'm scouting it and looking for toadstool mushrooms." (correct intro arc)
 - [x] Tinkerer2 dialog verified: mushroom-present prompt offers trade (1 Mushroom → random Potion); no-mushroom prompt sends player to look for mushrooms (correct follow-through)
 - [x] MineLevel.createItems(): depth==11 → Tinkerer1, depth 12-14 → Tinkerer2 (correct placement logic)

## P4 – Post-parity hardening (next wave)

| ID | Goal | Current status | Needed work | Affected files | Acceptance criteria |
|---|---|---|---|---|---|
| P4-01 | In-game route validation for all documented SPROUTED_RESERVED levels/wrappers | Routing intent is documented in code/comments | Add a deterministic route-audit check that asserts each documented reserved class is either reachable by explicit route or explicitly tagged reserved | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/validation/SproutedSeedRegressionChecks.java`, reserved level wrapper classes | Seed checks fail if reserved/reachable documentation drifts from runtime routing |
| P4-02 | Strengthen Sprouted regression confidence beyond route/layout mapping | Deterministic checks cover route/layout invariants only | Add deterministic assertions for a small set of key Sprouted gameplay flags/events (e.g. altar completion persistence, SanChikarah fragment merge state persistence) | `core/src/main/java/com/shatteredpixel/shatteredpixeldungeon/levels/validation/SproutedSeedRegressionChecks.java`, relevant dungeon flag classes | A seed regression task catches regressions in key parity-critical flags/events |

- [x] P4-01: Implemented deterministic route-audit assertions in `SproutedSeedRegressionChecks` — `InfestBossLevel` must remain mapped exactly at branch 2 depth 15, while documented SPROUTED_RESERVED wrappers/levels (`MinesBossLevel`, `SkeletonBossLevel`, `CrabBossLevel`, `ThiefBossLevel`, `DragonCaveLevel`, `ZotBossLevel`, `SokobanCastle`, `SafeLevel`, `SafeLevel1`) and `VaultLevel` (routed via `Dungeon.newLevel`, not `Layouts.branchLevel`) must remain unmapped in `Layouts.branchLevel()`
- [x] P4-02: Added deterministic progression regression checks in `SproutedSeedRegressionChecks` for (1) `Dungeon` progression-flag bundle persistence keys/round-trip (`sanchikarahlife`, `sanchikarahdeath`, `nornaltardone`) and (2) SanChikarah fragment merge event integrity (`SanChikarahLife` + `SanChikarahDeath` → `SanChikarahTranscend`)
