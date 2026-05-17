package com.shatteredpixel.shatteredpixeldungeon.levels;

// Sokoban level with teleporter mechanics.
public class SokobanTeleportLevel extends SproutedSokobanLevel {

	@Override
	protected String[] sokobanLayout() {
		return SokobanLayouts.randomTeleportLayout();
	}

	@Override
	protected boolean lockExitUntilSwitchesSolved() {
		return true;
	}
}
