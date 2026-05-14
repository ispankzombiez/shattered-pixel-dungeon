package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BanditKingSprite;
import com.watabou.utils.Random;

public class BanditKing extends Mob {

	{
		spriteClass = BanditKingSprite.class;

		HP = HT = 300;
		defenseSkill = 42;

		EXP = 60;
		maxLvl = -2;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(20, 38);
	}

	@Override
	public int attackSkill(Char target) {
		return 45;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 12);
	}
}
