package com.shatteredpixel.shatteredpixeldungeon.items.wands;

import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;

public class WandOfSlowness extends Wand {

	@Override
	public void onZap(Ballistica attack) {
	}

	@Override
	public void fx(Ballistica shoot, com.watabou.utils.Callback callback) {
		callback.call();
	}
}
