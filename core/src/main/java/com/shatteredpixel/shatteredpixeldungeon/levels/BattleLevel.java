package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.items.HolyHandGrenade;

public class BattleLevel extends SproutedArenaLevel {

	{
		color1 = 0x6a723d;
		color2 = 0x88924c;
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
	protected float grassFill() {
		return 0.18f;
	}

	@Override
	protected float shrubFill() {
		return 0.10f;
	}

	@Override
	protected int mobTarget() {
		return 16;
	}

	@Override
	protected void createItems() {
		dropPrize(new HolyHandGrenade());
	}
}
