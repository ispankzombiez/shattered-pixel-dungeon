package com.shatteredpixel.shatteredpixeldungeon.levels;

// SPROUTED_RESERVED: Boss level for Zot — Catacomb section end-boss.
// Intended routing: branch 2 depth 23, immediately before the Town hub.
// Wiring this requires sliding TownLevel and all subsequent Sprouted branch
// depths (formerly 23-30) up by one position to 24-31.
// Not currently wired in Layouts.branchLevel() — reserved for when the Catacomb
// boss encounter (Zot NPC/fight) is fully designed and the depth-range shift is
// approved.
public class ZotBossLevel extends HallsBossLevel {
}
