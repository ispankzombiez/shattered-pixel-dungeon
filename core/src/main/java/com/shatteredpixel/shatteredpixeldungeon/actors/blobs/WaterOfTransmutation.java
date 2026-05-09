/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * Sprouted Pixel Dungeon
 * Copyright (C) 2015 dachhack
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

package com.shatteredpixel.shatteredpixeldungeon.actors.blobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.BlobEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.Artifact;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.Scroll;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Plant;

public class WaterOfTransmutation extends WellWater {

	@Override
	protected boolean affectHero( Hero hero ) {
		return false;
	}

	@Override
	protected Item affectItem( Item item, int pos ) {
		if (item instanceof MeleeWeapon) {
			return changeWeapon( (MeleeWeapon) item );
		} else if (item instanceof Scroll) {
			return changeScroll( (Scroll) item );
		} else if (item instanceof Potion) {
			return changePotion( (Potion) item );
		} else if (item instanceof Ring) {
			return changeRing( (Ring) item );
		} else if (item instanceof Wand) {
			return changeWand( (Wand) item );
		} else if (item instanceof Plant.Seed) {
			return changeSeed( (Plant.Seed) item );
		} else if (item instanceof Artifact) {
			return changeArtifact( (Artifact) item );
		}
		return null;
	}

	private MeleeWeapon changeWeapon( MeleeWeapon w ) {
		MeleeWeapon n;
		do {
			n = (MeleeWeapon) Generator.random( Generator.Category.WEAPON );
		} while (n == null || n.getClass() == w.getClass() || n.tier != w.tier);

		int level = w.level();
		if (level > 0) n.upgrade( level );
		else if (level < 0) n.degrade( -level );
		n.enchantment = w.enchantment;
		n.levelKnown  = w.levelKnown;
		n.cursedKnown = w.cursedKnown;
		n.cursed      = w.cursed;
		return n;
	}

	private Ring changeRing( Ring r ) {
		Ring n;
		do {
			n = (Ring) Generator.random( Generator.Category.RING );
		} while (n.getClass() == r.getClass());

		int level = r.level();
		if (level > 0) n.upgrade( level );
		else if (level < 0) n.degrade( -level );
		n.levelKnown  = r.levelKnown;
		n.cursedKnown = r.cursedKnown;
		n.cursed      = r.cursed;
		return n;
	}

	private Artifact changeArtifact( Artifact a ) {
		Artifact n = Generator.randomArtifact();
		if (n != null) {
			n.cursedKnown = a.cursedKnown;
			n.cursed      = a.cursed;
			n.levelKnown  = a.levelKnown;
			n.transferUpgrade( a.visiblyUpgraded() );
		}
		return n;
	}

	private Wand changeWand( Wand w ) {
		Wand n;
		do {
			n = (Wand) Generator.random( Generator.Category.WAND );
		} while (n.getClass() == w.getClass());

		n.upgrade( w.level() );
		n.levelKnown  = w.levelKnown;
		n.cursedKnown = w.cursedKnown;
		n.cursed      = w.cursed;
		return n;
	}

	private Plant.Seed changeSeed( Plant.Seed s ) {
		Plant.Seed n;
		do {
			n = (Plant.Seed) Generator.random( Generator.Category.SEED );
		} while (n.getClass() == s.getClass());
		return n;
	}

	private Scroll changeScroll( Scroll s ) {
		Scroll n;
		do {
			n = (Scroll) Generator.random( Generator.Category.SCROLL );
		} while (n.getClass() == s.getClass());
		return n;
	}

	private Potion changePotion( Potion p ) {
		Potion n;
		do {
			n = (Potion) Generator.random( Generator.Category.POTION );
		} while (n.getClass() == p.getClass());
		return n;
	}

	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		emitter.start( Speck.factory( Speck.CHANGE ), 0.2f, 0 );
	}

	@Override
	public String tileDesc() {
		return Messages.get(this, "desc");
	}
}
