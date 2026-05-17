package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.nornstone.NornStone;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.VillagerSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndQuest;
import com.watabou.noosa.Game;
import com.watabou.utils.Callback;

import java.util.ArrayList;

/**
 * The Norn Stone Altar, placed in the temple east of Town.
 * Tinkerer5 hints: "Bring three Norn stones there for a special reward."
 *
 * When the hero interacts and has ≥3 NornStones, they are offered a
 * WndOptions prompt. On confirm, the three stones are consumed and a
 * ScrollOfUpgrade is dropped at the hero's feet.
 *
 * After the quest is completed, the altar acknowledges the prior offering
 * instead of accepting stones again.
 */
public class NornStoneAltar extends NPC {

	private static final int STONES_REQUIRED = 3;

	private static final String TXT_READY =
			"The ancient altar pulses with energy. You count your Norn stones... "
					+ "you have enough. Place three upon the altar?";
	private static final String TXT_YES    = "Offer three Norn stones";
	private static final String TXT_NO     = "Not yet";
	private static final String TXT_AWAIT =
			"The altar waits. Bring three Norn stones to receive its blessing.";
	private static final String TXT_DONE  =
			"The altar is silent now, its power spent. It seems your offering was enough.";

	{
		spriteClass = VillagerSprite.class;
		HP = HT = 1;
		EXP = 0;
		alignment = Alignment.NEUTRAL;
		state = PASSIVE;
	}

	@Override
	public String name() {
		return "Norn Stone Altar";
	}

	@Override
	public boolean interact(Char c) {
		if (c != Dungeon.hero) {
			return true;
		}
		sprite.turnTo(pos, Dungeon.hero.pos);

		if (Dungeon.nornAltarDone) {
			GameScene.show(new WndQuest(this, TXT_DONE));
			return true;
		}

		// Count NornStones in inventory
		ArrayList<NornStone> stones = Dungeon.hero.belongings.getAllItems(NornStone.class);
		int total = 0;
		for (NornStone s : stones) total += s.quantity();

		if (total < STONES_REQUIRED) {
			GameScene.show(new WndQuest(this, TXT_AWAIT));
			return true;
		}

		// Has enough — ask to confirm
		Game.runOnRenderThread(new Callback() {
			@Override
			public void call() {
				GameScene.show(new WndOptions(
						sprite(),
						name(),
						TXT_READY,
						TXT_YES,
						TXT_NO
				) {
					@Override
					protected void onSelect(int index) {
						if (index == 0) {
							consumeStonesAndReward();
						}
					}
				});
			}
		});
		return true;
	}

	private void consumeStonesAndReward() {
		int remaining = STONES_REQUIRED;
		for (NornStone stone : Dungeon.hero.belongings.getAllItems(NornStone.class)) {
			if (remaining <= 0) break;
			if (stone.quantity() <= remaining) {
				remaining -= stone.quantity();
				stone.detachAll(Dungeon.hero.belongings.backpack);
			} else {
				stone.quantity(stone.quantity() - remaining);
				remaining = 0;
			}
		}

		Dungeon.nornAltarDone = true;
		Dungeon.level.drop(new ScrollOfUpgrade(), Dungeon.hero.pos).sprite.drop(Dungeon.hero.pos);
		GLog.p("The altar accepts the three Norn stones and rewards you with a Scroll of Upgrade!");
	}
}
