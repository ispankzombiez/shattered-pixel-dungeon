package com.shatteredpixel.shatteredpixeldungeon.items.scrolls;

// Scroll stub — override doRead() for full effect.
public class ScrollOfPsionicBlast extends Scroll {

    @Override
    public void doRead() {
        identify();
        updateQuickslot();
    }
}
