package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ForestProtectorSprite;
import com.watabou.utils.Random;

public class ForestProtector extends Mob {

	{
		spriteClass = ForestProtectorSprite.class;

		HP = HT = 55;
		defenseSkill = 20;

		EXP = 12;
		maxLvl = 30;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 24;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
