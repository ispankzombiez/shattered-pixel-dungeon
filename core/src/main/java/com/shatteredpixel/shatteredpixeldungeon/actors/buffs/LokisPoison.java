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

package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

public class LokisPoison extends Buff implements Hero.Doom {

	{
		type = buffType.NEGATIVE;
		announced = true;
	}

	protected float left;
	private static final String LEFT = "left";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( LEFT, left );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		left = bundle.getFloat( LEFT );
	}

	public void set( float duration ) {
		this.left = Math.max( duration, left );
	}

	@Override
	public int icon() {
		return BuffIndicator.POISON;
	}

	@Override
	public void tintIcon( Image icon ) {
		icon.hardlight( 0.9f, 0f, 0f );
	}

	public String iconTextDisplay() {
		return Integer.toString( (int) left );
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public boolean act() {
		if (target.isAlive()) {
			target.damage( (int)(left / 2) + 1, this );
			spend( TICK );
			if ((left -= TICK) <= 0) {
				detach();
			}
		} else {
			detach();
		}
		return true;
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", dispTurns( left ));
	}

	@Override
	public void onDeath() {
		Badges.validateDeathFromPoison();
		Dungeon.fail( this );
		GLog.n( Messages.get(this, "ondeath") );
	}
}
