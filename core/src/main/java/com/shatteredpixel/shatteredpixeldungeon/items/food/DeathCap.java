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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class DeathCap extends Food {

	{
		image = ItemSpriteSheet.BLAND_CHUNKS;
		energy = (Hunger.STARVING - Hunger.HUNGRY) / 10f;

		bones = false;
	}

	@Override
	public void execute( Hero hero, String action ) {
		if (action.equals( AC_EAT ) && Dungeon.bossLevel()) {
			GLog.w( Messages.get(this, "prevented") );
			return;
		}

		super.execute( hero, action );
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		GLog.w( Messages.get(this, "effect") );

		boolean rareRoll = Random.Int(10) == 0;
		for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
			mob.damage( Math.max(rareRoll ? 5 : 3, Math.round(mob.HP / 2f)), this );
			if (!rareRoll) {
				mob.aggro( hero );
			}
		}

		hero.damage( Math.max(1, Math.round(hero.HP / 4f)), this );
		Buff.prolong( hero, Blindness.class, rareRoll ? Random.IntRange(5, 7) : Random.IntRange(6, 9) );
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public DeathCap() {
		this( 1 );
	}

	public DeathCap( int quantity ) {
		this.quantity = quantity;
	}
}
