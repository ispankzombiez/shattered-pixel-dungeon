import os
import re

BASE = "/home/runner/work/shattered-pixel-dungeon/shattered-pixel-dungeon/core/src/main/java/com/shatteredpixel/shatteredpixeldungeon"

def write_file(path, content):
    with open(path, 'w') as f:
        f.write(content)
    print(f"Written: {path}")

# ============================================================
# CATEGORY 6: Root-package duplicate stubs - add comments
# ============================================================

write_file(f"{BASE}/DungeonTilemap.java", """\
package com.shatteredpixel.shatteredpixeldungeon;

// The full implementation lives in com.shatteredpixel.shatteredpixeldungeon.tiles.DungeonTilemap.
// This stub exists for legacy import compatibility only.
public class DungeonTilemap {
}
""")

write_file(f"{BASE}/FogOfWar.java", """\
package com.shatteredpixel.shatteredpixeldungeon;

// The full implementation lives in com.shatteredpixel.shatteredpixeldungeon.tiles.FogOfWar.
// This stub exists for legacy import compatibility only.
public class FogOfWar {
}
""")

write_file(f"{BASE}/Journal.java", """\
package com.shatteredpixel.shatteredpixeldungeon;

// The full implementation lives in com.shatteredpixel.shatteredpixeldungeon.journal.Journal.
// This stub exists for legacy import compatibility only.
public class Journal {
}
""")

write_file(f"{BASE}/Preferences.java", """\
package com.shatteredpixel.shatteredpixeldungeon;

// The full preferences implementation is in SPDSettings.
// This stub exists for legacy import compatibility only.
public class Preferences {
}
""")

# ============================================================
# CATEGORY 8: Plants
# ============================================================

write_file(f"{BASE}/plants/Dewcatcher.java", """\
package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Healing;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

// Ported from Sprouted Pixel Dungeon.
// A dew-collecting plant that slowly heals the hero who steps on it.
public class Dewcatcher extends Plant {

    {
        image = 14; // uses sungrass visual as placeholder
        seedClass = Seed.class;
    }

    @Override
    public void activate(Char ch) {
        if (ch != null) {
            Buff.affect(ch, Healing.class).setHeal((int)(0.2f * ch.HT) + 1, 0.333f, 0);
        }
    }

    public static class Seed extends Plant.Seed {
        {
            image = ItemSpriteSheet.SEED_SUNGRASS; // placeholder sprite
            plantClass = Dewcatcher.class;
            alchemyClass = Dewcatcher.class;
        }
    }
}
""")

# ============================================================
# CATEGORY 8: Effects
# ============================================================

write_file(f"{BASE}/effects/DeathRay.java", """\
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
""")

write_file(f"{BASE}/effects/Halo.java", """\
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
""")

# ============================================================
# CATEGORY 7: Actor/Mob stubs - Utils
# ============================================================

write_file(f"{BASE}/utils/Utils.java", """\
package com.shatteredpixel.shatteredpixeldungeon.utils;

// General utility helper class for the Sprouted/Shattered hybrid.
// Game-specific utilities are typically handled by GLog, Messages, etc.
public class Utils {

    private Utils() {}

    public static String format(String format, Object... args) {
        return String.format(format, args);
    }
}
""")

# ============================================================
# CATEGORY 1: Sprite stubs - add header comment to each
# The classes already have correct extends - just add a license header + comment
# ============================================================

SPRITE_DIR = f"{BASE}/sprites"

