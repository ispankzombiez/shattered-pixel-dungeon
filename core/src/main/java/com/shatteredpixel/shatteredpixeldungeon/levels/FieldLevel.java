package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

public class FieldLevel extends SproutedArenaLevel {

	{
		color1 = 0x48763c;
		color2 = 0x59994a;
		viewDistance = 6;
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
	protected float grassFill() {
		return 0.20f;
	}

	@Override
	protected float shrubFill() {
		return 0.12f;
	}

	@Override
	protected int mobTarget() {
		return 10;
	}
}
