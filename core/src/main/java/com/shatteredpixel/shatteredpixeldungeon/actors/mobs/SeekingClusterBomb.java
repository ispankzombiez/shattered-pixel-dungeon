package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SeekingClusterBombSprite;
import com.watabou.utils.Random;

public class SeekingClusterBomb extends SeekingBomb {

	{
		spriteClass = SeekingClusterBombSprite.class;

		HP = HT = 35;
		defenseSkill = 18;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 24);
	}

	@Override
	public int attackSkill(Char target) {
		return 22;
	}
}
