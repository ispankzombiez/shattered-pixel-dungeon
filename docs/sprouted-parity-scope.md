# Sprouted Parity Scope & Acceptance Criteria

## Scope decision

This repository now targets **strict Sprouted behavior parity** for Sprouted branch content, with Shattered balancing retained only where parity data is unavailable or technically blocked.

## Frozen reference

- Source repository: `esunsatyr/SproutedPixelDungeon-Gradle` (public mirror of dachhack history)
- Freeze timestamp: `2026-05-16T21:53:07Z`
- Frozen ref: `846f4797130f41502c765a9655e8a132eebc6103`

## Acceptance criteria

A parity item is considered complete only when all are true:

1. **Implemented path**: matching class/path exists in this repo.
2. **Wired/in use**: gameplay flow can reach and exercise the feature.
3. **Behavior parity verified**: output/logic matches Sprouted reference for deterministic seeds and branch progression paths.

## System matrix (high-level)

| System | Target |
|---|---|
| Levels / generation | Strict parity on Sprouted branch generation, routing, and transition semantics |
| Quests | Strict parity for branch quest triggers/gates/rewards |
| Items / loot / resources | Strict parity where Sprouted item loop is branch-critical |
| Mobs / NPCs / pets | Strict parity for spawn composition, branch interactions, and special behaviors |
| Buffs / status effects | Strict parity for Sprouted-introduced effects |
| UI / progression messaging | Functionally equivalent parity for branch flow clarity |
| Economy / progression | Strict parity for required keys/pickups and win/loss flow |
| Branch routing | Strict parity for depth/branch mapping and backtracking |
