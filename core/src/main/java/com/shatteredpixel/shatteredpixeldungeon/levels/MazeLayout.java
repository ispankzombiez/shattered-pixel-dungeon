package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Point;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class MazeLayout {

private final int width;
private final int height;
private final boolean[] open;

private MazeLayout(int width, int height, boolean[] open) {
this.width = width;
this.height = height;
this.open = open;
}

	public static MazeLayout generate(int width, int height) {
		if (width % 2 == 0) width--;
		if (height % 2 == 0) height--;
		if (width < 5 || height < 5) {
			throw new IllegalArgumentException("Maze must be at least 5x5");
		}

boolean[] open = new boolean[width * height];
carveMaze(width, height, open);
return new MazeLayout(width, height, open);
}

private static void carveMaze(int width, int height, boolean[] open) {
ArrayList<Point> stack = new ArrayList<>();
Point start = new Point(1, 1);
open[start.x + start.y * width] = true;
stack.add(start);

while (!stack.isEmpty()) {
Point current = stack.get(stack.size() - 1);
ArrayList<Point> candidates = new ArrayList<>();
candidates.add(new Point(current.x + 2, current.y));
candidates.add(new Point(current.x - 2, current.y));
candidates.add(new Point(current.x, current.y + 2));
candidates.add(new Point(current.x, current.y - 2));
Random.shuffle(candidates);

boolean carved = false;
for (Point next : candidates) {
if (next.x <= 0 || next.y <= 0 || next.x >= width - 1 || next.y >= height - 1) {
continue;
}
int nextIdx = next.x + next.y * width;
if (open[nextIdx]) {
continue;
}

int wallX = current.x + (next.x - current.x) / 2;
int wallY = current.y + (next.y - current.y) / 2;
open[wallX + wallY * width] = true;
open[nextIdx] = true;
stack.add(next);
carved = true;
break;
}

if (!carved) {
stack.remove(stack.size() - 1);
}
}
}

public boolean open(int x, int y) {
if (x < 0 || y < 0 || x >= width || y >= height) {
return false;
}
return open[x + y * width];
}

public int width() {
return width;
}

public int height() {
return height;
}
}
