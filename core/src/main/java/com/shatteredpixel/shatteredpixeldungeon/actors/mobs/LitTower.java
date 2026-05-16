package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.LitTowerSprite;
import com.watabou.utils.Random;

public class LitTower extends Mob {

	{
		spriteClass = LitTowerSprite.class;

		HP = HT = 60;
		defenseSkill = 16;

		EXP = 12;
		maxLvl = 26;

		properties.add(Property.INORGANIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 20;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
