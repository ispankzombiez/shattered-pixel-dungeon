package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bless;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

/**
 * Yellow Norn Stone — when used, blesses the hero for 40 turns.
 */
public class YellowNornStone extends NornStone {

	public static final String AC_USE = "USE";

	{
		defaultAction = AC_USE;
	}

	@Override
	public String name() {
		return "Yellow Norn Stone";
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
			Buff.affect(hero, Bless.class, 40f);
			hero.sprite.emitter().start(Speck.factory(Speck.LIGHT), 0.05f, 10);
			GLog.p("The yellow Norn stone glows with divine radiance — you feel blessed!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}
}

