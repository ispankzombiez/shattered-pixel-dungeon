package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BrownBatSprite;
import com.watabou.utils.Random;

public class BrownBat extends Mob {

	{
		spriteClass = BrownBatSprite.class;

		HP = HT = 12;
		defenseSkill = 5;
		baseSpeed = 1.5f;

		EXP = 2;
		maxLvl = 5;

		flying = true;
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
		return super.drRoll() + Random.NormalIntRange(0, 2);
	}
}
