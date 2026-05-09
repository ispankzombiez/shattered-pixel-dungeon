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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.BerryRegeneration;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MindVision;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Blackberry extends Berry {

	{
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		BerryRegeneration regeneration = Buff.affect( hero, BerryRegeneration.class );
		if (Random.Int(10) == 0) {
			GLog.w( Messages.get(this, "trippy") );
			Buff.affect( hero, MindVision.class, MindVision.DURATION );
			Dungeon.observe();
			regeneration.level( hero.HT * 2 );
			GLog.i( Messages.get(this, "energy_burst") );
		} else {
			regeneration.level( hero.HT / 2 );
			GLog.i( Messages.get(this, "energy") );
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public Blackberry() {
		this( 1 );
	}

	public Blackberry( int quantity ) {
		this.quantity = quantity;
	}
}
