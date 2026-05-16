package com.shatteredpixel.shatteredpixeldungeon.items.armor.glyphs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;

public class AntiEntropy extends Armor.Glyph {

	@Override
	public int proc(Armor armor, Char attacker, Char defender, int damage) {
		return damage;
	}

	@Override
	public ItemSprite.Glowing glowing() {
		return null;
	}
}
