package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GullinSprite;
import com.watabou.utils.Random;

public class Gullin extends Mob {

	{
		spriteClass = GullinSprite.class;

		HP = HT = 120;
		defenseSkill = 40;

		EXP = 25;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(18, 32);
	}

	@Override
	public int attackSkill(Char target) {
		return 44;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
