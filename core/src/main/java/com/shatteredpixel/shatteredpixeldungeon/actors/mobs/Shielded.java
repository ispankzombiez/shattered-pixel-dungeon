package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ShieldedSprite;
import com.watabou.utils.Random;

public class Shielded extends Brute {

	{
		spriteClass = ShieldedSprite.class;

		HP = HT = 55;
		defenseSkill = 18;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 18;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
