package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanCornerSheepSprite;

public class SheepSokobanCorner extends NPC {

	{
		spriteClass = SokobanCornerSheepSprite.class;

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
