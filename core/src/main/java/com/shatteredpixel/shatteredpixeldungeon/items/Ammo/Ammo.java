package com.shatteredpixel.shatteredpixeldungeon.items.Ammo;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;

// Base class for all ammo used with ranged weapons such as the Bow.
public class Ammo extends Item {

    {
        stackable = true;
        bones    = false;
    }

    @Override public boolean isUpgradable() { return false; }
    @Override public boolean isIdentified() { return true; }
}
