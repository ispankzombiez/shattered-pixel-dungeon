package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A dungeon mushroom — nutritious and mildly magical.
public class Mushroom extends Food {

    {
        image = ItemSpriteSheet.BLANDFRUIT;
        energy = Hunger.HUNGRY / 2;
        stackable = true;
    }
}
