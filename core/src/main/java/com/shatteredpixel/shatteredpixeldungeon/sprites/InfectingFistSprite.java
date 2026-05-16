package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.watabou.noosa.particles.Emitter;

// Infecting fist boss appendage — inherits all animations from FistSprite.
public class InfectingFistSprite extends FistSprite {

    @Override
    protected int texOffset() {
        return 10;
    }

    @Override
    protected Emitter createEmitter() {
        return null;
    }
}
