package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.AdultDragonVioletSprite;
import com.watabou.utils.Random;

public class AdultDragonViolet extends Mob {

	{
		spriteClass = AdultDragonVioletSprite.class;

		HP = HT = 200;
		defenseSkill = 35;
		baseSpeed = 1.5f;

		EXP = 40;
		maxLvl = -2;

		flying = true;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(18, 32);
	}

	@Override
	public int attackSkill(Char target) {
		return 40;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
