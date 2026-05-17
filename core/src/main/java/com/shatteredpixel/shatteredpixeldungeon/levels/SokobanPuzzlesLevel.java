package com.shatteredpixel.shatteredpixeldungeon.levels;

// First set of Sokoban puzzles.
public class SokobanPuzzlesLevel extends SproutedSokobanLevel {

	@Override
	protected String[] sokobanLayout() {
		return SokobanLayouts.randomLayout();
	}
}
