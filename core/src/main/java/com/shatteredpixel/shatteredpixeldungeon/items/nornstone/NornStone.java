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

package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

/**
 * Ported from Sprouted Pixel Dungeon.
 *
 * Norn stones are rare gem-like items dropped by Gullin. Each color variant
 * is kept as a distinct class so that Generator.NORNSTONE can randomly pick
 * among them and individual quests or shops can reference a specific color.
 */
public class NornStone extends Item {

	{
		stackable = true;
		image = ItemSpriteSheet.GOLD; // placeholder sprite until dedicated art is available
		bones = false;
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
	public int value() {
		return 1000 * quantity;
	}

	@SuppressWarnings("unchecked")
	private static final Class<? extends NornStone>[] VARIANTS = new Class[]{
		BlueNornStone.class, GreenNornStone.class, OrangeNornStone.class,
		PurpleNornStone.class, YellowNornStone.class
	};

	public static NornStone randomNornStone() {
		try {
			return Random.element(VARIANTS).newInstance();
		} catch (Exception e) {
			return new BlueNornStone();
		}
	}
}
