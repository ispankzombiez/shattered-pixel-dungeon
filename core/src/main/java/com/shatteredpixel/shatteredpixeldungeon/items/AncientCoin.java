package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// An ancient gold coin of mysterious origin.
public class AncientCoin extends Item {

    {
        image = ItemSpriteSheet.GOLD;
        stackable = true;
        unique = true;
    }
}
