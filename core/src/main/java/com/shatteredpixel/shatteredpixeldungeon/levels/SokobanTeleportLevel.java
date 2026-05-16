package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;

// Sokoban level with teleporter mechanics.
public class SokobanTeleportLevel extends RegularLevel {

    @Override
    protected boolean build() {
        boolean built = super.build();
        if (built) {
            SproutedLayoutStamp.centerStamp(this, SokobanLayouts.randomLayout(), true);
        }
        return built;
    }

    @Override
    protected Painter painter() {
        return new SewerPainter()
                .setTraps(nTraps(), trapClasses(), trapChances());
    }
}
