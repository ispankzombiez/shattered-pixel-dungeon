package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ChampionEnemy;
import com.watabou.utils.Reflection;
import com.watabou.utils.Random;

public class Bestiary {

	public static Mob mob( int depth ) {
		return newMob( mobClass( depth ) );
	}

	public static Mob mutable( int depth ) {
		Class<? extends Mob> cl = mobClass( depth );

		if (Random.Int(30) == 0) {
			if (cl == Rat.class) {
				cl = Albino.class;
			} else if (cl == Thief.class) {
				cl = Bandit.class;
			} else if (cl == Brute.class) {
				cl = Shielded.class;
			} else if (cl == Monk.class) {
				cl = Senior.class;
			} else if (cl == Scorpio.class) {
				cl = Acidic.class;
			}
		}

		return newMob( cl );
	}

	private static Mob newMob( Class<? extends Mob> cl ) {
		Mob mob = Reflection.newInstance( cl );
		ChampionEnemy.rollForChampion( mob );
		return mob;
	}

	private static Class<? extends Mob> mobClass( int depth ) {

		if (depth >= 56 && depth <= 70) {
			return Random.Int(10) == 0 ? Gullin.class : Kupua.class;
		}

		float[] chances;
		Class<? extends Mob>[] classes;

		switch (depth) {
			case 1:
				chances = new float[]{1, 1, 1, 0.02f};
				classes = new Class[]{Rat.class, BrownBat.class, GreyRat.class, RatBoss.class};
				break;
			case 2:
				chances = new float[]{1, 0.5f, 1, 1};
				classes = new Class[]{Rat.class, BrownBat.class, Gnoll.class, GreyRat.class};
				break;
			case 3:
				chances = new float[]{1, 2, 1, 1, 0.2f, 0.02f};
				classes = new Class[]{Rat.class, Gnoll.class, Crab.class, GreyRat.class, BrownBat.class, Swarm.class};
				break;
			case 4:
				chances = new float[]{1, 2, 3, 2, 0.02f, 0.01f, 0.01f};
				classes = new Class[]{Rat.class, Gnoll.class, Crab.class, GreyRat.class, Swarm.class, Skeleton.class, Thief.class};
				break;
			case 5:
				chances = new float[]{1};
				classes = new Class[]{Goo.class};
				break;
			case 6:
				chances = new float[]{2, 4, 2, 1, 0.2f};
				classes = new Class[]{GreyRat.class, Skeleton.class, Thief.class, Swarm.class, Shaman.class};
				break;
			case 7:
				chances = new float[]{3, 1, 1, 1, 1, 0.02f};
				classes = new Class[]{Skeleton.class, Shaman.class, Thief.class, Swarm.class, FossilSkeleton.class, Assassin.class};
				break;
			case 8:
				chances = new float[]{3, 2, 1, 1, 1, 1, 0.2f, 0.02f};
				classes = new Class[]{Skeleton.class, Shaman.class, Gnoll.class, Thief.class, Swarm.class, FossilSkeleton.class, Assassin.class, Bat.class};
				break;
			case 9:
				chances = new float[]{3, 1, 3, 1, 1, 3, 0.02f, 0.01f};
				classes = new Class[]{Skeleton.class, FossilSkeleton.class, Shaman.class, Thief.class, Swarm.class, Assassin.class, Bat.class, Brute.class};
				break;
			case 10:
				chances = new float[]{1};
				classes = new Class[]{Tengu.class};
				break;
			case 11:
				chances = new float[]{1, 0.2f};
				classes = new Class[]{Bat.class, Brute.class};
				break;
			case 12:
				chances = new float[]{1, 1, 0.2f, 0.02f};
				classes = new Class[]{Bat.class, Brute.class, Spinner.class, BrokenRobot.class};
				break;
			case 13:
				chances = new float[]{1, 3, 1, 1, 0.02f, 0.2f};
				classes = new Class[]{Bat.class, Brute.class, Shaman.class, Spinner.class, Elemental.class, BrokenRobot.class};
				break;
			case 14:
				chances = new float[]{1, 3, 1, 4, 0.02f, 0.01f, 3};
				classes = new Class[]{Bat.class, Brute.class, Shaman.class, Spinner.class, Elemental.class, Monk.class, BrokenRobot.class};
				break;
			case 15:
				chances = new float[]{1};
				classes = new Class[]{DM300.class};
				break;
			case 16:
				chances = new float[]{1, 1, 0.2f};
				classes = new Class[]{Elemental.class, Warlock.class, Monk.class};
				break;
			case 17:
				chances = new float[]{1, 1, 1};
				classes = new Class[]{Elemental.class, Monk.class, Warlock.class};
				break;
			case 18:
				chances = new float[]{1, 2, 1, 1, 0.5f};
				classes = new Class[]{Elemental.class, Monk.class, Golem.class, Warlock.class, DwarfLich.class};
				break;
			case 19:
				chances = new float[]{1, 2, 3, 1, 0.02f, 2};
				classes = new Class[]{Elemental.class, Monk.class, Golem.class, Warlock.class, Succubus.class, DwarfLich.class};
				break;
			case 20:
				chances = new float[]{1};
				classes = new Class[]{King.class};
				break;
			case 22:
				chances = new float[]{1, 1};
				classes = new Class[]{Succubus.class, Eye.class};
				break;
			case 23:
				chances = new float[]{1, 2, 1, 0.5f};
				classes = new Class[]{Succubus.class, Eye.class, Scorpio.class, DemonGoo.class};
				break;
			case 24:
				chances = new float[]{1, 2, 3, 2};
				classes = new Class[]{Succubus.class, Eye.class, Scorpio.class, DemonGoo.class};
				break;
			case 25:
				chances = new float[]{1};
				classes = new Class[]{Yog.class};
				break;
			case 27:
				chances = new float[]{1, 0.05f};
				classes = new Class[]{GnollTrickster.class, ForestProtector.class};
				break;
			case 28:
				chances = new float[]{1, 0.05f};
				classes = new Class[]{MossySkeleton.class, GraveProtector.class};
				break;
			case 29:
				chances = new float[]{1, 0.05f};
				classes = new Class[]{AlbinoPiranha.class, FishProtector.class};
				break;
			case 30:
				chances = new float[]{1, 0.05f};
				classes = new Class[]{GoldThief.class, VaultProtector.class};
				break;
			case 31:
				chances = new float[]{1, 0.1f};
				classes = new Class[]{BlueWraith.class, DwarfLich.class};
				break;
			case 32:
				chances = new float[]{1};
				classes = new Class[]{Oni.class};
				break;
			case 33:
				chances = new float[]{1};
				classes = new Class[]{FlyingProtector.class};
				break;
			case 35:
				chances = new float[]{1, 1};
				classes = new Class[]{GreyOni.class, SpectralRat.class};
				break;
			case 36:
				chances = new float[]{1};
				classes = new Class[]{TenguDen.class};
				break;
			case 41:
				chances = new float[]{1};
				classes = new Class[]{BanditKing.class};
				break;
			default:
				chances = new float[]{1};
				classes = new Class[]{Eye.class};
				break;
		}

		return classes[Random.chances( chances )];
	}

	public static boolean isUnique( Char mob ) {
		return mob instanceof Goo || mob instanceof Tengu
				|| mob instanceof DM300 || mob instanceof King
				|| mob instanceof YogFist.BurningFist
				|| mob instanceof YogFist.SoiledFist
				|| mob instanceof FetidRat
				|| mob instanceof GnollTrickster
				|| mob instanceof GreatCrab;
	}
}
