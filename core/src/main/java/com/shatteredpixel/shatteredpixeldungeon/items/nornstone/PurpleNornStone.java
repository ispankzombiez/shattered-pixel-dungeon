package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Identification;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

/**
 * Purple Norn Stone — when used, identifies all items currently in the hero's backpack.
 */
public class PurpleNornStone extends NornStone {

	public static final String AC_USE = "USE";

	{
		defaultAction = AC_USE;
	}

	@Override
	public String name() {
		return "Purple Norn Stone";
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_USE);
		return actions;
	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);
		if (action.equals(AC_USE)) {
			hero.sprite.parent.add(new Identification(hero.sprite.center().offset(0, -16)));
			for (Item item : Dungeon.hero.belongings.backpack.items) {
				if (!item.isIdentified()) {
					ScrollOfIdentify.IDItem(item);
				}
			}
			GLog.p("The purple Norn stone shimmers — the secrets of your items are revealed!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}
}

