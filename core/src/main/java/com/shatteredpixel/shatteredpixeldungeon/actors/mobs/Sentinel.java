package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SentinelSprite;
import com.watabou.utils.Random;

public class Sentinel extends Mob {

	{
		spriteClass = SentinelSprite.class;

		HP = HT = 45;
		defenseSkill = 16;

		EXP = 10;
		maxLvl = 22;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 20;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
