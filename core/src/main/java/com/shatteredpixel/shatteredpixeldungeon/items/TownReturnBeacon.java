package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.InterlevelScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.Game;

import java.util.ArrayList;

// Town return beacon — teleports the hero directly to the Town level.
public class TownReturnBeacon extends Item {

    public static final String AC_USE = "USE";

    {
        image = ItemSpriteSheet.RETURN_BEACON;
        unique = true;
        defaultAction = AC_USE;
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.add(AC_USE);
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        super.execute(hero, action);
        if (action.equals(AC_USE)) {
            if (!Dungeon.interfloorTeleportAllowed()) {
                GLog.w(Messages.get(ScrollOfTeleportation.class, "no_tele"));
                return;
            }
            Level.beforeTransition();
            InterlevelScene.mode = InterlevelScene.Mode.RETURN;
            InterlevelScene.returnDepth = 23;
            InterlevelScene.returnBranch = 2;
            InterlevelScene.returnPos = -1;
            Game.switchScene(InterlevelScene.class);
        }
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }
}
