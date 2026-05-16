package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.SanChikarahDeath;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.HallsPainter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.watabou.noosa.Group;

public class CatacombLevel extends HallsLevel {

{
color1 = 0x534f3e;
color2 = 0xb9d661;
}

@Override
public String tilesTex() {
return Assets.Environment.TILES_HALLS;
}

@Override
public String waterTex() {
return Assets.Environment.WATER_HALLS;
}

@Override
protected Painter painter() {
    return new HallsPainter()
            .setWater(0.15f, 6)
            .setGrass(0.10f, 3)
            .setTraps(nTraps(), trapClasses(), trapChances());
}

@Override
protected boolean build() {
	boolean built = super.build();
	if (built) {
		// Sprouted: entrance and exit appear as pedestals; chasms are filled.
		for (int i = 0; i < length(); i++) {
			if (map[i] == Terrain.ENTRANCE || map[i] == Terrain.EXIT) {
				map[i] = Terrain.PEDESTAL;
			} else if (map[i] == Terrain.CHASM) {
				map[i] = Terrain.EMPTY;
			}
		}
	}
	return built;
}

@Override
protected void createItems() {
	// Drop SanChikarahDeath near the exit on first generation.
	if (!Dungeon.sanchikarahdeath) {
		drop(new SanChikarahDeath(), exit());
		Dungeon.sanchikarahdeath = true;
	}

	super.createItems();
}

@Override
public Group addVisuals() {
	super.addVisuals();
	// Add Sprouted-style dripping water effects on decorated walls near water.
	SewerLevel.addSewerVisuals(this, visuals);
	return visuals;
}
}
