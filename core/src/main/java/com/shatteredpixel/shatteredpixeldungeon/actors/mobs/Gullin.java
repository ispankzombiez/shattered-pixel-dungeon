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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroClass;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.watabou.utils.Random;

/**
 * Ported from Sprouted Pixel Dungeon.
 *
 * Gullin is a golden-maned boar demon that drops a random NornStone on death
 * (Huntress gets any color; other classes get from the non-Green pool).
 */
public class Gullin extends Gnoll {

	// 60% chance (3 in 5) to drop a NornStone on death, matching Sprouted PD behaviour
	private static final int NORNSTONE_DROP_CHANCE_IN = 3;
	private static final int NORNSTONE_DROP_CHANCE_OUT_OF = 5;

	@Override
	public void die( Object cause ) {
		if (Random.Int(NORNSTONE_DROP_CHANCE_OUT_OF) < NORNSTONE_DROP_CHANCE_IN) {
			Generator.Category cat = Dungeon.hero.heroClass == HeroClass.HUNTRESS
					? Generator.Category.NORNSTONE
					: Generator.Category.NORNSTONE2;
			Dungeon.level.drop( Generator.random( cat ), pos ).sprite.drop();
		}
		super.die( cause );
	}
}
