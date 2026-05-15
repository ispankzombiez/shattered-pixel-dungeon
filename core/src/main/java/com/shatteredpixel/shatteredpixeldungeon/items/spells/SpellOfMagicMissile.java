/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.spells;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.watabou.utils.Random;

public class SpellOfMagicMissile extends Spell {

    @Override
    protected void onCast(Hero hero) {
        detach(curUser.belongings.backpack);
        Mob nearest = null;
        int nearestDist = Integer.MAX_VALUE;
        for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
            int dist = Dungeon.level.distance(hero.pos, mob.pos);
            if (Dungeon.level.heroFOV[mob.pos] && dist < nearestDist) {
                nearest = mob;
                nearestDist = dist;
            }
        }
        if (nearest != null) {
            nearest.damage(Random.NormalIntRange(5, 15), hero);
        }
        hero.spendAndNext(1f);
    }

}
