/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * Sprouted Pixel Dungeon
 * Copyright (C) 2015 dachhack
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

package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.WaterOfUpgradeEating;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

/**
 * Ported from Sprouted Pixel Dungeon.
 *
 * The Flytrap (Upgrade Eater) seeds a WaterOfUpgradeEating blob when planted.
 * Items dropped into the resulting water have a chance to be converted into
 * random plant seeds.
 */
public class Flytrap extends Plant {

	{
		image = 8; // placeholder tile index
		seedClass = Seed.class;
	}

	@Override
	public void activate( Char ch ) {
		// Flytrap has no on-trample effect; its magic is in couch()
	}

	public static class Seed extends Plant.Seed {
		{
			image = ItemSpriteSheet.SEED_HOLDER; // placeholder until dedicated sprite

			plantClass = Flytrap.class;
		}

		@Override
		public Plant couch( int pos, Level level ) {
			if (level != null) {
				Blob.seed( pos, 1, WaterOfUpgradeEating.class, level );
			}
			return super.couch( pos, level );
		}
	}

	/** Returns true if there is active WaterOfUpgradeEating on the current level. */
	public static boolean checkWater() {
		WaterOfUpgradeEating water =
				(WaterOfUpgradeEating) Dungeon.level.blobs.get( WaterOfUpgradeEating.class );
		return water != null && water.volume > 0;
	}
}
