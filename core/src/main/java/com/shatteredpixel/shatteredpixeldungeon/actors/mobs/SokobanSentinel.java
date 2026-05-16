package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanSentinelSprite;
import com.watabou.utils.Random;

public class SokobanSentinel extends Sentinel {

	{
		spriteClass = SokobanSentinelSprite.class;

		HP = HT = 55;
		defenseSkill = 20;

		EXP = 12;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 24;
	}
}
