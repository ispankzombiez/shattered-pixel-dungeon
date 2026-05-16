package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;

// Second set of Sokoban puzzles.
public class SokobanPuzzles2Level extends RegularLevel {

    @Override
    protected boolean build() {
        boolean built = super.build();
        if (built) {
            SproutedLayoutStamp.centerStamp(this, SokobanLayouts2.randomLayout(), true);
        }
        return built;
    }

    @Override
    protected Painter painter() {
        return new SewerPainter()
                .setTraps(nTraps(), trapClasses(), trapChances());
    }
}
