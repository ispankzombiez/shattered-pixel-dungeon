package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.levels.traps.SokobanPortalTrap;
import com.watabou.utils.Point;

public final class SproutedLayoutStamp {

	private SproutedLayoutStamp() {
	}

	public static void centerStamp(Level level, String[] layout, boolean sokobanPortals) {
		if (layout == null || layout.length == 0) {
			return;
		}

		int layoutH = layout.length;
		int layoutW = 0;
		for (String row : layout) {
			layoutW = Math.max(layoutW, row.length());
		}

		int originX = Math.max(1, (level.width() - layoutW) / 2);
		int originY = Math.max(1, (level.height() - layoutH) / 2);

		for (int y = 0; y < layoutH; y++) {
			String row = layout[y];
			for (int x = 0; x < row.length(); x++) {
				int worldX = originX + x;
				int worldY = originY + y;
				if (worldX <= 0 || worldY <= 0 || worldX >= level.width() - 1 || worldY >= level.height() - 1) {
					continue;
				}
				int cell = level.pointToCell(new Point(worldX, worldY));
				switch (row.charAt(x)) {
					case '#':
						level.map[cell] = Terrain.WALL;
						break;
					case '.':
						level.map[cell] = Terrain.EMPTY;
						break;
					case 's':
						level.map[cell] = Terrain.GRASS;
						break;
					case 'b':
						level.map[cell] = Terrain.STATUE;
						break;
					case 't':
						level.map[cell] = Terrain.INACTIVE_TRAP;
						if (sokobanPortals) {
							level.setTrap(new SokobanPortalTrap().reveal(), cell);
						}
						break;
					default:
						break;
				}
			}
		}
	}

	/**
	 * Converts ENTRANCE and EXIT terrain to PEDESTAL (Sprouted branch-level visual),
	 * and fills CHASM tiles with EMPTY (Sprouted branch floors have no pits).
	 * The transitions list is unaffected so level routing continues to work normally.
	 */
	public static void applyBranchTerrainOverrides(Level level) {
		for (int i = 0; i < level.length(); i++) {
			int tile = level.map[i];
			if (tile == Terrain.ENTRANCE || tile == Terrain.EXIT) {
				level.map[i] = Terrain.PEDESTAL;
			} else if (tile == Terrain.CHASM) {
				level.map[i] = Terrain.EMPTY;
			}
		}
	}

	/**
	 * Places {@code npc} at a valid passable cell inside {@code level} and adds it to the mob list.
	 * Uses the provided {@code level}'s {@link Level#randomRespawnCell} to find a position.
	 * Does nothing if no valid cell is found.
	 */
	public static void placeNPC(Level level, Mob npc) {
		int pos = level.randomRespawnCell(npc);
		if (pos != -1) {
			npc.pos = pos;
			level.mobs.add(npc);
			level.occupyCell(npc);
		}
	}
}
