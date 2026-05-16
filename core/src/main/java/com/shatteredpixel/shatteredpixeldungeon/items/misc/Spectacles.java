package com.shatteredpixel.shatteredpixeldungeon.items.misc;

// Magical spectacles that extend the hero's field of vision.
public class Spectacles extends MiscEquippable {

    {
        unique = true;
        bones  = false;
    }

    @Override public boolean isUpgradable() { return false; }
}
