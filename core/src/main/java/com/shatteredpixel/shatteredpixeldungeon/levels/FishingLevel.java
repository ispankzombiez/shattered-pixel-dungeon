package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.items.FishingBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;

public class FishingLevel extends SproutedArenaLevel {

	{
		color1 = 0x534f3e;
		color2 = 0xb9d661;
		viewDistance = 8;
	}

	@Override
	public String tilesTex() {
		return Assets.Environment.TILES_CAVES;
	}

	@Override
	public String waterTex() {
		return Assets.Environment.WATER_PRISON;
	}

	@Override
	protected float waterFill() {
		return 0.55f;
	}

	@Override
	protected int waterSmoothness() {
		return 6;
	}

	@Override
	protected int mobTarget() {
		return 30;
	}

	@Override
	protected int mobSpawnCell( Mob mob ) {
		int cell;
		int tries = 0;
		do {
			if (++tries > 60) {
				return -1;
			}
			cell = com.watabou.utils.Random.Int(length());
		} while (!water[cell] || Actor.findChar(cell) != null);
		return cell;
	}

	@Override
	protected void createItems() {
		dropPrize(new FishingBomb());
		drop(new PotionOfLevitation(), randomPrizeCell());
	}
}
