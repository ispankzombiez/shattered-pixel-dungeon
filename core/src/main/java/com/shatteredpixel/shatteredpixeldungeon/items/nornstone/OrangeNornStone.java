package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

/**
 * Orange Norn Stone — when used, applies Haste for 30 turns.
 */
public class OrangeNornStone extends NornStone {

	private static final int HASTE_TURNS = 30;
	public static final String AC_USE = "USE";

	{
		defaultAction = AC_USE;
	}

	@Override
	public String name() {
		return "Orange Norn Stone";
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
			Buff.affect(hero, Haste.class, HASTE_TURNS);
			hero.sprite.emitter().start(Speck.factory(Speck.JET), 0.05f, 8);
			GLog.p("The orange Norn stone blazes with energy — you feel invigorated!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}
}

