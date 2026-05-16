package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ThiefKingSprite;
import com.watabou.utils.Random;

public class ThiefKing extends Mob {

	{
		spriteClass = ThiefKingSprite.class;

		HP = HT = 160;
		defenseSkill = 35;
		baseSpeed = 1.5f;

		EXP = 32;
		maxLvl = -2;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 26);
	}

	@Override
	public int attackSkill(Char target) {
		return 38;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
