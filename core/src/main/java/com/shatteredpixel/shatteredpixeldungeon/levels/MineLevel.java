package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

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
protected float waterFill() {
return 0.20f;
}

@Override
protected float grassFill() {
return 0.10f;
}
}
