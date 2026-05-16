package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TinkererSprite;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;

public class Tinkerer1 extends NPC {

	{
		spriteClass = TinkererSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	private static final String TXT_DUNGEON =
			"Oh wow, have you seen this dungeon? It's incredible. "
					+ "I'm scouting it and looking for toadstool mushrooms.";

	@Override
	public boolean interact(Char c) {
		if (c != Dungeon.hero) {
			return true;
		}
		sprite.turnTo(pos, Dungeon.hero.pos);
		GameScene.show(new WndQuest(this, TXT_DUNGEON));
		return true;
	}
}
