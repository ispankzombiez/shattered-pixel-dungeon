# Sprouted Master Implementation Checklist

This is the **single session-by-session checklist** for overall Sprouted parity progress.
Update this file at the end of each work session.

## Overall progress

- [x] Path-level Sprouted class coverage complete (`docs/sprouted-feature-checklist.md`: 543 checked, 0 unchecked)
- [x] P0-01: Sprouted branch-route fallback guard + exception reporting
- [x] P0-02: Large-floor map-size profile parity (generation sizing + pacing tuning) — wired via `MapSizeProfiles`, soft-lock fixed
- [x] P0-03: Deterministic Sprouted seed regression task (`:core:sproutedSeedChecks`)
- [x] P1-01: Town authored layouts integrated in active generation flow
- [x] P1-02: Sokoban authored layouts integrated in active generation flow
- [x] P1-03: Branch-area pacing tuned for enlarged floor profiles — mob/trap/item/retry multipliers in place
- [x] P2-01: Full Town/Mine/Fortress/Catacomb behavior parity (beyond currently implemented events)
- [x] P2-02: Full Sokoban puzzle parity (beyond currently implemented sheep/switch/portal/destination flow)
- [x] P2-03: Non-map parity audit and implementation (quests/resources/pets/crafting loops)
- [x] P3-01: Boss floor routing — InfestBossLevel wired into Layouts.branchLevel() at depth 15 (Mine boss gap); regression check updated
- [x] P3-02: Unrouted special levels — VaultLevel confirmed as already routed (Dungeon.java branch 1 quest); DragonCaveLevel/ZotBossLevel/SokobanCastle/SafeLevel/SafeLevel1 documented with SPROUTED_RESERVED comments explaining intended routing and current status
- [x] P3-03: Tinkerer1/2 NPC arc verified — Tinkerer1 (depth 11) intro dialog and Tinkerer2 (depths 12-14) mushroom-trade dialog are correct and complete

## Remaining high-level work checklist

- [x] Fix `SproutedArenaLevel.createMobs()` generation soft-lock (outer retry bail-out added)
- [x] Finish deep behavior parity pass for Town/Mine/Fortress/Catacomb branches (P2-01)
- [x] Finish deep behavior parity pass for all Sokoban puzzle mechanics and fail/retry flow (P2-02)
- [x] Complete P2-03 non-map subsystem work (see detailed breakdown below)
- [x] P3-01: Route boss floors into Layouts.branchLevel() at correct branch depths (InfestBossLevel at depth 15)
- [x] P3-02: Route/retire unrouted special levels — VaultLevel already routed; DragonCaveLevel/ZotBossLevel/SokobanCastle/SafeLevel/SafeLevel1 documented with SPROUTED_RESERVED comments
- [x] P3-03: Verify Tinkerer1 (depth 11) → Tinkerer2 (depth 12-14) narrative arc in Mine branch
- [x] P4-01: Add route-audit regression checks so documented reserved/reachable status cannot drift from runtime routing
- [x] P4-02: Add deterministic regression checks for key Sprouted progression flags/events (post-parity hardening)

## P2-03 Non-map subsystem detailed breakdown

### Items — behavior implemented
- [x] `TownReturnBeacon` — `AC_USE` teleports hero to Town (branch 2 depth 23) via `InterlevelScene.Mode.RETURN`
- [x] `FishingBomb` — `explode()` override paralysis-stuns all chars standing on water tiles in blast range
- [x] `HolyHandGrenade` — `explode()` override deals 50% bonus damage to DEMONIC/UNDEAD chars (matches HolyBomb pattern)
- [x] `SanChikarahTranscend` — `AC_INVOKE` fully heals hero + applies 60 turns of Bless; consumed on use
- [x] `StoneOre` — `value()` = 50 gold/unit; `isIdentified()`/`isUpgradable()` correct; sells at shops

### SanChikarah merge mechanic — DONE
- [x] `SanChikarahLife.doPickUp()` calls `tryMerge()` after collecting
- [x] `SanChikarahDeath.doPickUp()` calls `tryMerge()` symmetrically — both fragments → `SanChikarahTranscend`

### Quest / progression loop items — DONE THIS SESSION
- [x] **Norn stone altar in Town**: `NornStoneAltar` NPC added to `TownLevel.createMobs()`; WndOptions confirms 3-stone deposit → `ScrollOfUpgrade` reward; `Dungeon.nornAltarDone` flag stored/restored/reset
- [x] **Tinkerer2 mushroom trade**: `Tinkerer2.interact()` now checks for `Mushroom` in inventory; WndOptions offer → 1 Mushroom consumed → random Potion dropped

### Mobs missing loot/behavior
- [x] `Gullin` — drops a random `NornStone` at 50% chance
- [x] `Kupua` — drops a random `NornStone` at 25% chance
- [x] `FishProtector` — drops `Mushroom` at 33% chance
- [x] `FlyingProtector` — drops `Mushroom` at 25% chance
- [x] `ForestProtector` — drops `Mushroom` at 25% chance
- [x] `BanditKing` (boss) — guaranteed drop: 3× `StoneOre`
- [x] `ThiefKing` (boss) — guaranteed drop: 250 Gold
- [x] `SkeletonKing` (boss, UNDEAD) — guaranteed drop: random `NornStone`
- [x] `CrabKing` (boss) — guaranteed drop: 3× `StoneOre`
- [x] Remaining Sprouted mob drop-table sweep — audited (`BlueCat`, `RatBoss`, `King`, `DwarfKingTomb`, `GraveProtector`, `VaultProtector`) and currently kept on default/no-special-drop behavior

