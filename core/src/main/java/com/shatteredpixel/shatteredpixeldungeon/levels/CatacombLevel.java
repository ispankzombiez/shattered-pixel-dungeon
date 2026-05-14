package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

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
protected float waterFill() {
return 0.15f;
}

@Override
protected float grassFill() {
return 0.10f;
}
}
