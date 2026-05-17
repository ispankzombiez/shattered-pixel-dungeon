package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.NornStoneAltar;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Shopkeeper;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer4;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer5;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;
import com.watabou.utils.Bundle;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class TownLevel extends SewerLevel {

{
color1 = 0x48763c;
color2 = 0x59994a;
viewDistance = 12;
}

private static final int ITEMS_PER_SHOPKEEPER = 6;
private static final int STORE_ITEM_TYPE_COUNT = 8;
private static final String STOCKED_FOR_DEPTH = "stocked_for_depth";
private int stockedForDepth = -1;

@Override
public String tilesTex() {
return Assets.Environment.TILES_SEWERS;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_SEWERS;
}

@Override
protected Painter painter() {
    return new SewerPainter()
            .setWater(0.05f, 5)
            .setGrass(0.30f, 4)
            .setTraps(nTraps(), trapClasses(), trapChances());
}

@Override
protected boolean build() {
	boolean built = super.build();
	if (built) {
		SproutedLayoutStamp.centerStamp(this, TownLayouts.randomLayout(), false);
	}
	return built;
}

@Override
protected void createMobs() {
	// Town is a safe hub; spawn Sprouted town NPCs instead of combat mobs.
	// placeNPCAtGeneration() uses the parent's respawn-cell logic (not the
	// -1 override below) so that NPCs get valid starting positions.
	placeNPCAtGeneration(new Shopkeeper());
	placeNPCAtGeneration(new Shopkeeper());
	placeNPCAtGeneration(new Tinkerer4());
	placeNPCAtGeneration(new Tinkerer5());
	placeNPCAtGeneration(new NornStoneAltar());
}

@Override
protected void createItems() {
	restockTownShops(true);
}

@Override
public void press(int cell, Char ch) {
	super.press(cell, ch);
	restockTownShops(false);
}

@Override
public void storeInBundle(Bundle bundle) {
	super.storeInBundle(bundle);
	bundle.put(STOCKED_FOR_DEPTH, stockedForDepth);
}

@Override
public void restoreFromBundle(Bundle bundle) {
	super.restoreFromBundle(bundle);
	stockedForDepth = bundle.getInt(STOCKED_FOR_DEPTH);
}

/**
 * Places {@code npc} at a valid cell during level generation.
 * Explicitly calls {@code super.randomRespawnCell()} to use the standard room-based
 * placement logic even though {@link #randomRespawnCell} is overridden to return -1
 * at runtime (preventing mob respawning in the safe town hub).
 */
private void placeNPCAtGeneration(Mob npc) {
	int pos = super.randomRespawnCell(npc);
	if (pos != -1) {
		npc.pos = pos;
		mobs.add(npc);
		occupyCell(npc);
	}
}

private void restockTownShops(boolean force) {
	int deepest = Math.max(1, Statistics.deepestFloor);
	if (!force && deepest <= stockedForDepth) {
		return;
	}

	for (Mob mob : mobs) {
		if (!(mob instanceof Shopkeeper)) {
			continue;
		}
		fillStockNear(mob.pos, ITEMS_PER_SHOPKEEPER);
	}
	stockedForDepth = deepest;
}

private void fillStockNear(int centerCell, int targetItems) {
	Point center = cellToPoint(centerCell);
	ArrayList<Integer> candidates = new ArrayList<>();
	for (int dy = -4; dy <= 4; dy++) {
		for (int dx = -4; dx <= 4; dx++) {
			if (dx == 0 && dy == 0) {
				continue;
			}
			int x = center.x + dx;
			int y = center.y + dy;
			if (x <= 0 || y <= 0 || x >= width() - 1 || y >= height() - 1) {
				continue;
			}
			int cell = pointToCell(new Point(x, y));
			if (!passable[cell] || solid[cell] || map[cell] == Terrain.ENTRANCE || map[cell] == Terrain.EXIT) {
				continue;
			}
			if (heaps.get(cell) != null || findMob(cell) != null) {
				continue;
			}
			candidates.add(cell);
		}
	}

	Random.shuffle(candidates);
	int placed = 0;
	for (int cell : candidates) {
		Heap heap = drop(storeItem(), cell);
		heap.type = Heap.Type.FOR_SALE;
		if (++placed >= targetItems) {
			break;
		}
	}
}

private Item storeItem() {
	switch (Random.Int(STORE_ITEM_TYPE_COUNT)) {
		case 0:
			return new ScrollOfUpgrade();
		case 1:
			return new ScrollOfIdentify();
		case 2:
		case 3:
			return new PotionOfHealing();
		case 4:
			return Generator.randomUsingDefaults(Generator.Category.POTION);
		case 5:
			return Generator.randomUsingDefaults(Generator.Category.SCROLL);
		case 6:
			return Generator.randomUsingDefaults(Generator.Category.FOOD);
		default:
			return Generator.random(Generator.Category.SEED);
	}
}

@Override
public int randomRespawnCell(Char ch) {
	// Town is a safe zone — no mob respawning during gameplay.
	return -1;
}
}
