package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SeekingBombSprite;
import com.watabou.utils.Random;

public class SeekingBomb extends Mob {

	{
		spriteClass = SeekingBombSprite.class;

		HP = HT = 25;
		defenseSkill = 15;
		baseSpeed = 2f;

		EXP = 8;
		maxLvl = 22;

		flying = true;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 20;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}
}
