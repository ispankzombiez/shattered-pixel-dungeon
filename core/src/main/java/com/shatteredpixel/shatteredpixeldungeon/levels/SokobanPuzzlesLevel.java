package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.SewerPainter;

// First set of Sokoban puzzles.
public class SokobanPuzzlesLevel extends RegularLevel {

    @Override
    protected Painter painter() {
        return new SewerPainter()
                .setTraps(nTraps(), trapClasses(), trapChances());
    }
}
