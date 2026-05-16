package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.OrbOfZotSprite;
import com.watabou.utils.Random;

public class OrbOfZotMob extends Mob {

	{
		spriteClass = OrbOfZotSprite.class;

		HP = HT = 80;
		defenseSkill = 28;
		baseSpeed = 1.5f;

		EXP = 15;
		maxLvl = -2;

		flying = true;

		properties.add(Property.DEMONIC);
		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 24);
	}

	@Override
	public int attackSkill(Char target) {
		return 32;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
