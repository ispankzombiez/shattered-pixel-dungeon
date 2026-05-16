package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TinkererSprite;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;

public class Tinkerer2 extends NPC {

	{
		spriteClass = TinkererSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	private static final String TXT_DUNGEON =
			"I'm still scavenging for toadstool mushrooms. "
					+ "Bring me any you find and I'll trade what I can.";

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
