package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.watabou.noosa.particles.Emitter;

// Rotting fist boss appendage — inherits all animations from FistSprite.
public class RottingFistSprite extends FistSprite {

    @Override
    protected int texOffset() {
        return 20;
    }

    @Override
    protected Emitter createEmitter() {
        return null;
    }
}
