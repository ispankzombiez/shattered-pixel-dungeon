package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.TownReturnBeacon;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.VillagerSprite;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Tinkerer5 extends NPC {

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
			"We used to mine stone ore here, but when demons came the passageways started shifting. "
					+ "Be careful — if you leave a floor, it may not be the same when you return.";
	private static final String TXT_DUNGEON2 =
			"The temple east of town holds an altar. Bring three Norn stones there for a special reward.";
	private static final String TXT_DUNGEON3 =
			"Take this return beacon left by Otiluke. Use it to get back to town when you must.";

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
		if (first) {
			first = false;
			if (Dungeon.hero.belongings.getItem(TownReturnBeacon.class) == null) {
				Dungeon.level.drop(new TownReturnBeacon(), Dungeon.hero.pos);
			}
			GameScene.show(new WndQuest(this, TXT_DUNGEON3));
		} else {
			GameScene.show(new WndQuest(this, Random.Int(2) == 0 ? TXT_DUNGEON : TXT_DUNGEON2));
		}
		return true;
	}
}
