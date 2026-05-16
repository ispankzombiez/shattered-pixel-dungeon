package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Random;

public class SokobanLayouts {

private static final String[][] LAYOUTS = new String[][]{
{
"#######",
"#..b..#",
"#.###v#",
"#..t..#",
"#######"
},
{
"#######",
"#..b..#",
"#.#.#v#",
"#..t..#",
"#######"
}
};

private static final String[][] TELEPORT_LAYOUTS = new String[][]{
{
"#######",
"#d.t..#",
"#.#v#.#",
"#..b..#",
"#######"
},
{
"#######",
"#..t.d#",
"#.#v#.#",
"#..b..#",
"#######"
}
};

private SokobanLayouts() {
}

public static String[] randomLayout() {
return Random.element(LAYOUTS).clone();
}

public static String[] randomTeleportLayout() {
return Random.element(TELEPORT_LAYOUTS).clone();
}
}
