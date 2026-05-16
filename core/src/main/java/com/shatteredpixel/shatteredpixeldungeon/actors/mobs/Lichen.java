package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.PlantSprite;
import com.watabou.utils.Random;

public class Lichen extends Mob {

	{
		spriteClass = PlantSprite.class;

		HP = HT = 30;
		defenseSkill = 16;

		EXP = 8;
		maxLvl = 25;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(6, 14);
	}

	@Override
	public int attackSkill(Char target) {
		return 18;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 3);
	}
}
