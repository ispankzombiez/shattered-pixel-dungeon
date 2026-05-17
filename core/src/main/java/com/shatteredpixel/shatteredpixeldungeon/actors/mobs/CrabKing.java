package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.StoneOre;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabKingSprite;
import com.watabou.utils.Random;

public class CrabKing extends Mob {

	{
		spriteClass = CrabKingSprite.class;

		HP = HT = 150;
		defenseSkill = 28;

		EXP = 28;
		maxLvl = -2;

		properties.add(Property.BOSS);

		loot = new StoneOre().quantity(3);
		lootChance = 1f;
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
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