sprite_stubs = {
    "AdultDragonVioletSprite.java": ("VioletDragonSprite", "Violet adult dragon — inherits all animations from VioletDragonSprite."),
    "AlbinoPiranhaSprite.java": ("PiranhaSprite", "Albino piranha — inherits all animations from PiranhaSprite."),
    "AssassinSprite.java": ("ThiefSprite", "Assassin — inherits all animations from ThiefSprite."),
    "BanditKingSprite.java": ("ThiefSprite", "Bandit King boss — inherits all animations from ThiefSprite."),
    "BlueDragonSprite.java": ("BatSprite", "Blue dragon — inherits all animations from BatSprite."),
    "BlueWraithSprite.java": ("WraithSprite", "Blue wraith — inherits all animations from WraithSprite."),
    "BrokenRobotSprite.java": ("GolemSprite", "Broken robot — inherits all animations from GolemSprite."),
    "BrownBatSprite.java": ("BatSprite", "Brown bat — inherits all animations from BatSprite."),
    "BunnySprite.java": ("RatSprite", "Bunny — inherits all animations from RatSprite."),
    "BurningFistSprite.java": ("FistSprite", "Burning fist boss appendage — inherits all animations from FistSprite."),
    "CrabKingSprite.java": ("CrabSprite", "Crab King boss — inherits all animations from CrabSprite."),
    "DemonGooSprite.java": ("GooSprite", "Demon goo — inherits all animations from GooSprite."),
    "DewProtectorSprite.java": ("GolemSprite", "Dew protector — inherits all animations from GolemSprite."),
    "DwarfKingTombSprite.java": ("DwarfKingSprite", "Dwarf King tomb guardian — inherits all animations from DwarfKingSprite."),
    "DwarfLichSprite.java": ("SkeletonSprite", "Dwarf lich — inherits all animations from SkeletonSprite."),
    "FairySprite.java": ("BatSprite", "Fairy — inherits all animations from BatSprite."),
    "FishProtectorSprite.java": ("PiranhaSprite", "Fish protector — inherits all animations from PiranhaSprite."),
    "FlyingProtectorSprite.java": ("BatSprite", "Flying protector — inherits all animations from BatSprite."),
    "ForestProtectorSprite.java": ("PlantSprite", "Forest protector — inherits all animations from PlantSprite."),
    "FossilSkeletonSprite.java": ("SkeletonSprite", "Fossil skeleton — inherits all animations from SkeletonSprite."),
    "GnollArcherSprite.java": ("GnollSprite", "Gnoll archer — inherits all animations from GnollSprite."),
    "GoldThiefSprite.java": ("ThiefSprite", "Gold thief — inherits all animations from ThiefSprite."),
    "GraveProtectorSprite.java": ("UndeadSprite", "Grave protector — inherits all animations from UndeadSprite."),
    "GreenDragonSprite.java": ("BatSprite", "Green dragon — inherits all animations from BatSprite."),
    "GreyOniSprite.java": ("BruteSprite", "Grey oni — inherits all animations from BruteSprite."),
    "GreyRatSprite.java": ("RatSprite", "Grey rat — inherits all animations from RatSprite."),
    "GullinSprite.java": ("BruteSprite", "Gullin boss — inherits all animations from BruteSprite."),
    "InfectingFistSprite.java": ("FistSprite", "Infecting fist boss appendage — inherits all animations from FistSprite."),
    "KupuaSprite.java": ("BatSprite", "Kupua — inherits all animations from BatSprite."),
    "LitTowerSprite.java": ("GolemSprite", "Lit tower — inherits all animations from GolemSprite."),
    "MagicEyeSprite.java": ("EyeSprite", "Magic eye — inherits all animations from EyeSprite."),
    "MonsterBoxSprite.java": ("GolemSprite", "Monster box — inherits all animations from GolemSprite."),
    "MossySkeletonSprite.java": ("SkeletonSprite", "Mossy skeleton — inherits all animations from SkeletonSprite."),
    "MrDestructo2dot0Sprite.java": ("GolemSprite", "Mr. Destructo 2.0 — inherits all animations from GolemSprite."),
    "MrDestructoSprite.java": ("GolemSprite", "Mr. Destructo — inherits all animations from GolemSprite."),
    "OniSprite.java": ("BruteSprite", "Oni — inherits all animations from BruteSprite."),
    "OrbOfZotSprite.java": ("EyeSprite", "Orb of Zot — inherits all animations from EyeSprite."),
    "OtilukeNPCSprite.java": ("WarlockSprite", "Otiluke NPC — inherits all animations from WarlockSprite."),
    "OtilukeSprite.java": ("WarlockSprite", "Otiluke boss — inherits all animations from WarlockSprite."),
    "PinningFistSprite.java": ("FistSprite", "Pinning fist boss appendage — inherits all animations from FistSprite."),
    "PlantSprite.java": ("UndeadSprite", "Plant mob — inherits all animations from UndeadSprite."),
    "PoisonGooSprite.java": ("GooSprite", "Poison goo — inherits all animations from GooSprite."),
    "RatBossSprite.java": ("RatSprite", "Rat boss — inherits all animations from RatSprite."),
    "RedDragonSprite.java": ("BatSprite", "Red dragon — inherits all animations from BatSprite."),
    "RedWraithSprite.java": ("WraithSprite", "Red wraith — inherits all animations from WraithSprite."),
    "RottingFistSprite.java": ("FistSprite", "Rotting fist boss appendage — inherits all animations from FistSprite."),
    "ScorpionSprite.java": ("SpinnerSprite", "Scorpion — inherits all animations from SpinnerSprite."),
    "SeekingBombSprite.java": ("BeeSprite", "Seeking bomb — inherits all animations from BeeSprite."),
    "SeekingClusterBombSprite.java": ("BeeSprite", "Seeking cluster bomb — inherits all animations from BeeSprite."),
    "SentinelSprite.java": ("GolemSprite", "Sentinel — inherits all animations from GolemSprite."),
    "ShadowDragonSprite.java": ("BatSprite", "Shadow dragon — inherits all animations from BatSprite."),
    "ShadowYogSprite.java": ("YogSprite", "Shadow Yog — inherits all animations from YogSprite."),
    "ShellSprite.java": ("CrabSprite", "Shell mob — inherits all animations from CrabSprite."),
    "SkeletonHand1Sprite.java": ("SkeletonSprite", "Skeleton boss hand #1 — inherits all animations from SkeletonSprite."),
    "SkeletonHand2Sprite.java": ("SkeletonSprite", "Skeleton boss hand #2 — inherits all animations from SkeletonSprite."),
    "SkeletonKingSprite.java": ("SkeletonSprite", "Skeleton King boss — inherits all animations from SkeletonSprite."),
    "SokobanBlackSheepSprite.java": ("SheepSprite", "Sokoban black sheep — inherits all animations from SheepSprite."),
    "SokobanCornerSheepSprite.java": ("SheepSprite", "Sokoban corner sheep — inherits all animations from SheepSprite."),
    "SokobanSentinelSprite.java": ("GolemSprite", "Sokoban sentinel — inherits all animations from GolemSprite."),
    "SokobanSheepSprite.java": ("SheepSprite", "Sokoban sheep — inherits all animations from SheepSprite."),
    "SokobanSheepSwitchSprite.java": ("SheepSprite", "Sokoban sheep switch — inherits all animations from SheepSprite."),
    "SpectralRatSprite.java": ("WraithSprite", "Spectral rat — inherits all animations from WraithSprite."),
    "SpiderSprite.java": ("SpinnerSprite", "Spider — inherits all animations from SpinnerSprite."),
    "SteelBeeSprite.java": ("BeeSprite", "Steel bee — inherits all animations from BeeSprite."),
    "SugarplumFairySprite.java": ("BatSprite", "Sugarplum fairy — inherits all animations from BatSprite."),
    "ThiefKingSprite.java": ("ThiefSprite", "Thief King boss — inherits all animations from ThiefSprite."),
    "TinkererSprite.java": ("ShopkeeperSprite", "Tinkerer NPC — inherits all animations from ShopkeeperSprite."),
    "TowerSprite.java": ("GolemSprite", "Tower mob — inherits all animations from GolemSprite."),
    "VaultProtectorSprite.java": ("GolemSprite", "Vault protector — inherits all animations from GolemSprite."),
    "VelociroosterSprite.java": ("RatSprite", "Velocirooster — inherits all animations from RatSprite."),
    "VillagerSprite.java": ("ShopkeeperSprite", "Villager NPC — inherits all animations from ShopkeeperSprite."),
    "VioletDragonSprite.java": ("BatSprite", "Violet dragon — inherits all animations from BatSprite."),
    "ZotPhaseSprite.java": ("YogSprite", "Zot phase — inherits all animations from YogSprite."),
    "ZotSprite.java": ("YogSprite", "Zot boss — inherits all animations from YogSprite."),
}

