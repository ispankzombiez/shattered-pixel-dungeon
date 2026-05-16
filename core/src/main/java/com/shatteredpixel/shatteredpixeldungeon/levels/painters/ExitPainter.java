package com.shatteredpixel.shatteredpixeldungeon.levels.painters;

import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.Room;

import java.util.ArrayList;

public class ExitPainter extends Painter {

	@Override
	public boolean paint(Level level, ArrayList<Room> rooms) {
		return true;
	}
}
