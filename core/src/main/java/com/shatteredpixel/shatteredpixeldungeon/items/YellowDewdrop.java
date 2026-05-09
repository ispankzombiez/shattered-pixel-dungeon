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

package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.journal.Catalog;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.noosa.audio.Sample;

/**
 * A yellow dewdrop from Sprouted Pixel Dungeon.
 * Worth 2x a normal dewdrop when collected into the dew vial.
 */
public class YellowDewdrop extends Item {

	{
		image = ItemSpriteSheet.DEWDROP;

		stackable = true;
		dropsDownHeap = true;
	}

	@Override
	public boolean doPickUp( Hero hero, int pos ) {

		Waterskin flask = hero.belongings.getItem( Waterskin.class );
		Catalog.setSeen(getClass());
		Statistics.itemTypesDiscovered.add(getClass());

		if (flask != null && !flask.isFull()) {
			flask.collectYellowDew( quantity );
			GameScene.pickUp( this, pos );
		} else {
			// No vial or vial full: heal directly (yellow = 2 drops worth of healing)
			if (!Dewdrop.consumeDew(2 * quantity, hero, false)) {
				return false;
			} else {
				Catalog.countUse(getClass());
			}
		}

		Sample.INSTANCE.play( Assets.Sounds.DEWDROP );
		hero.spendAndNext( pickupDelay() );
		return true;
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	@Override
	public Item merge( Item other ) {
		if (isSimilar(other)) {
			quantity += other.quantity;
			other.quantity = 0;
		}
		return this;
	}
}
