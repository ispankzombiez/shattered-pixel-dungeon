package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ShellSprite;
import com.watabou.utils.Random;

public class Shell extends Mob {

	{
		spriteClass = ShellSprite.class;

		HP = HT = 45;
		defenseSkill = 20;

		EXP = 10;
		maxLvl = 24;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 22;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 7);
	}
}
