package com.shatteredpixel.shatteredpixeldungeon.levels;

// Introductory Sokoban puzzle level.
public class SokobanIntroLevel extends SproutedSokobanLevel {

	@Override
	protected String[] sokobanLayout() {
		return SokobanLayouts.randomLayout();
	}
}
