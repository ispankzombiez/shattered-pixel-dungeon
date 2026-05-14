package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MagicEyeSprite;
import com.watabou.utils.Random;

public class MagicEye extends Eye {

	{
		spriteClass = MagicEyeSprite.class;

		HP = HT = 110;
		defenseSkill = 24;

		EXP = 15;
		maxLvl = 28;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 24);
	}

	@Override
	public int attackSkill(Char target) {
		return 28;
	}
}
