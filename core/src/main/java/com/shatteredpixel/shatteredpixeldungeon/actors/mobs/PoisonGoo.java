package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.sprites.PoisonGooSprite;
import com.watabou.utils.Random;

public class PoisonGoo extends Mob {

	{
		spriteClass = PoisonGooSprite.class;

		HP = HT = 70;
		defenseSkill = 22;

		EXP = 13;
		maxLvl = 26;

		properties.add(Property.DEMONIC);
		properties.add(Property.ACIDIC);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public int attackSkill(Char target) {
		return 26;
	}

	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 5);
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		damage = super.attackProc(enemy, damage);
		if (Random.Int(3) == 0) {
			Buff.affect(enemy, Poison.class).set(4 + Dungeon.scalingDepth());
		}
		return damage;
	}
}
