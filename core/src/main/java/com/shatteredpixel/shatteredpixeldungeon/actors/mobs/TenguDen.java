package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TenguSprite;
import com.watabou.utils.Random;

public class TenguDen extends Mob {

	{
		spriteClass = TenguSprite.class;

		HP = HT = 100;
		defenseSkill = 35;

		EXP = 20;
		maxLvl = 40;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(16, 30);
	}

	@Override
	public int attackSkill(Char target) {
		return 38;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