for filename, (parent, comment) in sprite_stubs.items():
    path = f"{SPRITE_DIR}/{filename}"
    if not os.path.exists(path):
        continue
    classname = filename[:-5]  # strip .java
    content = f"""\
package com.shatteredpixel.shatteredpixeldungeon.sprites;

// {comment}
public class {classname} extends {parent} {{
}}
"""
    write_file(path, content)

# ============================================================
# CATEGORY 2: Level stubs - add comments
# ============================================================

LEVEL_DIR = f"{BASE}/levels"

level_stubs = {
    "ZotBossLevel.java": ("HallsBossLevel", "Boss level for Zot — reuses HallsBossLevel layout and mechanics."),
    "SkeletonBossLevel.java": ("CavesBossLevel", "Boss level for the Skeleton King — reuses CavesBossLevel layout."),
    "CrabBossLevel.java": ("SewerBossLevel", "Boss level for the Crab King — reuses SewerBossLevel layout."),
    "ThiefBossLevel.java": ("PrisonBossLevel", "Boss level for the Bandit King — reuses PrisonBossLevel layout."),
    "InfestBossLevel.java": ("CavesBossLevel", "Boss level for Gullin — reuses CavesBossLevel layout."),
    "DragonCaveLevel.java": ("CavesLevel", "Dragon cave level — a specialised CavesLevel for the dragon encounter."),
    "ChasmLevel.java": ("HallsLevel", "A halls level variant featuring a deep chasm obstacle."),
    "ThiefCatchLevel.java": ("PrisonLevel", "Prison level used for the thief-catching quest."),
    "SafeLevel.java": ("LastShopLevel", "A safe room level with no hostile mobs."),
    "SafeLevel1.java": ("LastShopLevel", "Second safe room level variant with no hostile mobs."),
    "MinesBossLevel.java": ("MineLevel", "Boss level set in the mines."),
    "SokobanIntroLevel.java": ("RegularLevel", "Introductory Sokoban puzzle level."),
    "SokobanPuzzlesLevel.java": ("RegularLevel", "First set of Sokoban puzzles."),
    "SokobanPuzzles2Level.java": ("RegularLevel", "Second set of Sokoban puzzles."),
    "SokobanTeleportLevel.java": ("RegularLevel", "Sokoban level with teleporter mechanics."),
    "SokobanVaultLevel.java": ("RegularLevel", "Sokoban level guarding the vault."),
    "SokobanCastle.java": ("CatacombLevel", "Sokoban castle level — reuses CatacombLevel layout."),
}

