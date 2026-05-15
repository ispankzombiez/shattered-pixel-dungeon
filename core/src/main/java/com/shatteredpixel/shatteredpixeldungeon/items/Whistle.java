package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

import java.util.ArrayList;

// A whistle — summons pets or calls allied creatures.
public class Whistle extends Item {

    {
        image = ItemSpriteSheet.ANKH;
        stackable = false;
        unique = true;
    }

    private static final String AC_WHISTLE = "WHISTLE";

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.add(AC_WHISTLE);
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        super.execute(hero, action);
        // Pet summoning logic goes here
    }
}
