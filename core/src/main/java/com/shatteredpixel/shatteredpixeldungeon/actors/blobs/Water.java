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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.BlobEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.LeafParticle;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;

public class Water extends Blob {

	@Override
	protected void evolve() {
		super.evolve();

		if (volume > 0) {
			boolean mapUpdated = false;

			for (int i = area.left; i < area.right; i++) {
				for (int j = area.top; j < area.bottom; j++) {
					int cell = i + j * Dungeon.level.width();
					if (off[cell] > 0) {
						int c = Dungeon.level.map[cell];
						if (c == Terrain.EMPTY || c == Terrain.EMBERS || c == Terrain.EMPTY_DECO) {
							Level.set( cell, off[cell] > 9 ? Terrain.HIGH_GRASS : Terrain.GRASS );
							mapUpdated = true;
						} else if (c == Terrain.GRASS && off[cell] > 9) {
							Level.set( cell, Terrain.HIGH_GRASS );
							mapUpdated = true;
						}
					}
				}
			}

			if (mapUpdated) {
				GameScene.updateMap();
				Dungeon.observe();
			}
		}
	}

	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		emitter.start( LeafParticle.LEVEL_SPECIFIC, 0.2f, 0 );
	}

	@Override
	public String tileDesc() {
		return "A magical water is spreading here, feeding the growth of plants.";
	}
}
