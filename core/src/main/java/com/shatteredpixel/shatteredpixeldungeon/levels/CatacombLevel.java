package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.HallsPainter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class CatacombLevel extends HallsLevel {

{
color1 = 0x534f3e;
color2 = 0xb9d661;
}

@Override
public String tilesTex() {
return Assets.Environment.TILES_HALLS;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_HALLS;
}

@Override
protected Painter painter() {
    return new HallsPainter()
            .setWater(0.15f, 6)
            .setGrass(0.10f, 3)
            .setTraps(nTraps(), trapClasses(), trapChances());
}
}
