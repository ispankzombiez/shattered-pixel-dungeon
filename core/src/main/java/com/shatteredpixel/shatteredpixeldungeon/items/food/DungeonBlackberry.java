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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Healing;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MindVision;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

/**
 * Ported from Sprouted Pixel Dungeon (Blackberry).
 *
 * A dungeon berry that provides minor restorative regeneration
 * and has a 10% chance to grant Mind Vision.
 */
public class DungeonBlackberry extends Food {

	{
		image = ItemSpriteSheet.BERRY;
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f; // 15 food value — very light snack

		bones = false;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		if (Random.Int(10) == 1) {
			// 10% chance: MindVision + stronger healing burst
			GLog.w( Messages.get(this, "trippy") );
			Buff.affect( hero, MindVision.class, MindVision.DURATION );
			Dungeon.observe();

			Healing healing = Buff.affect( hero, Healing.class );
			healing.setHeal( hero.HT, 0.1f, 0 );

			GLog.i( Messages.get(this, "energy_burst") );
		} else {
			// Normal: minor healing over time
			GLog.i( Messages.get(this, "energy") );
			Healing healing = Buff.affect( hero, Healing.class );
			healing.setHeal( hero.HT / 2, 0.1f, 0 );
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public DungeonBlackberry() {
		this( 1 );
	}

	public DungeonBlackberry( int value ) {
		this.quantity = value;
	}
}
