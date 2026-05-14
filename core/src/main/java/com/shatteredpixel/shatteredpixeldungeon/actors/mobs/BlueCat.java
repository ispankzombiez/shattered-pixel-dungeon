package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BatSprite;
import com.watabou.utils.Random;

public class BlueCat extends Mob {

	{
		spriteClass = BatSprite.class;

		HP = HT = 20;
		defenseSkill = 14;
		baseSpeed = 1.5f;

		EXP = 6;
		maxLvl = 18;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(5, 13);
	}

	@Override
	public int attackSkill(Char target) {
		return 16;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 3);
	}
}
