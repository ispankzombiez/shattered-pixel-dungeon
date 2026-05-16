package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A dungeon mushroom — nutritious and mildly magical.
public class Mushroom extends Food {

    {
        image = ItemSpriteSheet.MUSHROOM_WINE;
        energy = Food.FOOD_VAL / 2;
        stackable = true;
    }
}
