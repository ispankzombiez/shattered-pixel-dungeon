package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GoldThiefSprite;
import com.watabou.utils.Random;

public class GoldThief extends Mob {

	{
		spriteClass = GoldThiefSprite.class;

		HP = HT = 50;
		defenseSkill = 28;
		baseSpeed = 1.5f;

		EXP = 12;
		maxLvl = 30;

		loot = Gold.class;
		lootChance = 0.8f;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 30;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}
}
