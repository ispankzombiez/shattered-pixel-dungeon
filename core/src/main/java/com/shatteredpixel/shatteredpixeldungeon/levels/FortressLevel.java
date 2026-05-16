package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

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
protected float waterFill() {
return 0.10f;
}

@Override
protected float grassFill() {
return 0.05f;
}
}
