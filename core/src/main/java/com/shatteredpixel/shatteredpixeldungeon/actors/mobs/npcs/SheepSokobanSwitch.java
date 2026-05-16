package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanSheepSwitchSprite;

public class SheepSokobanSwitch extends NPC {

	{
		spriteClass = SokobanSheepSwitchSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	public boolean interact(Char c) {
		return true;
	}
}
