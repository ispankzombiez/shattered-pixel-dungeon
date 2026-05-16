package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MossySkeletonSprite;
import com.watabou.utils.Random;

public class MossySkeleton extends Mob {

	{
		spriteClass = MossySkeletonSprite.class;

		HP = HT = 55;
		defenseSkill = 20;

		EXP = 11;
		maxLvl = 30;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(9, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 23;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
