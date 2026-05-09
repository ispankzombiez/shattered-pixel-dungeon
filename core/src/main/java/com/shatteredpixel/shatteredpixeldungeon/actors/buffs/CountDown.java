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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ShadowParticle;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;

public class CountDown extends Buff {

	{
		type = buffType.NEGATIVE;
		announced = true;
	}

	private int ticks = 0;
	private static final String TICKS = "ticks";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( TICKS, ticks );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		ticks = bundle.getInt( TICKS );
	}

	@Override
	public int icon() {
		return BuffIndicator.TIME;
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public boolean act() {
		if (target.isAlive()) {
			ticks++;
			GLog.w( Messages.get(this, "ticking", 6 - ticks) );
			if (ticks > 5) {
				GLog.w( Messages.get(this, "expired") );
				target.sprite.emitter().burst( ShadowParticle.CURSE, 6 );
				target.damage( Math.round(target.HT / 4f), this );
				detach();
			}
		} else {
			detach();
		}
		spend( TICK );
		return true;
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", 6 - ticks);
	}
}
