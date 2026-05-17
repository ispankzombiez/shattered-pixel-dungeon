package com.shatteredpixel.shatteredpixeldungeon.levels;

public class Layouts {

private Layouts() {
}

public static Level branchLevel(int depth, int branch) {
switch (branch) {
case 2:
if (depth >= 11 && depth <= 14) return new MineLevel();
if (depth == 15) return new InfestBossLevel();
if (depth >= 16 && depth <= 19) return new FortressLevel();
if (depth >= 20 && depth <= 22) return new CatacombLevel();
if (depth == 23) return new TownLevel();
if (depth == 24) return new TenguDenLevel();
if (depth == 25) return new TenguHideoutLevel();
if (depth == 26) return new SokobanIntroLevel();
if (depth == 27) return new SokobanPuzzlesLevel();
if (depth == 28) return new SokobanPuzzles2Level();
if (depth == 29) return new SokobanTeleportLevel();
if (depth == 30) return new SokobanVaultLevel();
break;
case 3:
if (depth == 24) return new TownLevel();
if (depth == 25) return new TenguHideoutLevel();
break;
default:
break;
}
return null;
}

public static boolean hasBranchRoute(int depth, int branch) {
	return branchLevel(depth, branch) != null;
}

public static boolean isSproutedBranch(int branch) {
	return branch == 2 || branch == 3;
}

public static Room randomArenaRoom(int mapWidth, int mapHeight) {
return Room.randomRoom(mapWidth, mapHeight, 6, 10, 6, 10, 2);
}
}
