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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Fire;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Web;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.AllyBuff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Frost;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Lightning;
import com.shatteredpixel.shatteredpixeldungeon.effects.MagicMissile;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SnowParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SparkParticle;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MobSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ScorpioSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public abstract class EggPet extends DirectableAlly {

    public int petLevel = 1;
    public int kills = 0;
    public int experience = 0;
    public int cooldown = 0;
    public int goaways = 0;
    public boolean callback = false;
    public boolean stay = false;

    private static final String PET_LEVEL = "pet_level";
    private static final String KILLS = "kills";
    private static final String EXPERIENCE = "experience";
    private static final String COOLDOWN = "cooldown";
    private static final String GOAWAYS = "goaways";
    private static final String CALLBACK = "callback";
    private static final String STAY = "stay";

    {
        state = HUNTING;
        alignment = Char.Alignment.ALLY;
        intelligentAlly = true;
        immunities.add(AllyBuff.class);
    }

    public abstract void adjustStats(int level);

    public void spawn(int level){
        petLevel = Math.max(1, level);
        adjustStats(petLevel);
        HP = HT;
    }

    public void restoreHeroState(Hero hero){
        petLevel = Math.max(1, hero.eggPetLevel);
        kills = hero.eggPetKills;
        experience = hero.eggPetExperience;
        cooldown = hero.eggPetCooldown;
        goaways = hero.eggPetGoaways;
        callback = hero.eggPetCallback;
        stay = hero.eggPetStay;
        adjustStats(petLevel);
        HP = hero.eggPetHP > 0 ? Math.min(hero.eggPetHP, HT) : HT;
    }

    @Override
    public void storeInBundle(Bundle bundle) {
        super.storeInBundle(bundle);
        bundle.put(PET_LEVEL, petLevel);
        bundle.put(KILLS, kills);
        bundle.put(EXPERIENCE, experience);
        bundle.put(COOLDOWN, cooldown);
        bundle.put(GOAWAYS, goaways);
        bundle.put(CALLBACK, callback);
        bundle.put(STAY, stay);
    }

    @Override
    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        petLevel = Math.max(1, bundle.getInt(PET_LEVEL));
        kills = bundle.getInt(KILLS);
        experience = bundle.getInt(EXPERIENCE);
        cooldown = bundle.getInt(COOLDOWN);
        goaways = bundle.getInt(GOAWAYS);
        callback = bundle.getBoolean(CALLBACK);
        stay = bundle.getBoolean(STAY);
        adjustStats(petLevel);
        HP = Math.min(HP, HT);
    }

    @Override
    protected boolean act() {
        if (Dungeon.hero != null) {
            if (callback) {
                if (Dungeon.level.adjacent(pos, Dungeon.hero.pos)) {
                    callback = false;
                } else {
                    followHero();
                }
                attacksAutomatically = false;
            } else {
                attacksAutomatically = true;
            }
            Dungeon.hero.syncEggPet(this);
        } else {
            attacksAutomatically = true;
        }
        return super.act();
    }

    @Override
    protected Char chooseEnemy() {
        if (enemy != null && !enemy.isAlive() && enemy instanceof Mob) {
            kills++;
            experience += ((Mob) enemy).EXP;
            enemy = null;
            int expNeeded = 2 * petLevel * petLevel;
            if (experience >= expNeeded && petLevel < 20) {
                petLevel++;
                adjustStats(petLevel);
                HP = HT;
                experience = 0;
                GLog.p(Messages.get(EggPet.class, "level_up"));
            }
        }
        return super.chooseEnemy();
    }

    @Override
    public void damage(int dmg, Object src) {
        if (src instanceof Hero) {
            goaways++;
            GLog.n(Messages.get(EggPet.class, "warning"));
            if (goaways > 2) {
                flee();
                return;
            }
        }
        super.damage(dmg, src);
    }

    public void flee() {
        if (Dungeon.hero != null) {
            Dungeon.hero.clearEggPet();
        }
        GLog.n(Messages.get(EggPet.class, "left"));
        destroy();
    }

    @Override
    public void die(Object cause) {
        if (Dungeon.hero != null) {
            Dungeon.hero.clearEggPet();
        }
        GLog.n(Messages.get(EggPet.class, "died"));
        super.die(cause);
    }

    @Override
    public boolean interact(Char c) {
        if (c == Dungeon.hero) {
            if (Dungeon.level.adjacent(pos, c.pos)) {
                return super.interact(c);
            } else {
                followHero();
                return true;
            }
        }
        return super.interact(c);
    }

    @Override
    protected boolean getCloser(int target) {
        if (stay) {
            return false;
        }
        return super.getCloser(target);
    }

    @Override
    public String description() {
        return Messages.get(this, "desc");
    }

    protected void basicCooldownAct(int readyRate, String readyMessageKey){
        if (cooldown > 0) {
            cooldown = Math.max(cooldown - readyRate, 0);
            if (cooldown == 0) {
                GLog.w(Messages.get(this, readyMessageKey));
            }
        }
    }

    @Override
    public int drRoll() {
        return super.drRoll();
    }

    public static class SpiderPet extends EggPet {
        {
            spriteClass = SpiderPetSprite.class;
            cooldown = 1000;
        }

        @Override public void adjustStats(int level) { petLevel = level; HT = (2 + level) * 5; defenseSkill = 1 + level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/5, HT/2); }
        @Override public int drRoll() { return super.drRoll() + petLevel; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "web_ready"); return super.act(); }
        @Override public int attackProc(Char enemy, int damage) {
            if (cooldown > 0 && Random.Int(10) == 0) {
                Buff.affect(enemy, Poison.class).set(3 + petLevel);
                GameScene.add(Blob.seed(enemy.pos, Random.IntRange(5, 7), Web.class));
            }
            if (cooldown == 0) {
                Buff.affect(enemy, Poison.class).set(6 + 2*petLevel);
                GameScene.add(Blob.seed(enemy.pos, Random.IntRange(8, 9), Web.class));
                damage *= 2;
                cooldown = 1000;
            }
            return super.attackProc(enemy, damage);
        }
    }

    public static class ScorpionPet extends EggPet {
        {
            spriteClass = ScorpioSprite.class;
            cooldown = 1000;
        }

        @Override public void adjustStats(int level) { petLevel = level; HT = (2 + level) * 8; defenseSkill = 1 + level*2; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/4, HT); }
        @Override public int drRoll() { return super.drRoll() + petLevel*2; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "sting_ready"); return super.act(); }
        @Override public int attackProc(Char enemy, int damage) {
            if (cooldown > 0 && Random.Int(10) == 0) {
                Buff.prolong(enemy, Paralysis.class, Random.Float(1f, 1.5f + petLevel));
            }
            if (cooldown == 0) {
                Buff.prolong(enemy, Paralysis.class, Random.Float(1f, 1.5f + petLevel));
                HP = Math.min(HT, HP + damage);
                Dungeon.hero.HP = Math.min(Dungeon.hero.HT, Dungeon.hero.HP + damage);
                sprite.emitter().start(Speck.factory(Speck.HEALING), 0.4f, 1);
                Dungeon.hero.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.4f, 1);
                damage *= 2;
                cooldown = 1000;
                yell(Messages.get(this, "sting"));
            }
            return super.attackProc(enemy, damage);
        }
    }

    public static class VelociroosterPet extends EggPet {
        {
            spriteClass = VelociroosterPetSprite.class;
            cooldown = 1000;
        }

        @Override public void adjustStats(int level) { petLevel = level; HT = (2 + level) * 5; defenseSkill = 1 + level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() {
            if (cooldown == 0) {
                cooldown = 1000;
                yell(Messages.get(this, "bwak"));
                return Random.NormalIntRange(HT/2, HT);
            }
            return Random.NormalIntRange(HT/5, HT/2);
        }
        @Override public int drRoll() { return super.drRoll() + petLevel*3; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "attack_ready"); return super.act(); }
    }

    public abstract static class RangedDragonPet extends EggPet implements Callback {
        protected static final float TIME_TO_ZAP = 1f;
        @Override protected boolean canAttack(Char enemy) {
            if (cooldown > 0) return Dungeon.level.adjacent(pos, enemy.pos);
            return new Ballistica(pos, enemy.pos, Ballistica.PROJECTILE).collisionPos == enemy.pos;
        }
        @Override protected boolean doAttack(Char enemy) {
            if (Dungeon.level.adjacent(pos, enemy.pos)) return super.doAttack(enemy);
            boolean visible = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];
            if (visible) ((Zapper) sprite).zap(enemy.pos); else zap();
            return !visible;
        }
        protected abstract void onZap(Char enemy);
        protected void zap(){
            spend(TIME_TO_ZAP);
            cooldown = 1000;
            yell(Messages.get(this, "roar"));
            if (hit(this, enemy, true)) onZap(enemy);
            else enemy.sprite.showStatus(CharSprite.NEUTRAL, enemy.defenseVerb());
        }
        public void onZapComplete() { zap(); next(); }
        @Override public void call() { next(); }
    }

    public static class RedDragonPet extends RangedDragonPet {
        {
            spriteClass = RedDragonPetSprite.class;
            flying = true;
            cooldown = 1000;
        }
        @Override public void adjustStats(int level) { petLevel = level; HT = (2 + level) * 15; defenseSkill = 1 + level*level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/5, HT/2); }
        @Override public int drRoll() { return super.drRoll() + petLevel*3; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "flame_ready"); return super.act(); }
        @Override protected void onZap(Char enemy) { int dmg = damageRoll()*2; enemy.damage(dmg, this); if (Random.Int(Math.max(1, dmg)) < petLevel) GameScene.add(Blob.seed(enemy.pos, 1, Fire.class)); }
    }

    public static class BlueDragonPet extends RangedDragonPet {
        {
            spriteClass = BlueDragonPetSprite.class;
            flying = true;
            cooldown = 1000;
        }
        @Override public void adjustStats(int level) { petLevel = level; HT = (3 + level) * 12; defenseSkill = 1 + level*level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/5, HT/2); }
        @Override public int drRoll() { return super.drRoll() + petLevel*4; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, isDecember() ? "snowman" : "chilly"); return super.act(); }
        @Override protected void onZap(Char enemy) { int dmg = damageRoll()*2; enemy.damage(dmg, this); Buff.prolong(enemy, Frost.class, Frost.DURATION * Random.Float(1f, 1.5f)); CellEmitter.get(enemy.pos).start(SnowParticle.FACTORY, 0.2f, 6); }
        @Override protected void zap() { spend(TIME_TO_ZAP); cooldown = 1000; yell(Messages.get(this, isDecember() ? "let_it_go" : "roar")); if (hit(this, enemy, true)) onZap(enemy); else enemy.sprite.showStatus(CharSprite.NEUTRAL, enemy.defenseVerb()); }
    }

    public static class VioletDragonPet extends RangedDragonPet {
        {
            spriteClass = VioletDragonPetSprite.class;
            flying = true;
            cooldown = 1000;
        }
        @Override public float attackDelay() { return 0.8f; }
        @Override public void adjustStats(int level) { petLevel = level; HT = Math.max(1, level) * 14; defenseSkill = 5 + level*level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/5, HT/2); }
        @Override public int drRoll() { return super.drRoll() + petLevel*5; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "poison_ready"); return super.act(); }
        @Override protected void onZap(Char enemy) { int dmg = damageRoll()*2; enemy.damage(dmg, this); Buff.affect(enemy, Poison.class).set(2f + petLevel); }
    }

    public static class GreenDragonPet extends RangedDragonPet {
        {
            spriteClass = GreenDragonPetSprite.class;
            flying = true;
            cooldown = 1000;
        }
        @Override public float attackDelay() { return 0.8f; }
        @Override public void adjustStats(int level) { petLevel = level; HT = Math.max(1, level) * 10; defenseSkill = 5 + level*level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(HT/5, HT/2); }
        @Override public int drRoll() { return super.drRoll() + petLevel*3; }
        @Override protected boolean act() { basicCooldownAct(petLevel*petLevel, "crackle_ready"); return super.act(); }
        @Override protected void onZap(Char enemy) { int dmg = damageRoll()*2; if (Dungeon.level.water[enemy.pos] && !enemy.flying) dmg = Math.round(dmg * 1.5f); enemy.damage(dmg, this); enemy.sprite.centerEmitter().burst(SparkParticle.FACTORY, 3); enemy.sprite.flash(); }
    }

    public static class FairyPet extends EggPet implements Callback {
        protected static final float TIME_TO_ZAP = 2f;
        {
            spriteClass = FairyPetSprite.class;
            flying = true;
            cooldown = 1000;
        }
        @Override public float attackDelay() { return 0.5f; }
        @Override public void adjustStats(int level) { petLevel = level; HT = Math.max(1, level) * 8; defenseSkill = 5 + level*level; }
        @Override public int attackSkill(Char target) { return defenseSkill; }
        @Override public int damageRoll() { return Random.NormalIntRange(defenseSkill/2, defenseSkill); }
        @Override public int drRoll() { return super.drRoll() + petLevel*2; }
        @Override protected boolean act() {
            basicCooldownAct(petLevel*petLevel, "sparkle_ready");
            if (cooldown == 0 && Dungeon.level.adjacent(pos, Dungeon.hero.pos) && Random.Int(2) == 0) {
                int bless = Random.Int(Math.max(1, petLevel*petLevel));
                Dungeon.hero.HP = Math.min(Dungeon.hero.HT, Dungeon.hero.HP + bless);
                Dungeon.hero.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.4f, 1);
                Dungeon.hero.sprite.showStatus(CharSprite.POSITIVE, Integer.toString(bless));
            }
            return super.act();
        }
        @Override protected boolean canAttack(Char enemy) { return new Ballistica(pos, enemy.pos, Ballistica.PROJECTILE).collisionPos == enemy.pos; }
        @Override protected boolean doAttack(Char enemy) {
            if (Dungeon.level.adjacent(pos, enemy.pos)) return super.doAttack(enemy);
            boolean visible = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];
            if (visible) ((Zapper) sprite).zap(enemy.pos); else zap();
            return !visible;
        }
        protected void zap(){
            spend(TIME_TO_ZAP);
            cooldown = 1000;
            yell(Messages.get(this, "take_that"));
            if (hit(this, enemy, true)) {
                int dmg = damageRoll()*2;
                if (Dungeon.level.water[enemy.pos] && !enemy.flying) dmg = Math.round(dmg*1.5f);
                enemy.damage(dmg, this);
                enemy.sprite.centerEmitter().burst(SparkParticle.FACTORY, 3);
                enemy.sprite.flash();
            } else enemy.sprite.showStatus(CharSprite.NEUTRAL, enemy.defenseVerb());
        }
        public void onZapComplete() { zap(); next(); }
        @Override public void call() { next(); }
    }

    public static class SugarplumFairyPet extends FairyPet {
        {
            spriteClass = SugarplumFairyPetSprite.class;
        }
        @Override public void adjustStats(int level) { petLevel = level; HT = Math.max(1, level) * 10; defenseSkill = 5 + level*level; }
        @Override public int drRoll() { return super.drRoll() + petLevel*3; }
        @Override protected boolean act() {
            basicCooldownAct(petLevel*petLevel, "sparkle_ready");
            if (cooldown == 0 && Dungeon.level.adjacent(pos, Dungeon.hero.pos)) {
                int bless = Random.Int(Math.max(1, petLevel*petLevel));
                Dungeon.hero.HP = Math.min(Dungeon.hero.HT, Dungeon.hero.HP + bless);
                Dungeon.hero.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.4f, 1);
                Dungeon.hero.sprite.showStatus(CharSprite.POSITIVE, Integer.toString(bless));
                if (Random.Int(20) == 0) { Dungeon.hero.earnExp(5, EggPet.class); Dungeon.hero.sprite.showStatus(CharSprite.POSITIVE, "+5 exp"); cooldown = 1000; }
                if (Random.Int(100) == 0) { Dungeon.hero.HT += 1; Dungeon.hero.HP += 1; Dungeon.hero.sprite.showStatus(CharSprite.POSITIVE, "+1 HT"); cooldown = 1000; }
            }
            return super.act();
        }
    }

    private static boolean isDecember(){
        return java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) == java.util.Calendar.DECEMBER;
    }

    public interface Zapper { void zap(int cell); }

    public static class SpiderPetSprite extends MobSprite {
        public SpiderPetSprite() { super(); perspectiveRaise = 0f; texture(Assets.Sprites.SPINNER); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(10, true); idle.frames(frames, 16,16,16,16,16,17,16,17); run = new Animation(15, true); run.frames(frames, 16,18,16,19); attack = new Animation(12, false); attack.frames(frames, 16,20,21,16); die = new Animation(12, false); die.frames(frames, 22,23,24,25); play(idle); }
        @Override public int blood() { return 0xFFBFE5B8; }
    }

    public static class RedDragonPetSprite extends MobSprite implements Zapper {
        public RedDragonPetSprite() { super(); texture(Assets.Sprites.PET_DRAGON); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(2, true); idle.frames(frames, 0,1,2,3); run = new Animation(8, true); run.frames(frames, 4,5,6,7); attack = new Animation(8, false); attack.frames(frames, 8,9,10,11); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 12,13,14,15); play(idle); }
        @Override public void zap(int cell) { turnTo(ch.pos, cell); play(zap); MagicMissile.boltFromChar(parent, MagicMissile.FIRE, this, cell, new Callback() { @Override public void call() { ((RedDragonPet) ch).onZapComplete(); } }); Sample.INSTANCE.play(Assets.Sounds.ZAP); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class BlueDragonPetSprite extends MobSprite implements Zapper {
        public BlueDragonPetSprite() { super(); texture(Assets.Sprites.PET_DRAGON); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(2, true); idle.frames(frames, 16,17,18,19); run = new Animation(8, true); run.frames(frames, 20,21,22,23); attack = new Animation(8, false); attack.frames(frames, 24,25,26,27); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 28,29,30,31); play(idle); }
        @Override public void zap(int cell) { turnTo(ch.pos, cell); play(zap); MagicMissile.boltFromChar(parent, MagicMissile.FROST, this, cell, new Callback() { @Override public void call() { ((BlueDragonPet) ch).onZapComplete(); } }); Sample.INSTANCE.play(Assets.Sounds.ZAP); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class VioletDragonPetSprite extends MobSprite implements Zapper {
        public VioletDragonPetSprite() { super(); texture(Assets.Sprites.PET_DRAGON); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(2, true); idle.frames(frames, 32,33,34,35); run = new Animation(8, true); run.frames(frames, 36,37,38,39); attack = new Animation(8, false); attack.frames(frames, 40,41,42,43); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 44,45,46,47); play(idle); }
        @Override public void zap(int cell) { turnTo(ch.pos, cell); play(zap); MagicMissile.boltFromChar(parent, MagicMissile.POISON, this, cell, new Callback() { @Override public void call() { ((VioletDragonPet) ch).onZapComplete(); } }); Sample.INSTANCE.play(Assets.Sounds.ZAP); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class GreenDragonPetSprite extends MobSprite implements Zapper {
        public GreenDragonPetSprite() { super(); texture(Assets.Sprites.PET_DRAGON); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(2, true); idle.frames(frames, 48,49,50,51); run = new Animation(8, true); run.frames(frames, 52,53,54,55); attack = new Animation(8, false); attack.frames(frames, 56,57,58,59); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 60,61,62,63); play(idle); }
        @Override public void zap(int pos) { parent.add(new Lightning(ch.sprite.center(), pos, new Callback() { @Override public void call() { ((GreenDragonPet) ch).onZapComplete(); } })); turnTo(ch.pos, pos); play(zap); Sample.INSTANCE.play(Assets.Sounds.LIGHTNING); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class FairyPetSprite extends MobSprite implements Zapper {
        public FairyPetSprite() { super(); texture(Assets.Sprites.FAIRY); TextureFilm frames = new TextureFilm(texture, 15, 15); idle = new Animation(2, true); idle.frames(frames, 0,2,3,0); run = new Animation(8, true); run.frames(frames, 0,1,2,0); attack = new Animation(8, false); attack.frames(frames, 0,3,4,1); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 5,6,7,7); play(idle); }
        @Override public void zap(int pos) { parent.add(new Lightning(ch.sprite.center(), pos, new Callback() { @Override public void call() { ((FairyPet) ch).onZapComplete(); } })); turnTo(ch.pos, pos); play(zap); Sample.INSTANCE.play(Assets.Sounds.LIGHTNING); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class SugarplumFairyPetSprite extends MobSprite implements Zapper {
        public SugarplumFairyPetSprite() { super(); texture(Assets.Sprites.FAIRY); TextureFilm frames = new TextureFilm(texture, 15, 15); idle = new Animation(2, true); idle.frames(frames, 16,18,19,16); run = new Animation(8, true); run.frames(frames, 16,17,18,16); attack = new Animation(8, false); attack.frames(frames, 16,19,20,17); zap = attack.clone(); die = new Animation(8, false); die.frames(frames, 21,22,23,23); play(idle); }
        @Override public void zap(int pos) { parent.add(new Lightning(ch.sprite.center(), pos, new Callback() { @Override public void call() { ((SugarplumFairyPet) ch).onZapComplete(); } })); turnTo(ch.pos, pos); play(zap); Sample.INSTANCE.play(Assets.Sounds.LIGHTNING); }
        @Override public int blood() { return 0xFFCDCDB7; }
    }

    public static class VelociroosterPetSprite extends MobSprite {
        public VelociroosterPetSprite() { super(); texture(Assets.Sprites.VELOCIROOSTER); TextureFilm frames = new TextureFilm(texture, 16, 16); idle = new Animation(2, true); idle.frames(frames, 0,0,1); run = new Animation(10, true); run.frames(frames, 3,4,5,4); attack = new Animation(14, false); attack.frames(frames, 1,2,1); die = new Animation(10, false); die.frames(frames, 1,6,7); play(idle); }
        @Override public int blood() { return 0xFFFFEA80; }
    }
}
