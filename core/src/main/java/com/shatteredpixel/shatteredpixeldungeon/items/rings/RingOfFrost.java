package com.shatteredpixel.shatteredpixeldungeon.items.rings;

public class RingOfFrost extends Ring {

	@Override
	protected RingBuff buff() {
		return new Buff();
	}

	public class Buff extends RingBuff {
	}
}
