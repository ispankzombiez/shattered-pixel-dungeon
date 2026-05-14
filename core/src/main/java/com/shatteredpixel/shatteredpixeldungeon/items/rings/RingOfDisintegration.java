package com.shatteredpixel.shatteredpixeldungeon.items.rings;

public class RingOfDisintegration extends Ring {

	@Override
	protected RingBuff buff() {
		return new Buff();
	}

	public class Buff extends RingBuff {
	}
}
