package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GreyRatSprite;
import com.watabou.utils.Random;

public class GreyRat extends Mob {

	{
		spriteClass = GreyRatSprite.class;

		HP = HT = 10;
		defenseSkill = 3;

		EXP = 1;
		maxLvl = 6;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(1, 5);
	}

	@Override
	public int attackSkill(Char target) {
		return 9;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 1);
	}
}
