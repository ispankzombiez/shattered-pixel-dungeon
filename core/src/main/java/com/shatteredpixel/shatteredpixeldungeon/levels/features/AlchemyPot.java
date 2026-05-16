package com.shatteredpixel.shatteredpixeldungeon.levels.features;

import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.scenes.AlchemyScene;

public class AlchemyPot {

public static void useAlchemy(int pos) {
ShatteredPixelDungeon.switchScene(AlchemyScene.class);
}
}
