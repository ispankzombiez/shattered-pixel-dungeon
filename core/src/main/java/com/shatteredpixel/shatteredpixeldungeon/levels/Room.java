package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.watabou.utils.Point;
import com.watabou.utils.Random;

public class Room {

public final int left;
public final int top;
public final int right;
public final int bottom;

public Room(int left, int top, int right, int bottom) {
if (left >= right || top >= bottom) {
throw new IllegalArgumentException("Invalid room bounds");
}
this.left = left;
this.top = top;
this.right = right;
this.bottom = bottom;
}

public int width() {
return right - left + 1;
}

public int height() {
return bottom - top + 1;
}

public Point center() {
return new Point((left + right) / 2, (top + bottom) / 2);
}

public Point random(int padding) {
int minX = left + Math.max(0, padding);
int maxX = right - Math.max(0, padding);
int minY = top + Math.max(0, padding);
int maxY = bottom - Math.max(0, padding);

if (minX > maxX) {
minX = maxX = (left + right) / 2;
}
if (minY > maxY) {
minY = maxY = (top + bottom) / 2;
}

return new Point(Random.IntRange(minX, maxX), Random.IntRange(minY, maxY));
}

public boolean contains(int x, int y) {
return x >= left && x <= right && y >= top && y <= bottom;
}

	public static Room randomRoom(int mapWidth, int mapHeight, int minWidth, int maxWidth, int minHeight, int maxHeight, int borderPadding) {
		int roomMinWidth = Math.max(3, Math.min(minWidth, maxWidth));
		int roomMaxWidth = Math.max(3, Math.max(minWidth, maxWidth));
		int roomMinHeight = Math.max(3, Math.min(minHeight, maxHeight));
		int roomMaxHeight = Math.max(3, Math.max(minHeight, maxHeight));

		int roomWidth = Random.IntRange(roomMinWidth, roomMaxWidth);
		int roomHeight = Random.IntRange(roomMinHeight, roomMaxHeight);

int minLeft = Math.max(1, borderPadding);
int maxLeft = Math.max(minLeft, mapWidth - roomWidth - borderPadding - 1);
int minTop = Math.max(1, borderPadding);
int maxTop = Math.max(minTop, mapHeight - roomHeight - borderPadding - 1);

int left = Random.IntRange(minLeft, maxLeft);
int top = Random.IntRange(minTop, maxTop);

return new Room(left, top, left + roomWidth - 1, top + roomHeight - 1);
}
}
