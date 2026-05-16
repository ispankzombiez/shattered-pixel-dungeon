package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Random;

public class SokobanLayouts2 {

private static final String[][] LAYOUTS = new String[][]{
{
"#########",
"#..b....#",
"#.###v#.#",
"#....t..#",
"#########"
},
{
"#########",
"#....b..#",
"#.#v###.#",
"#..t....#",
"#########"
}
};

private SokobanLayouts2() {
}

public static String[] randomLayout() {
return Random.element(LAYOUTS).clone();
}
}
