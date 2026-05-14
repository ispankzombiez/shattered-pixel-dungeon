package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TowerSprite;
import com.watabou.utils.Random;

public class Tower extends Mob {

	{
		spriteClass = TowerSprite.class;

		HP = HT = 80;
		defenseSkill = 20;

		EXP = 15;
		maxLvl = 28;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 22);
	}

	@Override
	public int attackSkill(Char target) {
		return 24;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
