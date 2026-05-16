package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.watabou.noosa.particles.Emitter;

// Pinning fist boss appendage — inherits all animations from FistSprite.
public class PinningFistSprite extends FistSprite {

    @Override
    protected int texOffset() {
        return 30;
    }

    @Override
    protected Emitter createEmitter() {
        return null;
    }
}
