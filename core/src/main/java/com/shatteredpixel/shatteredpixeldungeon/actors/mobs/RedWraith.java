package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.items.RedDewdrop;

// A red-tinted wraith that drops red dewdrops.
public class RedWraith extends Wraith {

    {
        loot = new RedDewdrop();
        lootChance = 0.5f;
    }
}
