package com.shatteredpixel.shatteredpixeldungeon.items.scrolls;

// Scroll stub — override doRead() for full effect.
public class ScrollOfMagicalInfusion extends Scroll {

    @Override
    public void doRead() {
        identify();
        updateQuickslot();
    }
}
