package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// The Dew Vial from Sprouted — collects dewdrops and can be used for healing or leveling.
public class DewVial extends Item {

    {
        image = ItemSpriteSheet.DEWDROP;
        stackable = false;
        unique = true;
    }

    public int volume = 0;
    public static final int MAX_VOLUME = 20;
}
