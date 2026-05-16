package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.LevelTransition;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.watabou.utils.Point;

public class TenguHideoutLevel extends TenguDenLevel {

@Override
protected boolean build() {
int size = Math.max(33, levelSize());
setSize(size, size);
Painter.fill(this, 0, 0, width(), height(), Terrain.WALL);

MazeLayout maze = MazeLayout.generate(width() - 2, height() - 2);
for (int y = 1; y < height() - 1; y++) {
for (int x = 1; x < width() - 1; x++) {
if (maze.open(x - 1, y - 1)) {
map[pointToCell(new Point(x, y))] = Terrain.EMPTY;
}
}
}

int entranceCell = pointToCell(new Point(1, 1));
int exitCell = pointToCell(new Point(width() - 2, height() - 2));

map[entranceCell] = Terrain.ENTRANCE;
map[exitCell] = Terrain.EXIT;
transitions.add(new LevelTransition(this, entranceCell, LevelTransition.Type.REGULAR_ENTRANCE));
transitions.add(new LevelTransition(this, exitCell, LevelTransition.Type.REGULAR_EXIT));

return true;
}

@Override
protected int mobTarget() {
return Dungeon.depth >= 25 ? 18 : 15;
}
}
