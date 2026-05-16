package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;

// First set of Sokoban puzzles.
public class SokobanPuzzlesLevel extends RegularLevel {

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
