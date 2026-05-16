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

private static final String[][] VAULT_LAYOUTS = new String[][]{
{
"#########",
"#d.t...d#",
"#.###v#t#",
"#..b.v..#",
"#########"
},
{
"#########",
"#d..t..d#",
"#.#v###t#",
"#..b.v..#",
"#########"
}
};

private SokobanLayouts2() {
}

public static String[] randomLayout() {
return Random.element(LAYOUTS).clone();
}

public static String[] randomVaultLayout() {
return Random.element(VAULT_LAYOUTS).clone();
}
}
