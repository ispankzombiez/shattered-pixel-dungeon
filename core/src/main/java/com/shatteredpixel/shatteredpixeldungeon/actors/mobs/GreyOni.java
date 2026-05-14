package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GreyOniSprite;
import com.watabou.utils.Random;

public class GreyOni extends Oni {

	{
		spriteClass = GreyOniSprite.class;

		HP = HT = 85;
		defenseSkill = 32;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(15, 28);
	}

	@Override
	public int attackSkill(Char target) {
		return 35;
	}
}
