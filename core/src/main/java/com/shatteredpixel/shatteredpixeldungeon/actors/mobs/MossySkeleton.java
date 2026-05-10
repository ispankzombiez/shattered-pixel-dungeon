package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.items.RedDewdrop;
import com.shatteredpixel.shatteredpixeldungeon.items.YellowDewdrop;

public class MossySkeleton extends Skeleton {
	{
		loot = new YellowDewdrop();
		lootChance = 0.5f;
		lootThird = new RedDewdrop();
		lootChanceThird = 0.1f;
	}
}