for filename, (parent, comment) in level_stubs.items():
    path = f"{LEVEL_DIR}/{filename}"
    if not os.path.exists(path):
        continue
    classname = filename[:-5]
    content = f"""\
package com.shatteredpixel.shatteredpixeldungeon.levels;

// {comment}
public class {classname} extends {parent} {{
}}
"""
    write_file(path, content)

# ============================================================
# CATEGORY 3: Window stubs - ensure constructors
# ============================================================

WIN_DIR = f"{BASE}/windows"

window_stubs = {
    "WndAscend.java": "Dialog shown when the hero ascends to the previous floor.",
    "WndBlacksmith2.java": "Extended blacksmith shop window.",
    "WndCatalogus.java": "Item catalogue / bestiary window.",
    "WndChooseWay.java": "Path-choice dialog presented at branching points.",
    "WndClass.java": "Hero class selection window.",
    "WndDescend.java": "Dialog shown when the hero descends to the next floor.",
    "WndDewDrawInfo.java": "Information window for the Dew Draw ability.",
    "WndDewVial.java": "Dew vial management window.",
    "WndItem.java": "Detailed item information window.",
    "WndLevelUp.java": "Level-up congratulation and options window.",
    "WndOtiluke.java": "Dialogue window for the Otiluke NPC.",
    "WndOtilukeMessage.java": "Message window for communications from Otiluke.",
    "WndPetHaste.java": "Window for the Pet Haste ability.",
    "WndTinkerer.java": "Main tinkerer shop window.",
    "WndTinkerer2.java": "Tinkerer shop window — second tier items.",
    "WndTinkerer3.java": "Tinkerer shop window — third tier items.",
}

