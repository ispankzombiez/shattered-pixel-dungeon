package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// A sweet pudding cup — a rare dungeon treat.
public class PuddingCup extends Food {

    {
        image = ItemSpriteSheet.OVERPRICED;
        energy = Hunger.HUNGRY;
        stackable = true;
    }
}
