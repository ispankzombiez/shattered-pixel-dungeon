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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Chill;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Frost;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.DirectableAlly;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ElementalSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class FireDragon extends DirectableAlly {

// Baseline stats used before initAsPet() is called (i.e. if somehow created without hatching).
// initAsPet() overwrites these with depth-scaled values.
{
spriteClass = ElementalSprite.Fire.class;

HP = HT = 30;
defenseSkill = 10;

flying = true;

properties.add(Property.FIERY);
properties.add(Property.INORGANIC);
}

private boolean petInitialized = false;

/** Scales stats to the current dungeon depth, called by FireDragonEgg on hatch. */
public void initAsPet() {
petInitialized = true;
int regionScale = Math.max(2, (1 + Dungeon.scalingDepth() / 5));
HT = 15 * regionScale;
defenseSkill = 5 * regionScale;
}

@Override
public int damageRoll() {
int regionScale = Math.max(2, (1 + Dungeon.scalingDepth() / 5));
return Random.NormalIntRange(3 * regionScale, 6 * regionScale);
}

@Override
public int attackSkill(Char target) {
int regionScale = Math.max(2, (1 + Dungeon.scalingDepth() / 5));
return 5 + 5 * regionScale;
}

@Override
public int drRoll() {
return super.drRoll() + Random.NormalIntRange(0, 3);
}

@Override
protected boolean act() {
// ~10% chance per turn to regenerate 1 HP, giving ~1 HP/10 turns on average.
// Mirrors the regen mechanic from Sprouted PD's RedDragon.
if (HP < HT && Random.Float() < 0.1f) {
HP = Math.min(HP + 1, HT);
}
return super.act();
}

@Override
public int attackProc(Char enemy, int damage) {
damage = super.attackProc(enemy, damage);
// 50% chance to ignite on hit, matching FireElemental's melee proc
if (Random.Int(2) == 0 && !Dungeon.level.water[enemy.pos]) {
Buff.affect(enemy, Burning.class).reignite(enemy);
if (enemy.sprite.visible) Splash.at(enemy.sprite.center(), sprite.blood(), 5);
}
return damage;
}

@Override
public boolean add(Buff buff) {
// fire dragons are harmed by frost and chill, like FireElemental
if (buff instanceof Frost || buff instanceof Chill) {
damage(Random.NormalIntRange(HT / 2, HT * 3 / 5), buff);
return false;
}
return super.add(buff);
}

private static final String PET_INITIALIZED = "pet_initialized";

@Override
public void storeInBundle(Bundle bundle) {
super.storeInBundle(bundle);
bundle.put(PET_INITIALIZED, petInitialized);
}

@Override
public void restoreFromBundle(Bundle bundle) {
super.restoreFromBundle(bundle);
petInitialized = bundle.getBoolean(PET_INITIALIZED);
if (petInitialized) {
initAsPet();
}
}

}
