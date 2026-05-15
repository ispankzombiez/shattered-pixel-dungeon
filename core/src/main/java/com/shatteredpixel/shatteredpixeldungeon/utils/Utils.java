package com.shatteredpixel.shatteredpixeldungeon.utils;

// General utility helper class for the Sprouted/Shattered hybrid.
// Game-specific utilities are typically handled by GLog, Messages, etc.
public class Utils {

    private Utils() {}

    public static String format(String format, Object... args) {
        return String.format(format, args);
    }
}