### NPC interaction completeness
- [x] Tinkerer1–5 interact dialogs (complete)
- [x] Tinkerer2 mushroom trade interaction (implemented)
- [x] Shopkeeper×2 in Town — `storeItem()` now covers Weapons, Armor, NornStone, StoneOre in addition to consumables (12 types total)

### Crafting / Generator
- [x] `Generator.NORNSTONE` category — verified in `Generator`, wired with all 5 color variants and equal probs
- [x] Verify `NornStone` color variants have distinct effects — DONE: Blue=heal, Green=satiate, Orange=Haste, Purple=identify-all, Yellow=Bless

### Items — still pending deeper design
- [x] `Mushroom` — confirmed as food-only (+trade input) with no extra special effect requirement; aligns with feature checklist parent-class target

## End-of-session update checklist (run every session)

- [ ] Update this file's status checkboxes to reflect newly completed work
- [ ] Add a short session log entry with date, completed items, and next priority
- [ ] Keep links in `docs/sprouted-feature-checklist.md` and `docs/sprouted-behavior-backlog.md` aligned with this master checklist

## Session log

- [x] 2026-05-16 (session 1): Added this master checklist; synced status with current Sprouted feature checklist + behavior backlog and recent P2-02/P0-03 updates.

- [x] 2026-05-17 (session 2): Fixed `SproutedArenaLevel.createMobs()` soft-lock; implemented `TownReturnBeacon.execute()`; added `NornStone.randomNornStone()` factory and wired it as `Gullin` loot at 50%; marked P0-02 and P1-03 complete; expanded P2-03 with detailed subsystem audit.

- [x] 2026-05-17 (session 3): Implemented FishingBomb water-stun; HolyHandGrenade 50% bonus DEMONIC/UNDEAD damage; SanChikarah merge mechanic; SanChikarahTranscend AC_INVOKE (full heal + 60t Bless, consumed on use).

- [x] 2026-05-17 (session 5): NornStone color-variant effects (Blue=heal, Green=satiate, Orange=Haste, Purple=identify-all, Yellow=Bless); mob drop table audit + loot added to Kupua/Protectors/Bosses; TownLevel Shopkeeper now stocks Weapons/Armor/NornStone/StoneOre.
  - Next priority: Mushroom special properties audit; remaining mob drop table sweep; P2-01 Town/Mine deeper behavior parity.

- [x] 2026-05-17 (session 6): Completed Mushroom behavior audit (kept food+trade only) and finished remaining Sprouted mob drop-table sweep for default/no-special-drop mobs.
  - Next priority: P2-01 Town/Mine deeper behavior parity pass.

- [x] 2026-05-17 (session 8): Closed P3-02 and P3-03. Confirmed VaultLevel is already routed (Dungeon.java branch 1 quest). Added SPROUTED_RESERVED documentation to DragonCaveLevel (Mine dragon encounter, reserved for depth 12/13), ZotBossLevel (Catacomb boss, reserved for depth 23 pending depth-range shift), SokobanCastle (post-Sokoban castle challenge, reserved for depth 31), SafeLevel (pre-Mine safe floor, reserved for depth 10), and SafeLevel1 (second safe floor variant, reserved for future use). Verified Tinkerer1/2 NPC arc is correct: Tinkerer1 intro dialog at depth 11, Tinkerer2 mushroom-trade dialog at depths 12-14. All P0/P1/P2/P3 checklist items now complete.

- [x] 2026-05-17 (session 9): Closed the remaining unchecked P3-01 sub-items in the behavior backlog. Verified `MinesBossLevel` is a legacy duplicate relative to routed `InfestBossLevel` (branch 2 depth 15). Verified `SkeletonBossLevel`, `CrabBossLevel`, and `ThiefBossLevel` are currently unrouted by both standard branch 0 and Sprouted branch flows; documented all four classes with SPROUTED_RESERVED comments for intentional future expansion usage.

- [x] 2026-05-17 (session 10): Continued checklist progression after P0-P3 completion by opening a post-parity hardening wave (P4) in `docs/sprouted-behavior-backlog.md`. Added two next targets: (1) route-audit regression checks for documented reserved/reachable level wrappers, and (2) deterministic regression checks for key Sprouted progression flags/events.
  - Next priority: Implement P4-01 route-audit assertions in `SproutedSeedRegressionChecks`.

- [x] 2026-05-17 (session 11): Implemented P4-01 in `SproutedSeedRegressionChecks` by adding deterministic route-audit assertions: `InfestBossLevel` must remain mapped exactly at branch 2 depth 15, and documented SPROUTED_RESERVED wrappers/levels plus `VaultLevel` must remain unmapped in `Layouts.branchLevel()`.
  - Next priority: Implement P4-02 deterministic checks for key Sprouted progression flags/events.

- [x] 2026-05-17 (session 12): Implemented P4-02 in `SproutedSeedRegressionChecks` with deterministic progression checks for `Dungeon` Sprouted quest flags (`sanchikarahlife`, `sanchikarahdeath`, `nornaltardone`) bundle key stability/round-trip persistence and SanChikarah fragment merge event integrity (`Life` + `Death` => `Transcend`).
  - Next priority: Define and start the next post-parity hardening wave after P4 completion.
