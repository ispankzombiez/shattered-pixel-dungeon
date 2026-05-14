package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RatBossSprite;
import com.watabou.utils.Random;

public class RatBoss extends Mob {

	{
		spriteClass = RatBossSprite.class;

		HP = HT = 30;
		defenseSkill = 5;
		baseSpeed = 1.5f;

		EXP = 5;
		maxLvl = 8;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(2, 8);
	}

	@Override
	public int attackSkill(Char target) {
		return 11;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 2);
	}
}
