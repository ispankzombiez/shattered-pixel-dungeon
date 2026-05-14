package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.YogSprite;
import com.watabou.utils.Random;

public class Yog extends Mob {

	{
		spriteClass = YogSprite.class;

		HP = HT = 350;
		defenseSkill = 35;

		EXP = 50;
		maxLvl = -2;

		properties.add(Property.BOSS);
		properties.add(Property.DEMONIC);
		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(18, 35);
	}

	@Override
	public int attackSkill(Char target) {
		return 38;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
