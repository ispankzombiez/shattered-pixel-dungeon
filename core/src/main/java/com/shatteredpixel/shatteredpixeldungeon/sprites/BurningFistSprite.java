package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.watabou.noosa.particles.Emitter;

// Burning fist boss appendage — inherits all animations from FistSprite.
public class BurningFistSprite extends FistSprite {

    @Override
    protected int texOffset() {
        return 0;
    }

    @Override
    protected Emitter createEmitter() {
        return null;
    }
}
