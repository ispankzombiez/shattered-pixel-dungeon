package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.items.RedDewdrop;

// A control panel mob that manages nearby mechanical enemies.
public class ControlPanel extends Pylon {

    {
        loot = new RedDewdrop();
        lootChance = 0.05f;
    }
}
