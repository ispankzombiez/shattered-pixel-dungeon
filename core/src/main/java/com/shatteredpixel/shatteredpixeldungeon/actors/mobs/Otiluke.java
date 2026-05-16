package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.OtilukeSprite;
import com.watabou.utils.Random;

public class Otiluke extends Mob {

	{
		spriteClass = OtilukeSprite.class;

		HP = HT = 250;
		defenseSkill = 38;

		EXP = 40;
		maxLvl = -2;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(18, 32);
	}

	@Override
	public int attackSkill(Char target) {
		return 42;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
