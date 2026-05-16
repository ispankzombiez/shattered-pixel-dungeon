package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// An extremely hard adamant-alloy armor — tier 6 bonus armor.
public class AdamantArmor extends Armor {

    public AdamantArmor() {
        super(6);
        image = ItemSpriteSheet.ARMOR_PLATE;
    }
}
