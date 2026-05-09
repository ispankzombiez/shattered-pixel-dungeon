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

package com.shatteredpixel.shatteredpixeldungeon.actors.blobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.BlobEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.watabou.utils.Bundle;

public class Alter extends Blob {

	protected int pos;

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		for (int i = 0; i < cur.length; i++) {
			if (cur[i] > 0) {
				pos = i;
				break;
			}
		}
	}

	@Override
	protected void evolve() {
		if (pos >= 0 && pos < cur.length) {
			off[pos] = cur[pos];
			volume += off[pos];
		}
	}

	@Override
	public void seed( int cell, int amount ) {
		if (cur != null && pos < cur.length) cur[pos] = 0;
		pos = cell;
		if (cur != null && pos < cur.length) {
			volume = cur[pos] = amount;
		}
	}

	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		emitter.start( Speck.factory( Speck.LIGHT ), 0.4f, 0 );
	}

	@Override
	public String tileDesc() {
		return "An altar of consecration stands here. Items left upon it may be blessed.";
	}
}
