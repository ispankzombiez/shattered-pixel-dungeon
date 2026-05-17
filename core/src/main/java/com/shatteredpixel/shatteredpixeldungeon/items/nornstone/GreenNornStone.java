package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.SpellSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

/**
 * Green Norn Stone — when used, fully satiates the hero's hunger.
 */
public class GreenNornStone extends NornStone {

	public static final String AC_USE = "USE";

	{
		defaultAction = AC_USE;
	}

	@Override
	public String name() {
		return "Green Norn Stone";
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
			Buff.affect(hero, Hunger.class).satisfy(Hunger.HUNGRY);
			SpellSprite.show(hero, SpellSprite.FOOD);
			GLog.p("The green Norn stone radiates warmth — your hunger fades!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}
}

