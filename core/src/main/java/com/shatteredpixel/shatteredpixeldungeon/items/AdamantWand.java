package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.DamageWand;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;

// A wand carved from adamant — channels pure magical force.
public class AdamantWand extends DamageWand {

    {
        collisionProperties = Ballistica.STOP_TARGET;
    }

    @Override
    public int min(int lvl) {
        return 2 + lvl;
    }

    @Override
    public int max(int lvl) {
        return 8 + 4 * lvl;
    }

    @Override
    public void onZap(Ballistica attack) {
        Char ch = Actor.findChar(attack.collisionPos);
        if (ch != null) {
            ch.damage(damageRoll(), this);
        }
    }

    @Override
    public void onHit(MagesStaff wand, Char attacker, Char defender, int damage) {
    }
}
