package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MrDestructo2dot0Sprite;
import com.watabou.utils.Random;

public class MrDestructo2dot0 extends MrDestructo {

	{
		spriteClass = MrDestructo2dot0Sprite.class;

		HP = HT = 120;
		defenseSkill = 25;

		EXP = 20;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(16, 28);
	}

	@Override
	public int attackSkill(Char target) {
		return 28;
	}
}
