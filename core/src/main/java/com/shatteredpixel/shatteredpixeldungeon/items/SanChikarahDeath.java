package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

// SanChikarah attuned to death energy.
public class SanChikarahDeath extends SanChikarah {

	@Override
	public boolean doPickUp(Hero hero, int pos) {
		if (super.doPickUp(hero, pos)) {
			Dungeon.sanchikarahdeath = false;
			return true;
		}
		return false;
	}
}
