package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Town return beacon — teleports the hero directly to the Town level.
public class TownReturnBeacon extends Item {

    {
        image = ItemSpriteSheet.RETURN_BEACON;
        unique = true;
    }
}
