package com.shatteredpixel.shatteredpixeldungeon.items.scrolls;

// Scroll stub — override doRead() for full effect.
public class ScrollOfMultiUpgrade extends Scroll {

    @Override
    public void doRead() {
        identify();
        updateQuickslot();
    }
}
