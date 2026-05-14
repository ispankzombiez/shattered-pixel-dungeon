package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SkeletonKingSprite;
import com.watabou.utils.Random;

public class King extends Mob {

	{
		spriteClass = SkeletonKingSprite.class;

		HP = HT = 200;
		defenseSkill = 28;

		EXP = 30;
		maxLvl = -2;

		properties.add(Property.BOSS);
		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 25);
	}

	@Override
	public int attackSkill(Char target) {
		return 30;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
