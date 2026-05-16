package com.shatteredpixel.shatteredpixeldungeon.levels;

// Sokoban level guarding the vault.
public class SokobanVaultLevel extends SproutedSokobanLevel {

	@Override
	protected String[] sokobanLayout() {
		return SokobanLayouts2.randomVaultLayout();
	}

	@Override
	protected boolean lockExitUntilSwitchesSolved() {
		return true;
	}
}
