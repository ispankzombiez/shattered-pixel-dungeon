package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.AlbinoPiranhaSprite;
import com.watabou.utils.Random;

public class AlbinoPiranha extends Piranha {

	{
		spriteClass = AlbinoPiranhaSprite.class;

		HP = HT = 40;
		defenseSkill = 25;

		EXP = 10;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 28;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
