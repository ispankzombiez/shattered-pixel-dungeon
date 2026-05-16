package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.FlyingProtectorSprite;
import com.watabou.utils.Random;

public class FlyingProtector extends Mob {

	{
		spriteClass = FlyingProtectorSprite.class;

		HP = HT = 70;
		defenseSkill = 30;
		baseSpeed = 1.5f;

		EXP = 14;
		maxLvl = 36;

		flying = true;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 24);
	}

	@Override
	public int attackSkill(Char target) {
		return 33;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
