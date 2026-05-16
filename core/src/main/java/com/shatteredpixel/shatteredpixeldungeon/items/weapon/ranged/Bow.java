package com.shatteredpixel.shatteredpixeldungeon.items.weapon.ranged;

// A standard bow that fires arrows.
public class Bow extends RangedWeapon {

    private static final int TIER = 2;

    @Override
    public int STRReq(int lvl) {
        return STRReq(TIER, lvl);
    }

    @Override
    public int min(int lvl) {
        return 1 + lvl;
    }

    @Override
    public int max(int lvl) {
        return 5 + 3 * lvl;
    }
}
