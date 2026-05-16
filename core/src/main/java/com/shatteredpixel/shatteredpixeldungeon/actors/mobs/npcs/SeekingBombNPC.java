package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SeekingBombSprite;

public class SeekingBombNPC extends NPC {

	{
		spriteClass = SeekingBombSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	protected boolean interact(Char c) {
		return true;
	}
}
