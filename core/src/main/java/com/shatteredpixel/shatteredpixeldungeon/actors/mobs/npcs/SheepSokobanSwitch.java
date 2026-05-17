package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanSheepSwitchSprite;
import com.watabou.utils.Random;

public class SheepSokobanSwitch extends NPC {

	private static final String[] QUOTES = {"Baa!", "Baa?", "Baa.", "Baa..."};

	{
		spriteClass = SokobanSheepSwitchSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	public boolean interact(Char c) {
		if (c != Dungeon.hero) {
			return true;
		}

		int oldPos = pos;
		int heroPos = c.pos;
		sprite.move(oldPos, heroPos);
		move(heroPos);
		c.sprite.move(heroPos, oldPos);
		c.move(oldPos);
		Dungeon.hero.spendAndNext(1f);
		sprite.showStatus(CharSprite.NEUTRAL, Random.element(QUOTES));
		return true;
	}
}
