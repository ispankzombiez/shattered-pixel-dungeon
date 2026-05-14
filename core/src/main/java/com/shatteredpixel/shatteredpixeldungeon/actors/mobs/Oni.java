package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.OniSprite;
import com.watabou.utils.Random;

public class Oni extends Mob {

	{
		spriteClass = OniSprite.class;

		HP = HT = 80;
		defenseSkill = 28;

		EXP = 16;
		maxLvl = 36;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 26);
	}

	@Override
	public int attackSkill(Char target) {
		return 32;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
