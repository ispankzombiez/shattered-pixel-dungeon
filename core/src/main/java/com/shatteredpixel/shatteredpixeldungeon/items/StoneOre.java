package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Raw stone ore used in Sprouted crafting recipes.
// Can also be sold to shops for a decent price.
public class StoneOre extends Item {

    {
        image = ItemSpriteSheet.SEAL_SHARD;
        stackable = true;
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }

    @Override
    public int value() {
        return 50 * quantity;
    }
}
