package com.shatteredpixel.shatteredpixeldungeon.levels;

// Second set of Sokoban puzzles.
public class SokobanPuzzles2Level extends SproutedSokobanLevel {

	@Override
	protected String[] sokobanLayout() {
		return SokobanLayouts2.randomLayout();
	}
}
