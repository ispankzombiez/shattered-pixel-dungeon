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

package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.BlueDragonPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.FairyPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.GreenDragonPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.RedDragonPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.ScorpionPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.SpiderPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.SugarplumFairyPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.VelociroosterPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet.VioletDragonPet;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Pushing;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SparkParticle;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.ShockingTrap;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.tweeners.AlphaTweener;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;
import java.util.Calendar;

public class Egg extends Item {

    public static final String AC_BREAK = "BREAK_OPEN";
    public static final String AC_SHAKE = "SHAKE";

    public static final int RED_DRAGON = 30;
    public static final int GREEN_DRAGON = 5;
    public static final int BLUE_DRAGON = isDecember() ? 1 : 5;
    public static final int VIOLET_DRAGON = 5;
    public static final int SPIDER = 2000;
    public static final int SCORPION = 10000;
    public static final int VELOCIROOSTER = 1;
    public static final int FAIRY = 10;

    protected static final float TIME_TO_USE = 1f;

    public int startMoves = 0;
    public int moves = 0;
    public int burns = 0;
    public int freezes = 0;
    public int poisons = 0;
    public int lits = 0;
    public int summons = 0;

    private static final String STARTMOVES = "startMoves";
    private static final String MOVES = "moves";
    private static final String BURNS = "burns";
    private static final String FREEZES = "freezes";
    private static final String POISONS = "poisons";
    private static final String LITS = "lits";
    private static final String SUMMONS = "summons";

    {
        image = ItemSpriteSheet.EASTER_EGG;
        unique = true;
        stackable = false;
        bones = true;
    }

    @Override
    public void storeInBundle(Bundle bundle) {
        super.storeInBundle(bundle);
        bundle.put(STARTMOVES, startMoves);
        bundle.put(MOVES, moves);
        bundle.put(BURNS, burns);
        bundle.put(FREEZES, freezes);
        bundle.put(POISONS, poisons);
        bundle.put(LITS, lits);
        bundle.put(SUMMONS, summons);
    }

    @Override
    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        startMoves = bundle.getInt(STARTMOVES);
        moves = bundle.getInt(MOVES);
        burns = bundle.getInt(BURNS);
        freezes = bundle.getInt(FREEZES);
        poisons = bundle.getInt(POISONS);
        lits = bundle.getInt(LITS);
        summons = bundle.getInt(SUMMONS);
    }

    public void onCarriedTurn(){
        moves++;
    }

    public void onBurn(){ burns++; }
    public void onFreeze(){ freezes++; }
    public void onPoison(){ poisons++; }
    public void onLit(){ lits++; }
    public void onSummon(){ summons++; }

    @Override
    public boolean doPickUp(Hero hero) {
        GLog.w(Messages.get(Egg.class, "warm"));
        Egg egg = hero.belongings.getItem(Egg.class);
        if (egg != null && egg != this) {
            GLog.w(Messages.get(Egg.class, "only_one"));
        }
        return super.doPickUp(hero);
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.add(AC_BREAK);
        actions.add(AC_SHAKE);
        return actions;
    }

    @Override
    public String actionName(String action, Hero hero) {
        if (AC_BREAK.equals(action)) return Messages.get(Egg.class, "ac_break");
        if (AC_SHAKE.equals(action)) return Messages.get(Egg.class, "ac_shake");
        return super.actionName(action, hero);
    }

    @Override
    public void execute(Hero hero, String action) {
        super.execute(hero, action);

        if (AC_BREAK.equals(action)) {
            boolean hatched = tryBreak(hero);
            if (!hatched) {
                detach(hero.belongings.backpack);
                GLog.w(Messages.get(Egg.class, "yolk"));
                hero.next();
            }

        } else if (AC_SHAKE.equals(action)) {
            shake(hero);
        }
    }

    protected boolean tryBreak(Hero hero){
        if (summons >= FAIRY) {
            return hatch(hero, isDecember() ? SugarplumFairyPet.class : FairyPet.class);
        } else if (freezes >= BLUE_DRAGON) {
            return hatch(hero, BlueDragonPet.class);
        } else if (poisons >= VIOLET_DRAGON) {
            return hatch(hero, VioletDragonPet.class);
        } else if (lits >= GREEN_DRAGON) {
            return hatch(hero, GreenDragonPet.class);
        } else if (burns >= RED_DRAGON) {
            return hatch(hero, RedDragonPet.class);
        } else if (burns >= VELOCIROOSTER) {
            return hatch(hero, VelociroosterPet.class);
        } else if (moves >= SCORPION) {
            return hatch(hero, ScorpionPet.class);
        } else if (moves >= SPIDER) {
            return hatch(hero, SpiderPet.class);
        }
        return false;
    }

    protected void shake(Hero hero){
        boolean alive = false;
        if (summons >= FAIRY) {
            GLog.w(Messages.get(Egg.class, "zap"));
            hero.sprite.centerEmitter().burst(SparkParticle.FACTORY, 3);
            hero.sprite.flash();
            hero.damage(1, ShockingTrap.class);
            alive = true;
        } else if (freezes >= BLUE_DRAGON || poisons >= VIOLET_DRAGON || lits >= GREEN_DRAGON || burns >= RED_DRAGON) {
            GLog.w(Messages.get(Egg.class, "kick"));
            alive = true;
        } else if (burns >= VELOCIROOSTER) {
            GLog.w(Messages.get(Egg.class, "scratch"));
            alive = true;
        } else if (moves >= SPIDER) {
            GLog.w(Messages.get(Egg.class, "slither"));
            alive = true;
        }
        if (!alive) GLog.w(Messages.get(Egg.class, "slosh"));
    }

    protected boolean hatch(Hero hero, Class<? extends EggPet> petClass) {
        if (hero.hasEggPet()) {
            hero.spend(TIME_TO_USE);
            GLog.w(Messages.get(Egg.class, "not_ready"));
            return true;
        }

        int spawnPos = getSpawnPos();
        if (spawnPos == -1) {
            hero.spend(TIME_TO_USE);
            GLog.w(Messages.get(Egg.class, "not_ready"));
            return true;
        }

        EggPet pet = Reflection.newInstance(petClass);
        pet.spawn(1);
        pet.pos = spawnPos;
        pet.state = pet.HUNTING;

        GameScene.add(pet);
        Dungeon.level.occupyCell(pet);
        Actor.addDelayed(new Pushing(pet, hero.pos, spawnPos), -1f);
        pet.sprite.alpha(0);
        pet.sprite.parent.add(new AlphaTweener(pet.sprite, 1, 0.15f));

        detach(hero.belongings.backpack);
        GLog.w(Messages.get(Egg.class, "hatch"));
        hero.setEggPet(petClass, pet);
        hero.next();
        return true;
    }

    protected int getSpawnPos() {
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int n : PathFinder.NEIGHBOURS8) {
            int c = Dungeon.hero.pos + n;
            if (Actor.findChar(c) == null && (Dungeon.level.passable[c] || Dungeon.level.avoid[c])) {
                candidates.add(c);
            }
        }
        return candidates.isEmpty() ? -1 : Random.element(candidates);
    }

    @Override
    public int value() {
        return 500 * quantity;
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }

    @Override
    public ItemSprite.Glowing glowing() {
        return null;
    }

    private static boolean isDecember(){
        return Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER;
    }
}
