package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TenguSprite;
import com.watabou.utils.Random;

public class TenguEscape extends Mob {

	{
		spriteClass = TenguSprite.class;

		HP = HT = 80;
		defenseSkill = 38;
		baseSpeed = 1.5f;

		EXP = 18;
		maxLvl = 42;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 28);
	}

	@Override
	public int attackSkill(Char target) {
		return 40;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 8);
	}
}
