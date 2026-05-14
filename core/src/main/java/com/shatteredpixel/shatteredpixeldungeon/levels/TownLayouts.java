package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Random;

public class TownLayouts {

private static final String[][] LAYOUTS = new String[][]{
{
"#####",
"#...#",
"#.s.#",
"#...#",
"#####"
},
{
"#####",
"#s..#",
"#...#",
"#..s#",
"#####"
}
};

private TownLayouts() {
}

public static String[] randomLayout() {
return Random.element(LAYOUTS).clone();
}
}
