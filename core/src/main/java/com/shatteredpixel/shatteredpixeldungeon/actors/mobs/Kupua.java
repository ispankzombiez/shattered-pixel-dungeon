package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.KupuaSprite;
import com.watabou.utils.Random;

public class Kupua extends Mob {

	{
		spriteClass = KupuaSprite.class;

		HP = HT = 100;
		defenseSkill = 42;
		baseSpeed = 1.5f;

		EXP = 22;

		flying = true;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(16, 30);
	}

	@Override
	public int attackSkill(Char target) {
		return 46;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
