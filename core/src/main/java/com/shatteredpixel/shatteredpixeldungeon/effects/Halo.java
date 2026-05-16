package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.watabou.noosa.Image;

// Halo / ring visual effect rendered around a character or point.
// Uses Flare as the backing visual until dedicated art exists.
public class Halo extends Image {

    private Flare flare;

    public Halo() {
        super();
        flare = new Flare(8, 24).color(0xFFFFAA, true).show(this, 0);
    }

    public Halo brightness(float value) {
        if (flare != null) flare.am = value;
        return this;
    }
}