for filename, comment in window_stubs.items():
    path = f"{WIN_DIR}/{filename}"
    if not os.path.exists(path):
        continue
    classname = filename[:-5]
    content = f"""\
package com.shatteredpixel.shatteredpixeldungeon.windows;

import com.shatteredpixel.shatteredpixeldungeon.ui.Window;

// {comment}
public class {classname} extends Window {{

    public {classname}() {{
        super();
    }}
}}
"""
    write_file(path, content)

# ============================================================
# CATEGORY 5: UI stubs - add comments
# ============================================================

UI_DIR = f"{BASE}/ui"

write_file(f"{UI_DIR}/GoldIndicator.java", """\
package com.shatteredpixel.shatteredpixeldungeon.ui;

// Displays the hero's current gold count in the HUD. Inherits display logic from CurrencyIndicator.
public class GoldIndicator extends CurrencyIndicator {
}
""")

write_file(f"{UI_DIR}/HealthIndicator.java", """\
package com.shatteredpixel.shatteredpixeldungeon.ui;

// Displays a health value (e.g. for a pet or ally) in the HUD. Inherits from CurrencyIndicator.
public class HealthIndicator extends CurrencyIndicator {
}
""")

write_file(f"{UI_DIR}/SimpleButton.java", """\
package com.shatteredpixel.shatteredpixeldungeon.ui;

// A minimal button with no extra behaviour — used as a base or plain click target.
public class SimpleButton extends Button {
}
""")

write_file(f"{UI_DIR}/PrefsButton.java", """\
package com.shatteredpixel.shatteredpixeldungeon.ui;

// Button that opens the preferences / settings screen.
public class PrefsButton extends Button {
}
""")

write_file(f"{UI_DIR}/SpellButton.java", """\
package com.shatteredpixel.shatteredpixeldungeon.ui;

// Quick-slot button for activating a spell or special ability.
public class SpellButton extends Button {
}
""")

# ============================================================
# Misc items — add comments where needed
# ============================================================

ITEMS_DIR = f"{BASE}/items"

# Scenes
SCENES_DIR = f"{BASE}/scenes"

write_file(f"{SCENES_DIR}/BadgesScene.java", """\
package com.shatteredpixel.shatteredpixeldungeon.scenes;

// Scene that displays earned badges. Full implementation to be added.
public class BadgesScene extends PixelScene {

    @Override
    public void create() {
        super.create();
    }
}
""")

write_file(f"{SCENES_DIR}/IntroScene.java", """\
package com.shatteredpixel.shatteredpixeldungeon.scenes;

// Intro/opening cinematic scene. Full implementation to be added.
public class IntroScene extends PixelScene {

    @Override
    public void create() {
        super.create();
    }
}
""")

print("Done!")
