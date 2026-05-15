package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;

// A heavy dwarven hammer — tier 4 weapon.
public class DwarfHammer extends MeleeWeapon {

    {
        tier = 4;
    }

    @Override
    public int max(int lvl) {
        return 5 * (tier + 1) + lvl * (tier + 1);
    }
}
