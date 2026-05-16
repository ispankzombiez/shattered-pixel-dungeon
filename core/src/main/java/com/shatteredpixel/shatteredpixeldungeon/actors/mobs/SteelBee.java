package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SteelBeeSprite;
import com.watabou.utils.Random;

public class SteelBee extends Mob {

	{
		spriteClass = SteelBeeSprite.class;

		HP = HT = 30;
		defenseSkill = 22;
		baseSpeed = 1.5f;

		EXP = 8;
		maxLvl = 22;

		flying = true;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(6, 16);
	}

	@Override
	public int attackSkill(Char target) {
		return 24;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
