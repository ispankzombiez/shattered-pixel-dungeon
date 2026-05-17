package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.ActivatePortalTrap;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.SokobanPortalTrap;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.Trap;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.watabou.utils.Bundle;

public abstract class SproutedSokobanLevel extends RegularLevel {

	protected abstract String[] sokobanLayout();

	protected boolean lockExitUntilSwitchesSolved() {
		return false;
	}

	@Override
	protected boolean build() {
		boolean built = super.build();
		if (built) {
			SproutedLayoutStamp.LayoutMetadata layout = SproutedLayoutStamp.centerStamp(this, sokobanLayout(), true);
			configurePortalNetwork(layout);
			refreshSokobanExitState(false);
		}
		return built;
	}

	@Override
	protected Painter painter() {
		return new SewerPainter()
				.setTraps(nTraps(), trapClasses(), trapChances());
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		refreshSokobanExitState(false);
	}

	public void onSokobanSwitchTriggered() {
		refreshSokobanExitState(true);
	}

	private void configurePortalNetwork(SproutedLayoutStamp.LayoutMetadata layout) {
		int links = Math.min(layout.portalCells.size(), Math.min(layout.switchCells.size(), layout.destinationCells.size()));
		for (int i = 0; i < links; i++) {
			Trap switchTrap = traps.get(layout.switchCells.get(i));
			if (switchTrap instanceof ActivatePortalTrap) {
				((ActivatePortalTrap) switchTrap).linkToPortal(layout.portalCells.get(i), layout.destinationCells.get(i));
			}

			Trap portalTrap = traps.get(layout.portalCells.get(i));
			if (portalTrap instanceof SokobanPortalTrap) {
				((SokobanPortalTrap) portalTrap).setDestination(layout.destinationCells.get(i));
			}
		}
	}

	private void refreshSokobanExitState(boolean runtime) {
		if (!lockExitUntilSwitchesSolved() || exit <= 0 || exit >= length()) {
			return;
		}

		int targetTerrain = allSokobanSwitchesConsumed() ? Terrain.UNLOCKED_EXIT : Terrain.LOCKED_EXIT;
		if (map[exit] == targetTerrain) {
			return;
		}
		if (map[exit] != Terrain.EXIT && map[exit] != Terrain.LOCKED_EXIT && map[exit] != Terrain.UNLOCKED_EXIT) {
			return;
		}

		Level.set(exit, targetTerrain, this);
		if (runtime && Dungeon.level == this) {
			GameScene.updateMap(exit);
			Dungeon.observe();
		}
	}

	private boolean allSokobanSwitchesConsumed() {
		boolean sawSwitch = false;
		for (Trap trap : traps.valueList()) {
			if (trap instanceof ActivatePortalTrap) {
				sawSwitch = true;
				if (trap.active) {
					return false;
				}
			}
		}
		return sawSwitch;
	}
}
