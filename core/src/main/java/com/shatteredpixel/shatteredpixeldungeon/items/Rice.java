package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A bowl of cooked rice — light but satisfying.
public class Rice extends Food {

    {
        image = ItemSpriteSheet.PUMPKIN_PIE;
        energy = Food.FOOD_VAL / 2;
        stackable = true;
    }
}
