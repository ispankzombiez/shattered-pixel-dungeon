package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SpectralRatSprite;
import com.watabou.utils.Random;

public class SpectralRat extends Mob {

	{
		spriteClass = SpectralRatSprite.class;

		HP = HT = 40;
		defenseSkill = 30;
		baseSpeed = 2f;

		EXP = 10;
		maxLvl = 38;

		flying = true;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 33;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}
}
