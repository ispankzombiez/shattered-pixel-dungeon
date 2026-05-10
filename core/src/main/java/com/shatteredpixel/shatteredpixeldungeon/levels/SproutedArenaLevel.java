package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Bestiary;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.LevelTransition;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

abstract class SproutedArenaLevel extends Level {

	private static final int LEVEL_SIZE = 32;
	private static final int HUB_RADIUS = 2;

	@Override
	protected boolean build() {
		setSize(LEVEL_SIZE, LEVEL_SIZE);

		int centerX = width() / 2;
		int centerY = height() / 2;
		int topMost = Integer.MAX_VALUE;
		int exitCell = -1;

		for (int i = 0; i < 8; i++) {
			int roomWidth = Random.IntRange(6, 10);
			int roomHeight = Random.IntRange(6, 10);
			int left = Random.IntRange(1, width() - roomWidth - 2);
			int top = Random.IntRange(1, height() - roomHeight - 2);
			int right = left + roomWidth - 1;
			int bottom = top + roomHeight - 1;

			Painter.fill(this, left, top, roomWidth, roomHeight, Terrain.EMPTY);
			carveConnection(centerX, centerY, (left + right) / 2, (top + bottom) / 2);

			if (top < topMost) {
				topMost = top;
				exitCell = pointToCell(new Point(Random.IntRange(left + 1, right - 1), top));
			}
		}

		Painter.fill(this, centerX - HUB_RADIUS, centerY - HUB_RADIUS,
				HUB_RADIUS * 2 + 1, HUB_RADIUS * 2 + 1, Terrain.EMPTY);

		int entranceCell = pointToCell(new Point(centerX, centerY));
		setTransitionCell(entranceCell, Terrain.ENTRANCE, LevelTransition.Type.REGULAR_ENTRANCE);

		if (exitCell == -1) {
			exitCell = pointToCell(new Point(centerX, 1));
		}
		setTransitionCell(exitCell, Terrain.EXIT, LevelTransition.Type.REGULAR_EXIT);

		applyTerrainVariants(entranceCell, exitCell);
		return true;
	}

	private void carveConnection(int x1, int y1, int x2, int y2) {
		int x = x1;
		int y = y1;
		while (x != x2) {
			Painter.set(this, pointToCell(new Point(x, y)), Terrain.EMPTY);
			x += Integer.compare(x2, x);
		}
		while (y != y2) {
			Painter.set(this, pointToCell(new Point(x, y)), Terrain.EMPTY);
			y += Integer.compare(y2, y);
		}
		Painter.set(this, pointToCell(new Point(x, y)), Terrain.EMPTY);
	}

	private void setTransitionCell(int cell, int terrain, LevelTransition.Type type) {
		map[cell] = terrain;
		transitions.add(new LevelTransition(this, cell, type));
	}

	private void applyTerrainVariants(int entranceCell, int exitCell) {
		if (waterFill() > 0f) {
			boolean[] waterPatch = Patch.generate(width(), height(), waterFill(), waterSmoothness(), true);
			for (int i = 0; i < length(); i++) {
				if (i != entranceCell && i != exitCell && map[i] == Terrain.EMPTY && waterPatch[i]) {
					map[i] = Terrain.WATER;
				}
			}
		}

		boolean[] grassPatch = grassFill() > 0f
				? Patch.generate(width(), height(), grassFill(), grassSmoothness(), true)
				: null;
		boolean[] shrubPatch = shrubFill() > 0f
				? Patch.generate(width(), height(), shrubFill(), shrubSmoothness(), true)
				: null;

		for (int i = width() + 1; i < length() - width() - 1; i++) {
			if (map[i] == Terrain.WALL && Random.Int(8) == 0) {
				map[i] = Terrain.WALL_DECO;
			} else if (map[i] == Terrain.EMPTY) {
				int n = 0;
				if (map[i + 1] == Terrain.WALL) n++;
				if (map[i - 1] == Terrain.WALL) n++;
				if (map[i + width()] == Terrain.WALL) n++;
				if (map[i - width()] == Terrain.WALL) n++;
				if (Random.Int(8) <= n) {
					map[i] = Terrain.EMPTY_DECO;
				} else if (shrubPatch != null && shrubPatch[i]) {
					map[i] = Terrain.FURROWED_GRASS;
				} else if (grassPatch != null && grassPatch[i]) {
					map[i] = Terrain.HIGH_GRASS;
				}
			}
		}

		for (int i = 0; i < width(); i++) {
			map[i] = Terrain.WALL;
			map[length() - 1 - i] = Terrain.WALL;
		}
		for (int i = 0; i < height(); i++) {
			map[i * width()] = Terrain.WALL;
			map[i * width() + width() - 1] = Terrain.WALL;
		}

		map[entranceCell] = Terrain.ENTRANCE;
		map[exitCell] = Terrain.EXIT;
	}

	protected float waterFill() {
		return 0f;
	}

	protected int waterSmoothness() {
		return 4;
	}

	protected float grassFill() {
		return 0f;
	}

	protected int grassSmoothness() {
		return 3;
	}

	protected float shrubFill() {
		return 0f;
	}

	protected int shrubSmoothness() {
		return 2;
	}

	protected abstract int mobTarget();

	protected int mobSpawnCell( Mob mob ) {
		return randomRespawnCell(mob);
	}

	@Override
	protected void createMobs() {
		for (int i = 0; i < mobTarget(); i++) {
			Mob mob = Bestiary.mob(Dungeon.depth);
			int pos;
			do {
				pos = mobSpawnCell(mob);
			} while (pos == -1);
			mob.pos = pos;
			mobs.add(mob);
			occupyCell(mob);
		}
	}

	@Override
	public float respawnCooldown() {
		return super.respawnCooldown() / 2f;
	}

	@Override
	protected void createItems() {
	}

	protected int randomPrizeCell() {
		int cell;
		int tries = 0;
		do {
			if (++tries > 60) {
				return entrance();
			}
			cell = Random.Int(length());
		} while (!passable[cell]
				|| cell == entrance()
				|| cell == exit()
				|| heaps.get(cell) != null
				|| Actor.findChar(cell) != null);
		return cell;
	}

	protected void dropPrize(Item item) {
		drop(item, randomPrizeCell()).type = Heap.Type.CHEST;
	}

}
