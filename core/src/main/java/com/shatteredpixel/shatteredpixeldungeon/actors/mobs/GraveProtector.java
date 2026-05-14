package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GraveProtectorSprite;
import com.watabou.utils.Random;

public class GraveProtector extends Mob {

	{
		spriteClass = GraveProtectorSprite.class;

		HP = HT = 60;
		defenseSkill = 22;

		EXP = 13;
		maxLvl = 30;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 25;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
