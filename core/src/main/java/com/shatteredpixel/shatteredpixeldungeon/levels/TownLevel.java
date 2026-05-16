package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

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
protected float waterFill() {
return 0.05f;
}

@Override
protected float grassFill() {
return 0.30f;
}
}
