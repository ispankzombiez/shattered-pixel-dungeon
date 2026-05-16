package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.watabou.noosa.Group;
import com.watabou.utils.PointF;

// Death ray visual effect — fires a beam from one cell to another.
// Acts as a thin wrapper around Lightning/Beam until dedicated art is added.
public class DeathRay extends Group {

    public DeathRay(PointF from, PointF to) {
        super();
        // placeholder: add a lightning bolt as a stand-in for the death ray
        Lightning bolt = new Lightning(from, to, null);
        add(bolt);
    }
}
