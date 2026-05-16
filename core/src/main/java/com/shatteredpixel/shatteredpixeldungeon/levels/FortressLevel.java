package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.CityPainter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class FortressLevel extends CityLevel {

{
color1 = 0x4c5258;
color2 = 0x7f8b96;
}

@Override
public String tilesTex() {
return Assets.Environment.TILES_CITY;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_CITY;
}

@Override
protected Painter painter() {
    return new CityPainter()
            .setWater(0.10f, 4)
            .setGrass(0.05f, 3)
            .setTraps(nTraps(), trapClasses(), trapChances());
}
}
