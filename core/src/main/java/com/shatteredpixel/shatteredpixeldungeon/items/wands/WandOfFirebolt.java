package com.shatteredpixel.shatteredpixeldungeon.items.wands;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;

public class WandOfFirebolt extends Wand {

	@Override
	public void onZap(Ballistica attack) {
	}

	@Override
	public void fx(Ballistica shoot, com.watabou.utils.Callback callback) {
		callback.call();
	}

	@Override
	public void onHit(MagesStaff staff, Char attacker, Char defender, int damage) {
	}
}