/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.levels.traps;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.SheepSokoban;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.SheepSokobanCorner;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.SheepSokobanSwitch;
import com.shatteredpixel.shatteredpixeldungeon.levels.SproutedSokobanLevel;
import com.watabou.utils.Bundle;

public class ActivatePortalTrap extends Trap {

	private static final String LINKED_PORTAL_POS = "linked_portal_pos";
	private static final String DESTINATION_POS = "destination_pos";

	private int linkedPortalPos = -1;
	private int destinationPos = -1;

	{
		color = VIOLET;
		shape = STARS;
		disarmedByActivation = false;
	}

	public void linkToPortal(int portalPos, int destinationPos) {
		this.linkedPortalPos = portalPos;
		this.destinationPos = destinationPos;
	}

	@Override
	public void activate() {
		Char ch = Actor.findChar(pos);
		if (ch instanceof SheepSokoban || ch instanceof SheepSokobanCorner || ch instanceof SheepSokobanSwitch) {
			if (linkedPortalPos >= 0) {
				Trap linkedTrap = Dungeon.level.traps.get(linkedPortalPos);
				if (linkedTrap instanceof SokobanPortalTrap) {
					((SokobanPortalTrap) linkedTrap).armPortal(destinationPos);
				}
			} else {
				for (Trap trap : Dungeon.level.traps.valueList()) {
					if (trap instanceof SokobanPortalTrap) {
						((SokobanPortalTrap) trap).armPortal(-1);
					}
				}
			}
			disarm();
			if (Dungeon.level instanceof SproutedSokobanLevel) {
				((SproutedSokobanLevel) Dungeon.level).onSokobanSwitchTriggered();
			}
		}
	}

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(LINKED_PORTAL_POS, linkedPortalPos);
		bundle.put(DESTINATION_POS, destinationPos);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		if (bundle.contains(LINKED_PORTAL_POS)) {
			linkedPortalPos = bundle.getInt(LINKED_PORTAL_POS);
		}
		if (bundle.contains(DESTINATION_POS)) {
			destinationPos = bundle.getInt(DESTINATION_POS);
		}
	}
}
