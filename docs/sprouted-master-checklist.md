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
- [ ] P2-01: Full Town/Mine/Fortress/Catacomb behavior parity (beyond currently implemented events)
- [ ] P2-02: Full Sokoban puzzle parity (beyond currently implemented sheep/switch/portal/destination flow)
- [ ] P2-03: Non-map parity audit and implementation (quests/resources/pets/crafting loops)

## Remaining high-level work checklist

- [x] Fix `SproutedArenaLevel.createMobs()` generation soft-lock (outer retry bail-out added)
- [ ] Finish deep behavior parity pass for Town/Mine/Fortress/Catacomb branches (P2-01)
- [ ] Finish deep behavior parity pass for all Sokoban puzzle mechanics and fail/retry flow (P2-02)
- [ ] Complete P2-03 non-map subsystem work (see detailed breakdown below)

## P2-03 Non-map subsystem detailed breakdown

### Items with no behavior yet (just image/stub)
- [x] `TownReturnBeacon` — implemented `AC_USE` execute() to return hero to Town (branch 2 depth 23) via `InterlevelScene.Mode.RETURN`
- [ ] `SanChikarahTranscend` — needs actual power effect (buff, stat boost, or unique mechanic)
- [ ] `SanChikarah` base — consider shared power if any; currently only `image` + `unique = true`
- [ ] `FishingBomb` — extends `Bomb` but should stun water creatures; needs `onThrow()` override
- [ ] `HolyHandGrenade` — extends `Bomb` but should deal extra damage to DEMONIC/UNDEAD; needs `onThrow()` override or `explode()` override
- [ ] `StoneOre` — raw ore with no crafting use; needs recipe or shop-sale context

### Mobs missing loot/behavior
- [x] `Gullin` — now drops a random `NornStone` at 50% chance
- [ ] Verify other Sprouted mobs have correct drop tables (audit needed)

### Quest / progression loop items
- [ ] **SanChikarah merge mechanic**: combining `SanChikarahLife` + `SanChikarahDeath` → `SanChikarahTranscend` (via altar or `Item.combine()`)
- [ ] **Norn stone altar in Town**: Tinkerer5 references "temple east of town, 3 Norn stones → reward" — altar room, stone counter, reward item needed
- [ ] **Tinkerer mushroom trade**: Tinkerer2 says "bring me toadstool mushrooms" — needs actual trade window (offer `Mushroom` → receive item)
- [ ] **Mushroom** — currently only has food value; confirm if it should have special properties

### NPC interaction completeness
- [x] Tinkerer1–5 interact dialogs (complete)
- [ ] Shopkeeper×2 in Town — confirm inventory set via `storeRefresh()` covers all relevant tiers
- [ ] Tinkerer2 mushroom trade interaction (not just dialog)

### Crafting / Generator
- [ ] `Generator.NORNSTONE` category — verify it's in `Generator` and used by any room/chest tables
- [ ] Verify `NornStone` color variants have distinct effects or confirm generic value-only design is correct

## End-of-session update checklist (run every session)

- [ ] Update this file's status checkboxes to reflect newly completed work
- [ ] Add a short session log entry with date, completed items, and next priority
- [ ] Keep links in `docs/sprouted-feature-checklist.md` and `docs/sprouted-behavior-backlog.md` aligned with this master checklist

## Session log

- [x] 2026-05-16 (session 1): Added this master checklist; synced status with current Sprouted feature checklist + behavior backlog and recent P2-02/P0-03 updates.
  - Completed this session: deterministic teleport/vault layout regression checks + exact Sprouted route mapping assertions.
  - Next priority: P0-02 and P1-03 map-size/pacing parity tuning.

- [x] 2026-05-17 (session 2): Fixed `SproutedArenaLevel.createMobs()` soft-lock; implemented `TownReturnBeacon.execute()` (town teleport); added `NornStone.randomNornStone()` factory and wired it as `Gullin` loot at 50%; marked P0-02 and P1-03 complete; expanded P2-03 with detailed subsystem audit.
  - Next priority: SanChikarah merge mechanic + Norn stone altar + FishingBomb/HolyHandGrenade special effects.
