package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MonsterBoxSprite;
import com.watabou.utils.Random;

public class MonsterBox extends Mob {

	{
		spriteClass = MonsterBoxSprite.class;

		HP = HT = 50;
		defenseSkill = 18;

		EXP = 10;
		maxLvl = 25;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 16);
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
