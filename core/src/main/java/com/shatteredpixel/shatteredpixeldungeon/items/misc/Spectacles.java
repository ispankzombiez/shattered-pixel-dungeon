package com.shatteredpixel.shatteredpixeldungeon.items.misc;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

// Magical spectacles that extend the hero's field of vision.
public class Spectacles extends MiscEquippable {

    {
        unique = true;
        bones  = false;
    }

    @Override public boolean isUpgradable() { return false; }

    @Override
    public boolean doEquip(Hero hero) {
        return true;
    }
}
