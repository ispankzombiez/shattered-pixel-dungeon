package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer1;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Tinkerer2;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.CavesPainter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class MineLevel extends CavesLevel {

{
color1 = 0x534f3e;
color2 = 0xb9d661;
}

@Override
public String tilesTex() {
return Assets.Environment.TILES_CAVES;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_CAVES;
}

@Override
protected Painter painter() {
    return new CavesPainter()
            .setWater(0.20f, 6)
            .setGrass(0.10f, 3)
            .setTraps(nTraps(), trapClasses(), trapChances());
}

@Override
protected void createItems() {
	// depth 11 = first Mine floor: introductory NPC who hints at mushroom quest.
	// Deeper Mine floors (12-14) get Tinkerer2 who does the actual mushroom trade.
	if (Dungeon.depth == 11) {
		SproutedLayoutStamp.placeNPC(this, new Tinkerer1());
	} else {
		SproutedLayoutStamp.placeNPC(this, new Tinkerer2());
	}

	super.createItems();
}
}
