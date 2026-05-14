package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;

public class AlchemyPot {

public static void useAlchemy(int pos) {
if (Dungeon.level.heroFOV[pos]) {
GameScene.show(new com.shatteredpixel.shatteredpixeldungeon.windows.WndAlchemy());
}
}
}
