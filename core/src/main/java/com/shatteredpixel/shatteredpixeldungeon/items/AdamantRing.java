package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;

// A ring forged from adamant — grants a powerful bonus effect.
public class AdamantRing extends Ring {

    {
        buffClass = Buff.class;
    }

    public class Buff extends RingBuff {
    }
}
