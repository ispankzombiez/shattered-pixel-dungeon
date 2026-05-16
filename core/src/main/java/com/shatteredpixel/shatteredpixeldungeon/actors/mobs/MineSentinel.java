package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SentinelSprite;
import com.watabou.utils.Random;

public class MineSentinel extends Mob {

	{
		spriteClass = SentinelSprite.class;

		HP = HT = 40;
		defenseSkill = 14;

		EXP = 9;
		maxLvl = 18;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(7, 15);
	}

	@Override
	public int attackSkill(Char target) {
		return 18;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}
}
