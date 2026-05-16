package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.FossilSkeletonSprite;
import com.watabou.utils.Random;

public class FossilSkeleton extends Mob {

	{
		spriteClass = FossilSkeletonSprite.class;

		HP = HT = 28;
		defenseSkill = 10;

		EXP = 6;
		maxLvl = 12;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(3, 10);
	}

	@Override
	public int attackSkill(Char target) {
		return 13;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 3);
	}
}
