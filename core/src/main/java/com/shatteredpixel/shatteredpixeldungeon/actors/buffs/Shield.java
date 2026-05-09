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

import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.watabou.noosa.Image;
import com.watabou.utils.Bundle;

public class Shield extends Buff {

	public static final float LEVEL = 0.4f;

	{
		type = buffType.POSITIVE;
		announced = true;
	}

	private int hits = Math.max( 2, Math.round( Statistics.deepestFloor / 5f ) + 3 );
	private static final String HITS = "hits";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( HITS, hits );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		hits = bundle.getInt( HITS );
	}

	@Override
	public int icon() {
		return BuffIndicator.ARMOR;
	}

	@Override
	public void tintIcon( Image icon ) {
		icon.hardlight( 0.5f, 0.7f, 1f );
	}

	@Override
	public String iconTextDisplay() {
		return Integer.toString( hits );
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", hits);
	}

	@Override
	public void detach() {
		hits--;
		if (hits <= 0) {
			super.detach();
		}
	}

	@Override
	public boolean act() {
		spend( TICK );
		return true;
	}
}
