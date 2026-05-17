package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.nornstone.NornStone;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SkeletonKingSprite;
import com.watabou.utils.Random;

public class SkeletonKing extends Mob {

	{
		spriteClass = SkeletonKingSprite.class;

		HP = HT = 180;
		defenseSkill = 30;

		EXP = 35;
		maxLvl = -2;

		properties.add(Property.BOSS);
		properties.add(Property.UNDEAD);

		loot = NornStone.randomNornStone();
		lootChance = 1f;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(15, 28);
	}

	@Override
	public int attackSkill(Char target) {
		return 35;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 10);
	}
}
