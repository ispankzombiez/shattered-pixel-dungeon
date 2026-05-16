package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
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
}
