package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.VaultProtectorSprite;
import com.watabou.utils.Random;

public class VaultProtector extends Mob {

	{
		spriteClass = VaultProtectorSprite.class;

		HP = HT = 75;
		defenseSkill = 28;

		EXP = 15;
		maxLvl = 30;

		properties.add(Property.DEMONIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 24);
	}

	@Override
	public int attackSkill(Char target) {
		return 32;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 7);
	}
}
