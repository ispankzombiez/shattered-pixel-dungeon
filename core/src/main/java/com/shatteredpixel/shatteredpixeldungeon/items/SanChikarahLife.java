package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bless;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;

// SanChikarah attuned to life energy.
public class SanChikarahLife extends SanChikarah {

	@Override
	public boolean doPickUp(Hero hero, int pos) {
		if (super.doPickUp(hero, pos)) {
			Dungeon.sanchikarahlife = false;
			tryMerge(hero);
			return true;
		}
		return false;
	}

	static void tryMerge(Hero hero) {
		SanChikarahLife life = hero.belongings.getItem(SanChikarahLife.class);
		SanChikarahDeath death = hero.belongings.getItem(SanChikarahDeath.class);
		if (life != null && death != null) {
			life.detach(hero.belongings.backpack);
			death.detach(hero.belongings.backpack);
			SanChikarahTranscend transcend = new SanChikarahTranscend();
			if (transcend.collect(hero.belongings.backpack)) {
				GLog.p("The two fragments of SanChikarah pulse with power and merge into the Transcendent Form!");
				Buff.affect(hero, Bless.class, 30f);
			} else {
				Dungeon.level.drop(transcend, hero.pos).sprite.drop(hero.pos);
				GLog.p("The two fragments of SanChikarah merge into the Transcendent Form!");
			}
		}
	}
}
