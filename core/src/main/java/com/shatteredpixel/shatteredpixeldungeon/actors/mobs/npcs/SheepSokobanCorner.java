package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SokobanCornerSheepSprite;
import com.watabou.utils.Random;

public class SheepSokobanCorner extends NPC {

	private static final String[] QUOTES = {"Baa!", "Baa?", "Baa.", "Baa..."};

	{
		spriteClass = SokobanCornerSheepSprite.class;

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
		int width = Dungeon.level.width();
		int sheepX = oldPos % width;
		int sheepY = oldPos / width;
		int heroX = heroPos % width;
		int heroY = heroPos / width;
		int dx = sheepX - heroX;
		int dy = sheepY - heroY;

		// Corner sheep can be pushed cardinally and diagonally.
		if (Math.max(Math.abs(dx), Math.abs(dy)) == 1 && !(dx == 0 && dy == 0)) {
			int dstX = sheepX + dx;
			int dstY = sheepY + dy;
			int dst = dstX + dstY * width;
			if (dstX >= 0 && dstY >= 0 && dstX < width && dstY < Dungeon.level.height()
					&& (Dungeon.level.passable[dst] || Dungeon.level.avoid[dst])
					&& Actor.findChar(dst) == null) {
				sprite.move(oldPos, dst);
				move(dst);
				c.sprite.move(heroPos, oldPos);
				c.move(oldPos);
				Dungeon.hero.spendAndNext(1f);
			}
		}

		sprite.showStatus(CharSprite.NEUTRAL, Random.element(QUOTES));
		return true;
	}
}
