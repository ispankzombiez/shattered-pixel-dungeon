package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;

// A wand carved from adamant — channels pure magical force.
public class AdamantWand extends Wand {

    {
        collisionProperties = Ballistica.STOP_TARGET;
    }

    @Override
    public void onZap(Ballistica attack) {
        Char ch = findChar(attack.collisionPos);
        if (ch != null) {
            ch.damage(damageRoll(), this);
        }
    }

    @Override
    public void onHit(Wand wand, Char attacker, Char defender, int damage) {
    }
}
