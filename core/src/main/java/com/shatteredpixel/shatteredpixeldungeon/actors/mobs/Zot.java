package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ZotSprite;
import com.watabou.utils.Random;

public class Zot extends Mob {

	{
		spriteClass = ZotSprite.class;

		HP = HT = 500;
		defenseSkill = 50;

		EXP = 80;
		maxLvl = -2;

		properties.add(Property.BOSS);
		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(25, 45);
	}

	@Override
	public int attackSkill(Char target) {
		return 55;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 15);
	}
}
