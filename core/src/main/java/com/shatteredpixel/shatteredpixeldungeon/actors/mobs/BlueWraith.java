package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BlueWraithSprite;
import com.watabou.utils.Random;

public class BlueWraith extends Mob {

	{
		spriteClass = BlueWraithSprite.class;

		HP = HT = 45;
		defenseSkill = 30;
		baseSpeed = 1.5f;

		EXP = 12;
		maxLvl = 35;

		flying = true;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 22);
	}

	@Override
	public int attackSkill(Char target) {
		return 32;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
