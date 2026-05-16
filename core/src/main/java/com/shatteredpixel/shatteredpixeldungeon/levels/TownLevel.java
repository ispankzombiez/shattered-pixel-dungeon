package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Shopkeeper;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer4;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer5;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;

public class TownLevel extends SewerLevel {

{
color1 = 0x48763c;
color2 = 0x59994a;
viewDistance = 12;
}

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
	spawnTownNPC(new Shopkeeper());
	spawnTownNPC(new Shopkeeper());
	spawnTownNPC(new Tinkerer4());
	spawnTownNPC(new Tinkerer5());
}

private void spawnTownNPC(Mob npc) {
	// Use the parent's randomRespawnCell to find a valid position,
	// bypassing our override that always returns -1.
	int pos = super.randomRespawnCell(npc);
	if (pos != -1) {
		npc.pos = pos;
		mobs.add(npc);
		occupyCell(npc);
	}
}

@Override
public int randomRespawnCell(Char ch) {
	// Town is a safe zone — no mob respawning during gameplay.
	return -1;
}
}
