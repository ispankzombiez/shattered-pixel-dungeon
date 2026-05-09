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

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.BerryRegeneration;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Levitation;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Cloudberry extends Berry {

	private static final float LEVITATION_DURATION = 10f;
	private static final int REGEN_ROLL = 9;

	{
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		Buff.affect( hero, Haste.class, Haste.DURATION );
		GLog.i( Messages.get(this, "speed") );

		int effectRoll = Random.Int(10);
		if (effectRoll >= 6) {
			Buff.affect( hero, Levitation.class, effectRoll == REGEN_ROLL ? LEVITATION_DURATION * 2 : LEVITATION_DURATION );
			GLog.i( Messages.get(this, "levitating") );
		}

		if (effectRoll == REGEN_ROLL) {
			Buff.affect( hero, BerryRegeneration.class ).level( hero.HT );
			GLog.w( Messages.get(this, "energy") );
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public Cloudberry() {
		this( 1 );
	}

	public Cloudberry( int quantity ) {
		this.quantity = quantity;
	}
}
