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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Roots;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

/**
 * Ported from Sprouted Pixel Dungeon (GoldenJelly).
 *
 * A gelatinous mushroom covered in a sticky ooze. Eating it releases
 * spores that root all mobs on the floor, but also causes Vertigo.
 * Cannot be eaten on boss floors.
 */
public class GoldenJellyMushroom extends Food {

	{
		image = ItemSpriteSheet.STEWED;
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f; // 15 food value — risky, small snack

		bones = false;
	}

	@Override
	public void execute( Hero hero, String action ) {

		if (action.equals( AC_EAT )) {
			if (Dungeon.bossLevel()) {
				GLog.w( Messages.get(this, "prevented") );
				return;
			}
		}

		super.execute( hero, action );
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		GLog.w( Messages.get(this, "effect") );

		if (Random.Int(10) == 1) {
			// 10% rare outcome: stronger root, shorter vertigo
			for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
				Buff.prolong( mob, Roots.class, 20f );
			}
			Buff.affect( hero, Vertigo.class, 1f );
		} else {
			// Normal: moderate root, longer vertigo
			for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
				Buff.prolong( mob, Roots.class, 10f );
			}
			Buff.affect( hero, Vertigo.class, 3f );
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public GoldenJellyMushroom() {
		this( 1 );
	}

	public GoldenJellyMushroom( int value ) {
		this.quantity = value;
	}
}
