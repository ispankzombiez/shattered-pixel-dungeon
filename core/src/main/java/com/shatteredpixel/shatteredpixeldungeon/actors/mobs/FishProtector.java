package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Mushroom;
import com.shatteredpixel.shatteredpixeldungeon.sprites.FishProtectorSprite;
import com.watabou.utils.Random;

public class FishProtector extends Mob {

	{
		spriteClass = FishProtectorSprite.class;

		HP = HT = 65;
		defenseSkill = 24;
		baseSpeed = 1.5f;

		EXP = 14;
		maxLvl = 30;

		flying = true;

		properties.add(Property.DEMONIC);

		loot = new Mushroom();
		lootChance = 0.33f;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(12, 22);
	}

	@Override
	public int attackSkill(Char target) {
		return 27;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 6);
	}
}
