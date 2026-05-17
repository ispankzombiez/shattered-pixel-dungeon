package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanSheepSprite;
import com.watabou.utils.Random;

public class SheepSokobanStop extends NPC {

	private static final String[] QUOTES = {"Baa!", "Baa?", "Baa.", "Baa..."};

	{
		spriteClass = SokobanSheepSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	public boolean interact(Char c) {
		sprite.showStatus(CharSprite.NEUTRAL, Random.element(QUOTES));
		return true;
	}
}
