package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bless;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

import java.util.ArrayList;

// SanChikarah in its transcendent form.
// When used, fully heals the hero and bestows an extended Bless. One-time use.
public class SanChikarahTranscend extends SanChikarah {

	public static final String AC_INVOKE = "INVOKE";

	{
		defaultAction = AC_INVOKE;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_INVOKE);
		return actions;
	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);
		if (action.equals(AC_INVOKE)) {
			hero.HP = hero.HT;
			hero.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.04f, 20);
			Buff.affect(hero, Bless.class, Bless.DURATION * 2);
			GLog.p("The SanChikarah pulses with transcendent energy — you are healed and blessed!");
			detach(hero.belongings.backpack);
			hero.spendAndNext(1f);
		}
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}
}
