package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.AssassinSprite;
import com.watabou.utils.Random;

public class Assassin extends Mob {

	{
		spriteClass = AssassinSprite.class;

		HP = HT = 22;
		defenseSkill = 13;
		baseSpeed = 1.2f;

		EXP = 6;
		maxLvl = 12;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(4, 12);
	}

	@Override
	public int attackSkill(Char target) {
		return 16;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 2);
	}
}
