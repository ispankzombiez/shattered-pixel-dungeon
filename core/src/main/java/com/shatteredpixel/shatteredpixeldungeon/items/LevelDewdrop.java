package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A level dewdrop — grants bonus experience or HP when consumed.
public class LevelDewdrop extends Item {

    {
        image = ItemSpriteSheet.DEWDROP;
        stackable = true;
    }
}
