package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ShadowYogSprite;
import com.watabou.utils.Random;

public class ShadowYog extends Mob {

	{
		spriteClass = ShadowYogSprite.class;

		HP = HT = 200;
		defenseSkill = 36;

		EXP = 45;
		maxLvl = -2;

		flying = true;

		properties.add(Property.BOSS);
		properties.add(Property.DEMONIC);
		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(16, 32);
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
