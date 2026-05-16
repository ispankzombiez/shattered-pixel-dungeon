package com.shatteredpixel.shatteredpixeldungeon.items.journalpages;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Base class for Sprouted journal pages — each reveals dungeon secrets.
public class JournalPage extends Item {

    {
        image = ItemSpriteSheet.TORN_PAGE;
        unique = true;
    }
}
