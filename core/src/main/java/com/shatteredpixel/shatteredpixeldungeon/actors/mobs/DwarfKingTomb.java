package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DwarfKingTombSprite;
import com.watabou.utils.Random;

public class DwarfKingTomb extends Mob {

	{
		spriteClass = DwarfKingTombSprite.class;

		HP = HT = 220;
		defenseSkill = 32;

		EXP = 38;
		maxLvl = -2;

		properties.add(Property.BOSS);
		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(16, 30);
	}

	@Override
	public int attackSkill(Char target) {
		return 36;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 12);
	}
}
