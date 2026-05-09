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

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.FloatingText;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class GoldenNut extends Nut {

	{
		image = ItemSpriteSheet.BLANDFRUIT;
		energy = com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger.STARVING;
	}

	@Override
	protected void satisfy( Hero hero ) {
		super.satisfy( hero );

		boolean greaterBlessing = Random.Int(2) == 0;
		int htBoost = greaterBlessing ? 50 : 20;
		int strBoost = greaterBlessing ? 5 : 2;

		GLog.w( Messages.get(this, greaterBlessing ? "greater_blessing" : "blessing") );

		hero.HTBoost += htBoost;
		hero.updateHT( true );
		hero.STR += strBoost;
		hero.sprite.showStatus( CharSprite.POSITIVE, "+" + htBoost + " HT" );
		hero.sprite.showStatusWithIcon( CharSprite.POSITIVE, Integer.toString(strBoost), FloatingText.STRENGTH );
		GLog.p( Messages.get(this, "surge") );

		Badges.validateStrengthAttained();
		Badges.validateDuelistUnlock();
	}

	@Override
	public int value() {
		return 20 * quantity;
	}
}
