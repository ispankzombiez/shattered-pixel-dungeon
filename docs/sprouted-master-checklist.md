# Sprouted Master Implementation Checklist

This is the **single session-by-session checklist** for overall Sprouted parity progress.
Update this file at the end of each work session.

## Overall progress

- [x] Path-level Sprouted class coverage complete (`docs/sprouted-feature-checklist.md`: 543 checked, 0 unchecked)
- [x] P0-01: Sprouted branch-route fallback guard + exception reporting
- [ ] P0-02: Large-floor map-size profile parity (generation sizing + pacing tuning)
- [x] P0-03: Deterministic Sprouted seed regression task (`:core:sproutedSeedChecks`)
- [x] P1-01: Town authored layouts integrated in active generation flow
- [x] P1-02: Sokoban authored layouts integrated in active generation flow
- [ ] P1-03: Branch-area pacing fully tuned for enlarged floor profiles
- [ ] P2-01: Full Town/Mine/Fortress/Catacomb behavior parity (beyond currently implemented events)
- [ ] P2-02: Full Sokoban puzzle parity (beyond currently implemented sheep/switch/portal/destination flow)
- [ ] P2-03: Non-map parity audit and implementation (quests/resources/pets/crafting loops)

## Remaining high-level work checklist

- [ ] Finalize map-size parity tuning for all relevant branch/depth combinations
- [ ] Complete branch pacing validation (mob/trap/item density) for enlarged maps
- [ ] Finish deep behavior parity pass for Town/Mine/Fortress/Catacomb branches
- [ ] Finish deep behavior parity pass for all Sokoban puzzle mechanics and fail/retry flow
- [ ] Complete non-map subsystem audit (quests/resources/pets/crafting) with deterministic verification coverage

## End-of-session update checklist (run every session)

- [ ] Update this file’s status checkboxes to reflect newly completed work
- [ ] Add a short session log entry with date, completed items, and next priority
- [ ] Keep links in `docs/sprouted-feature-checklist.md` and `docs/sprouted-behavior-backlog.md` aligned with this master checklist

## Session log

- [x] 2026-05-16: Added this master checklist; synced status with current Sprouted feature checklist + behavior backlog and recent P2-02/P0-03 updates.
  - Completed this session: deterministic teleport/vault layout regression checks + exact Sprouted route mapping assertions.
  - Next priority: P0-02 and P1-03 map-size/pacing parity tuning.
