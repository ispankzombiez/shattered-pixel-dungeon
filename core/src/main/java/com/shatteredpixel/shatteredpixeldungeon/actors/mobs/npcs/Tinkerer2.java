package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Mushroom;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TinkererSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;
import com.watabou.noosa.Game;
import com.watabou.utils.Callback;

public class Tinkerer2 extends NPC {

	{
		spriteClass = TinkererSprite.class;

		HP = HT = 1;
		EXP = 0;

		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	private static final String TXT_HAVE_MUSHROOM =
			"Ah, you've got some toadstool mushrooms! "
					+ "Trade one for a random potion from my collection?";
	private static final String TXT_NO_MUSHROOM =
			"I'm still scavenging for toadstool mushrooms. "
					+ "Bring me any you find and I'll trade what I can.";
	private static final String TXT_YES = "Trade one mushroom";
	private static final String TXT_NO  = "Not now";

	@Override
	public boolean interact(Char c) {
		if (c != Dungeon.hero) {
			return true;
		}
		sprite.turnTo(pos, Dungeon.hero.pos);

		Mushroom mushroom = Dungeon.hero.belongings.getItem(Mushroom.class);
		if (mushroom == null) {
			GameScene.show(new WndQuest(this, TXT_NO_MUSHROOM));
			return true;
		}

		Game.runOnRenderThread(new Callback() {
			@Override
			public void call() {
				GameScene.show(new WndOptions(
						sprite(),
						name(),
						TXT_HAVE_MUSHROOM,
						TXT_YES,
						TXT_NO
				) {
					@Override
					protected void onSelect(int index) {
						if (index == 0) {
							doTrade();
						}
					}
				});
			}
		});
		return true;
	}

	private void doTrade() {
		Mushroom mushroom = Dungeon.hero.belongings.getItem(Mushroom.class);
		if (mushroom == null) return;

		mushroom.detach(Dungeon.hero.belongings.backpack);
		Dungeon.level.drop(
				Generator.randomUsingDefaults(Generator.Category.POTION),
				Dungeon.hero.pos
		).sprite.drop(Dungeon.hero.pos);
		GLog.i("The tinkerer thanks you and hands over a potion!");
	}
}

