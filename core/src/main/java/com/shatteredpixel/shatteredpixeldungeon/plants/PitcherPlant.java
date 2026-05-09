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

package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.LeafParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

/**
 * Pitcher Plant — when triggered, scatters 1–2 random seeds onto the floor nearby.
 * Ported from Sprouted Pixel Dungeon's farming mechanic.
 */
public class PitcherPlant extends Plant {

	{
		// Reuse the Mageroyal plant tile (index 7) as a visual placeholder.
		// A dedicated tile can be added later when art is available.
		image = 7;
		seedClass = Seed.class;
	}

	@Override
	public void activate( Char ch ) {
		int drops = Random.IntRange(1, 2);
		// Warden gets an extra seed
		if (ch instanceof com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero
				&& ((com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero) ch).subClass
					== com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass.WARDEN) {
			drops++;
		}
		for (int i = 0; i < drops; i++) {
			Plant.Seed seed;
			// Never drop another PitcherPlant seed to avoid runaway proliferation
			do {
				seed = (Plant.Seed) Generator.randomUsingDefaults(Generator.Category.SEED);
			} while (seed instanceof PitcherPlant.Seed);
			Dungeon.level.drop(seed, pos).sprite.drop();
		}

		if (Dungeon.level.heroFOV[pos]) {
			CellEmitter.get(pos).burst(LeafParticle.GENERAL, 6);
		}
	}

	public static class Seed extends Plant.Seed {

		{
			// Use the SEED_HOLDER sprite (the generic placeholder in the sprite sheet)
			// until a dedicated pitcher plant seed sprite is available.
			image = ItemSpriteSheet.SEED_HOLDER;

			plantClass = PitcherPlant.class;

			bones = true;
		}

		@Override
		public int value() {
			return 15 * quantity;
		}

		@Override
		public int energyVal() {
			return 2 * quantity;
		}
	}
}
