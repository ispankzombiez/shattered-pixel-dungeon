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

public class ActivatePortalTrap extends Trap {

	{
		color = VIOLET;
		shape = STARS;
		disarmedByActivation = false;
	}

	@Override
	public void activate() {
		Char ch = Actor.findChar(pos);
		if (ch instanceof SheepSokoban || ch instanceof SheepSokobanCorner || ch instanceof SheepSokobanSwitch) {
			for (Trap trap : Dungeon.level.traps.valueList()) {
				if (trap instanceof SokobanPortalTrap) {
					((SokobanPortalTrap) trap).armPortal();
				}
			}
			disarm();
		}
	}
}
