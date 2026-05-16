package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Random;

public class SokobanLayouts {

private static final String[][] LAYOUTS = new String[][]{
{
"#######",
"#..b..#",
"#.###.#",
"#..t..#",
"#######"
},
{
"#######",
"#..b..#",
"#.#.#.#",
"#..t..#",
"#######"
}
};

private SokobanLayouts() {
}

public static String[] randomLayout() {
return Random.element(LAYOUTS).clone();
}
}
