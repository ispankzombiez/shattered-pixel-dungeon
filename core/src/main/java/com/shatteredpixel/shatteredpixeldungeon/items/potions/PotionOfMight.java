package com.shatteredpixel.shatteredpixeldungeon.items.potions;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

// Potion stub — override apply() for full effect.
public class PotionOfMight extends Potion {

    @Override
    public void apply(Hero hero) {
        identify();
    }
}
