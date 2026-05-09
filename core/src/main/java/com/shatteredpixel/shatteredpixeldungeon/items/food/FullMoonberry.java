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

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Light;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

public class FullMoonberry extends Berry {

	{
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		GLog.w( Messages.get(this, "strength") );
		Buff.affect( hero, Adrenaline.class, Adrenaline.DURATION * 2f );
		Barkskin.conditionallyAppend( hero, hero.HT, 10 );
		Buff.affect( hero, Light.class, Light.DURATION );
		GLog.i( Messages.get(this, "warding") );
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public FullMoonberry() {
		this( 1 );
	}

	public FullMoonberry( int quantity ) {
		this.quantity = quantity;
	}
}
