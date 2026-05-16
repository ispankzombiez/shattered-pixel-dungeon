package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.VillagerSprite;
import com.watabou.utils.Random;

public class Guard extends NPC {

	{
		spriteClass = VillagerSprite.class;

		HP = HT = 40;
		EXP = 0;

		defenseSkill = 10;
		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(5, 12);
	}

	@Override
	public int attackSkill(Char target) {
		return 14;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 3);
	}

	@Override
	protected boolean interact(Char c) {
		return true;
	}
}
