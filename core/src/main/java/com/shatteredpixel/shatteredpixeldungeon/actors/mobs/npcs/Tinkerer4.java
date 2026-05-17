package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.VillagerSprite;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;
import com.watabou.utils.Bundle;

public class Tinkerer4 extends NPC {

	{
		spriteClass = VillagerSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	private static final String FIRST = "first";
	private boolean first = true;

	private static final String TXT_DUNGEON =
			"Otiluke came through years ago. There used to be a mine to the southwest, "
					+ "but demons overran it and he sealed it off.";
	private static final String TXT_DUNGEON2 =
			"The old mine entrance is hidden under overgrowth in the southwest corner of town.";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(FIRST, first);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		first = bundle.getBoolean(FIRST);
	}

	@Override
	public boolean interact(Char c) {
		if (c != Dungeon.hero) {
			return true;
		}
		sprite.turnTo(pos, Dungeon.hero.pos);
		boolean wasFirst = first;
		first = false;
		GameScene.show(new WndQuest(this, wasFirst ? TXT_DUNGEON : TXT_DUNGEON2));
		return true;
	}
}
