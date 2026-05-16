package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Healing;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Ported from Sprouted Pixel Dungeon.
// A dew-collecting plant that slowly heals the hero who steps on it.
public class Dewcatcher extends Plant {

    {
        image = 14; // uses sungrass visual as placeholder
        seedClass = Seed.class;
    }

    @Override
    public void activate(Char ch) {
        if (ch != null) {
            Buff.affect(ch, Healing.class).setHeal((int)(0.2f * ch.HT) + 1, 0.333f, 0);
        }
    }

    public static class Seed extends Plant.Seed {
        {
            image = ItemSpriteSheet.SEED_SUNGRASS; // placeholder sprite
            plantClass = Dewcatcher.class;
            alchemyClass = Dewcatcher.class;
        }
    }
}
