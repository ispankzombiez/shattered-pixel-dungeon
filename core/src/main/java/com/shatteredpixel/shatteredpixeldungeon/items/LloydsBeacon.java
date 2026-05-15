package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Sprouted-style Lloyd's Beacon — marks a return point and teleports back.
// The full Shattered artifact implementation is in items.artifacts.LloydsBeacon.
public class LloydsBeacon extends Item {

    {
        image = ItemSpriteSheet.BEACON;
        unique = true;
    }
}
