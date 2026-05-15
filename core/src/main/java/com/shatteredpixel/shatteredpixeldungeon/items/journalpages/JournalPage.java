package com.shatteredpixel.shatteredpixeldungeon.items.journalpages;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;

// Base class for all journal pages found in the dungeon.
public class JournalPage extends Item {

    {
        unique = true;
        bones  = false;
    }

    @Override public boolean isUpgradable() { return false; }
    @Override public boolean isIdentified() { return true; }
}
