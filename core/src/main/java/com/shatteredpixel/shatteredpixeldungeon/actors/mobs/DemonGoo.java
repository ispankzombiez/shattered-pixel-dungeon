package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DemonGooSprite;
import com.watabou.utils.Random;

public class DemonGoo extends Mob {

	{
		spriteClass = DemonGooSprite.class;

		HP = HT = 90;
		defenseSkill = 26;

		EXP = 14;
		maxLvl = 26;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 22);
	}

	@Override
	public int attackSkill(Char target) {
		return 28;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
