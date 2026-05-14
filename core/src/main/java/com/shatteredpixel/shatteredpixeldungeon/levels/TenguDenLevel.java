package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

public class TenguDenLevel extends SproutedArenaLevel {

{
color1 = 0x4c5258;
color2 = 0x7f8b96;
viewDistance = 8;
}

@Override
public String tilesTex() {
return Assets.Environment.TILES_PRISON;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_PRISON;
}

@Override
protected float waterFill() {
return 0.12f;
}

@Override
protected float grassFill() {
return 0.08f;
}

@Override
protected int mobTarget() {
return 14;
}
}
