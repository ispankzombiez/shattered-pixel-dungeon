package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A bowl of cooked rice — light but satisfying.
public class Rice extends Food {

    {
        image = ItemSpriteSheet.PUMPKIN_PIE;
        energy = Hunger.HUNGRY / 2;
        stackable = true;
    }
}
