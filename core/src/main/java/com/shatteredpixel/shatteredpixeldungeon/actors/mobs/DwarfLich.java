package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DwarfLichSprite;
import com.watabou.utils.Random;

public class DwarfLich extends Mob {

	{
		spriteClass = DwarfLichSprite.class;

		HP = HT = 65;
		defenseSkill = 22;

		EXP = 11;
		maxLvl = 22;

		loot = Generator.Category.WAND;
		lootChance = 0.1f;

		properties.add(Property.UNDEAD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(8, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 24;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}
}
