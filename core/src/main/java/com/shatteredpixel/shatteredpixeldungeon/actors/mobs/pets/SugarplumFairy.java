package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.pets;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SugarplumFairySprite;
import com.watabou.utils.Random;

public class SugarplumFairy extends PET {

	{
		spriteClass = SugarplumFairySprite.class;

		HP = HT = 35;
		EXP = 0;
		baseSpeed = 1.5f;
		flying = true;

		alignment = Alignment.ALLY;
		state = WANDERING;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(3, 10);
	}

	@Override
	public int attackSkill(Char target) {
		return 12;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 3);
	}
}
