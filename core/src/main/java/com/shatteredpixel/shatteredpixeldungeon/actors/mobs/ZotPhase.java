package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ZotPhaseSprite;
import com.watabou.utils.Random;

public class ZotPhase extends Zot {

	{
		spriteClass = ZotPhaseSprite.class;

		HP = HT = 300;
		defenseSkill = 45;

		flying = true;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(20, 40);
	}

	@Override
	public int attackSkill(Char target) {
		return 50;
	}
}
