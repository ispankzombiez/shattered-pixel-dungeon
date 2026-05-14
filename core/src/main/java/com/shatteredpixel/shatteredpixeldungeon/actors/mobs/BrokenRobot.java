package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BrokenRobotSprite;
import com.watabou.utils.Random;

public class BrokenRobot extends Mob {

	{
		spriteClass = BrokenRobotSprite.class;

		HP = HT = 35;
		defenseSkill = 12;

		EXP = 7;
		maxLvl = 15;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(5, 14);
	}

	@Override
	public int attackSkill(Char target) {
		return 16;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}
}
