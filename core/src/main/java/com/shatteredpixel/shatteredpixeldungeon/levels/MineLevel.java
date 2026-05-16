package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
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
	// Spawn Tinkerer2 NPC (Sprouted mine companion).
	SproutedLayoutStamp.placeNPC(this, new Tinkerer2());

	super.createItems();
}
}
