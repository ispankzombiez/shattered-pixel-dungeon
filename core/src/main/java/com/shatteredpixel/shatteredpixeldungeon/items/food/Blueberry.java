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

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Awareness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.BerryRegeneration;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Blueberry extends Berry {

	{
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		if (Random.Float() >= 0.75f) {
			Buff.affect( hero, BerryRegeneration.class ).level( hero.HT * 2 );
			GLog.w( Messages.get(this, "energy") );
		}

		revealCurrentFloor();
		GLog.p( Messages.get(this, "mapping") );
		Buff.affect( hero, Awareness.class, 10f );
		Dungeon.observe();
	}

	private void revealCurrentFloor() {
		boolean noticed = false;

		for (int i = 0; i < Dungeon.level.length(); i++) {
			int terr = Dungeon.level.map[i];
			if (Dungeon.level.discoverable[i]) {
				Dungeon.level.mapped[i] = true;
				if ((Terrain.flags[terr] & Terrain.SECRET) != 0) {
					Dungeon.level.discover( i );
					if (Dungeon.level.heroFOV[i]) {
						GameScene.discoverTile( i, terr );
						ScrollOfMagicMapping.discover( i );
						noticed = true;
					}
				}
			}
		}

		GameScene.updateFog();
		if (noticed) {
			Sample.INSTANCE.play( Assets.Sounds.SECRET );
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public Blueberry() {
		this( 1 );
	}

	public Blueberry( int quantity ) {
		this.quantity = quantity;
	}
}
