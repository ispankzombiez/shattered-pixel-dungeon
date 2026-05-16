package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;

// A weapon forged from adamant — exceptional damage and durability.
public class AdamantWeapon extends MeleeWeapon {

    {
        tier = 6;
    }

    @Override
    public int max(int lvl) {
        return 5 * (tier + 1) + lvl * (tier + 1);
    }
}
