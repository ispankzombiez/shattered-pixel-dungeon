package com.shatteredpixel.shatteredpixeldungeon.items.nornstone;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Healing;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

/**
 * Blue Norn Stone — when used, triggers minor healing (roughly 25% max HP).
 */
public class BlueNornStone extends NornStone {

	public static final String AC_USE = "USE";

	{
		defaultAction = AC_USE;
	}

	@Override
	public String name() {
		return "Blue Norn Stone";
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
			int healAmount = Math.max(1, hero.HT / 4);
			Healing healing = Buff.affect(hero, Healing.class);
			healing.setHeal(healAmount, 0.25f, 0);
			hero.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.05f, 10);
			GLog.p("The blue Norn stone pulses with restorative energy!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}
}

