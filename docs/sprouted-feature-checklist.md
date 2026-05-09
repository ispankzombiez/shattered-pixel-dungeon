# Sprouted Feature Checklist (vs Shattered)

This checklist is generated from source comparison between:
- `dachhack/SproutedPixelDungeon-Gradle` (Sprouted reference)
- `ispankzombiez/shattered-pixel-dungeon` (current repo)

This checklist primarily tracks **path-level parity** (whether matching class paths exist).
Use the core backlog below to track **behavior-level parity** work for follow-up updates.

## core map generation parity backlog (behavior, not just class paths)

- [ ] Implement `levels/Layouts.java` with Sprouted-style layout definitions and selection logic.
- [ ] Implement `levels/MazeLayout.java` maze generation logic (carving, connectivity, and constraints).
- [ ] Implement `levels/Room.java` as Sprouted map-generation room data (not an empty placeholder).
- [ ] Wire Sprouted map-generation flow into level creation (generation pipeline integration, not just class presence).
- [ ] Integrate Sprouted depth/branch routing for generated special maps into `Dungeon.newLevel()` selection.
- [ ] Replace empty Sprouted generation-adjacent level shells with functional generation logic:
  - [ ] `levels/BattleLevel.java`
  - [ ] `levels/CatacombLevel.java`
  - [ ] `levels/FieldLevel.java`
  - [ ] `levels/FortressLevel.java`
  - [ ] `levels/MineLevel.java`
  - [ ] `levels/TownLevel.java`
  - [ ] `levels/TownLayouts.java`
  - [ ] `levels/TenguDenLevel.java`
  - [ ] `levels/TenguHideoutLevel.java`
  - [ ] `levels/SokobanLayouts.java`
  - [ ] `levels/SokobanLayouts2.java`

## actors → animate

- [x] `actors/animate/WeaponAnimate.java`

## actors → blobs

- [x] `actors/blobs/Alter.java`
- [x] `actors/blobs/CorruptGas.java`
- [x] `actors/blobs/Portal.java`
- [x] `actors/blobs/Water.java`
- [x] `actors/blobs/WaterOfTransmutation.java`
- [x] `actors/blobs/WaterOfUpgradeEating.java`

## actors → buffs

- [x] `actors/buffs/BerryRegeneration.java`
- [x] `actors/buffs/CountDown.java`
- [x] `actors/buffs/Dewcharge.java`
- [x] `actors/buffs/DrowsySpell.java`
- [x] `actors/buffs/EarthImbue.java`
- [x] `actors/buffs/FullMoonStrength.java`
- [x] `actors/buffs/GasesImmunity.java`
- [x] `actors/buffs/LichenDrop.java`
- [x] `actors/buffs/LokisPoison.java`
- [x] `actors/buffs/MagicImmunity.java`
- [x] `actors/buffs/MagicSurge.java`
- [x] `actors/buffs/ManaRegen.java`
- [x] `actors/buffs/Shield.java`
- [x] `actors/buffs/Strength.java`

## actors → mobs

- [x] `actors/mobs/AdultDragonViolet.java`
- [x] `actors/mobs/AlbinoPiranha.java`
- [x] `actors/mobs/Assassin.java`
- [x] `actors/mobs/BanditKing.java`
- [x] `actors/mobs/Bestiary.java`
- [x] `actors/mobs/BlueCat.java`
- [x] `actors/mobs/BlueWraith.java`
- [x] `actors/mobs/BrokenRobot.java`
- [x] `actors/mobs/BrownBat.java`
- [x] `actors/mobs/ControlPanel.java`
- [x] `actors/mobs/CrabKing.java`
- [x] `actors/mobs/DemonGoo.java`
- [x] `actors/mobs/DwarfKingTomb.java`
- [x] `actors/mobs/DwarfLich.java`
- [x] `actors/mobs/FishProtector.java`
- [x] `actors/mobs/FlyingProtector.java`
- [x] `actors/mobs/ForestProtector.java`
- [x] `actors/mobs/FossilSkeleton.java`
- [x] `actors/mobs/GoldThief.java`
- [x] `actors/mobs/GraveProtector.java`
- [x] `actors/mobs/GreyOni.java`
- [x] `actors/mobs/GreyRat.java`
- [x] `actors/mobs/Gullin.java`
- [x] `actors/mobs/King.java`
- [x] `actors/mobs/Kupua.java`
- [x] `actors/mobs/Lichen.java`
- [x] `actors/mobs/LitTower.java`
- [x] `actors/mobs/MagicEye.java`
- [x] `actors/mobs/MineSentinel.java`
- [x] `actors/mobs/MonsterBox.java`
- [x] `actors/mobs/MossySkeleton.java`
- [x] `actors/mobs/MrDestructo.java`
- [x] `actors/mobs/MrDestructo2dot0.java`
- [x] `actors/mobs/Oni.java`
- [x] `actors/mobs/OrbOfZotMob.java`
- [x] `actors/mobs/Otiluke.java`
- [x] `actors/mobs/PoisonGoo.java`
- [x] `actors/mobs/RatBoss.java`
- [x] `actors/mobs/RedWraith.java`
- [x] `actors/mobs/SeekingBomb.java`
- [x] `actors/mobs/SeekingClusterBomb.java`
- [x] `actors/mobs/Sentinel.java`
- [x] `actors/mobs/ShadowYog.java`
- [x] `actors/mobs/Shell.java`
- [x] `actors/mobs/Shielded.java`
- [x] `actors/mobs/SkeletonHand1.java`
- [x] `actors/mobs/SkeletonHand2.java`
- [x] `actors/mobs/SkeletonKing.java`
- [x] `actors/mobs/SokobanSentinel.java`
- [x] `actors/mobs/SpectralRat.java`
- [x] `actors/mobs/SteelBee.java`
- [x] `actors/mobs/TenguDen.java`
- [x] `actors/mobs/TenguEscape.java`
- [x] `actors/mobs/ThiefKing.java`
- [x] `actors/mobs/Tower.java`
- [x] `actors/mobs/VaultProtector.java`
- [x] `actors/mobs/Yog.java`
- [x] `actors/mobs/Zot.java`
- [x] `actors/mobs/ZotPhase.java`
- [x] `actors/mobs/npcs/Blacksmith2.java`
- [x] `actors/mobs/npcs/Guard.java`
- [x] `actors/mobs/npcs/OtilukeNPC.java`
- [x] `actors/mobs/npcs/RatKingDen.java`
- [x] `actors/mobs/npcs/SeekingBombNPC.java`
- [x] `actors/mobs/npcs/SeekingClusterBombNPC.java`
- [x] `actors/mobs/npcs/SheepSokoban.java`
- [x] `actors/mobs/npcs/SheepSokobanBlack.java`
- [x] `actors/mobs/npcs/SheepSokobanCorner.java`
- [x] `actors/mobs/npcs/SheepSokobanStop.java`
- [x] `actors/mobs/npcs/SheepSokobanSwitch.java`
- [x] `actors/mobs/npcs/Tinkerer1.java`
- [x] `actors/mobs/npcs/Tinkerer2.java`
- [x] `actors/mobs/npcs/Tinkerer3.java`
- [x] `actors/mobs/npcs/Tinkerer4.java`
- [x] `actors/mobs/npcs/Tinkerer5.java`
- [x] `actors/mobs/pets/BlueDragon.java`
- [x] `actors/mobs/pets/Bunny.java`
- [x] `actors/mobs/pets/Fairy.java`
- [x] `actors/mobs/pets/GreenDragon.java`
- [x] `actors/mobs/pets/PET.java`
- [x] `actors/mobs/pets/RedDragon.java`
- [x] `actors/mobs/pets/Scorpion.java`
- [x] `actors/mobs/pets/ShadowDragon.java`
- [x] `actors/mobs/pets/Spider.java`
- [x] `actors/mobs/pets/SugarplumFairy.java`
- [x] `actors/mobs/pets/Velocirooster.java`
- [x] `actors/mobs/pets/VioletDragon.java`
- [x] `actors/mobs/pets/bee.java`

## core-systems

- [x] `DungeonTilemap.java`
- [x] `FogOfWar.java`
- [x] `Journal.java`
- [x] `Preferences.java`
- [x] `ResultDescriptions.java`

## effects

- [x] `effects/DeathRay.java`
- [x] `effects/Halo.java`
- [x] `effects/LightningLarge.java`

## items → Ammo

- [x] `items/Ammo/Ammo.java`
- [x] `items/Ammo/Arrow.java`
- [x] `items/Ammo/SilverArrow.java`

## items

- [x] `items/ActiveMrDestructo.java`
- [x] `items/ActiveMrDestructo2.java`
- [x] `items/AdamantArmor.java`
- [x] `items/AdamantRing.java`
- [x] `items/AdamantWand.java`
- [x] `items/AdamantWeapon.java`
- [x] `items/AncientCoin.java`
- [x] `items/ArmorKit.java`
- [x] `items/Bomb.java`
- [x] `items/Bone.java`
- [x] `items/BookOfDead.java`
- [x] `items/BookOfLife.java`
- [x] `items/BookOfTranscendence.java`
- [x] `items/CavesKey.java`
- [x] `items/CityKey.java`
- [x] `items/ClusterBomb.java`
- [x] `items/ConchShell.java`
- [x] `items/DewVial.java`
- [x] `items/DewVial2.java`
- [x] `items/DizzyBomb.java`
- [x] `items/DumplingBomb.java`
- [x] `items/DwarfHammer.java`
- [x] `items/EasterEgg.java`
- [x] `items/FishingBomb.java`
- [x] `items/GreaterStylus.java`
- [x] `items/HallsKey.java`
- [x] `items/HolyHandGrenade.java`
- [x] `items/InactiveMrDestructo.java`
- [x] `items/InactiveMrDestructo2.java`
- [x] `items/LevelDewdrop.java`
- [x] `items/LloydsBeacon.java`
- [x] `items/Mushroom.java`
- [x] `items/OrbOfZot.java`
- [x] `items/OtilukesJournal.java`
- [x] `items/Palantir.java`
- [x] `items/PrisonKey.java`
- [x] `items/PuddingCup.java`
- [x] `items/ReturnBeacon.java`
- [x] `items/Rice.java`
- [x] `items/SanChikarah.java`
- [x] `items/SanChikarahDeath.java`
- [x] `items/SanChikarahLife.java`
- [x] `items/SanChikarahTranscend.java`
- [x] `items/SeekingBombItem.java`
- [x] `items/SeekingClusterBombItem.java`
- [x] `items/SewersKey.java`
- [x] `items/ShadowDragonEgg.java`
- [x] `items/SmartBomb.java`
- [x] `items/Spellbook.java`
- [x] `items/Spellbook_old.java`
- [x] `items/SteelHoneypot.java`
- [x] `items/StoneOre.java`
- [x] `items/TenguKey.java`
- [x] `items/TomeOfMastery.java`
- [x] `items/TownReturnBeacon.java`
- [x] `items/Weightstone.java`
- [x] `items/Whistle.java`

## items → armor

- [x] `items/armor/MetalUnderwear.java`
- [x] `items/armor/glyphs/AntiEntropy.java`
- [x] `items/armor/glyphs/Bounce.java`
- [x] `items/armor/glyphs/Displacement.java`
- [x] `items/armor/glyphs/Metabolism.java`
- [x] `items/armor/glyphs/Multiplicity.java`
- [x] `items/armor/glyphs/Stench.java`

## items → artifacts

- [x] `items/artifacts/RingOfDisintegration.java`
- [x] `items/artifacts/RingOfFrost.java`

## items → bags

- [x] `items/bags/AnkhChain.java`
- [x] `items/bags/KeyRing.java`
- [x] `items/bags/Quiver.java`
- [x] `items/bags/SeedPouch.java`
- [x] `items/bags/SpellBook.java`
- [x] `items/bags/WandHolster.java`

## items → food

- [x] `items/food/Blackberry.java`
- [x] `items/food/BlueMilk.java`
- [x] `items/food/Blueberry.java`
- [x] `items/food/Cloudberry.java`
- [x] `items/food/DeathCap.java`
- [x] `items/food/Earthstar.java`
- [x] `items/food/FullMoonberry.java`
- [x] `items/food/GoldenJelly.java`
- [x] `items/food/GoldenNut.java`
- [x] `items/food/JackOLantern.java`
- [x] `items/food/Meat.java`
- [x] `items/food/Moonberry.java`
- [x] `items/food/Nut.java`
- [x] `items/food/OverpricedRation.java`
- [x] `items/food/PixieParasol.java`
- [x] `items/food/PotionOfConstitution.java`
- [x] `items/food/ToastedNut.java`

## items → journalpages

- [x] `items/journalpages/DragonCave.java`
- [x] `items/journalpages/JournalPage.java`
- [x] `items/journalpages/SafeSpotPage.java`
- [x] `items/journalpages/Sokoban1.java`
- [x] `items/journalpages/Sokoban2.java`
- [x] `items/journalpages/Sokoban3.java`
- [x] `items/journalpages/Sokoban4.java`
- [x] `items/journalpages/Town.java`
- [x] `items/journalpages/Vault.java`

## items → keys

- [x] `items/keys/GoldenSkeletonKey.java`
- [x] `items/keys/SkeletonKey.java`

## items → misc

- [x] `items/misc/AutoPotion.java`
- [x] `items/misc/MiscEquippable.java`
- [x] `items/misc/Spectacles.java`

## items → nornstone

- [x] `items/nornstone/BlueNornStone.java`
- [x] `items/nornstone/GreenNornStone.java`
- [x] `items/nornstone/NornStone.java`
- [x] `items/nornstone/OrangeNornStone.java`
- [x] `items/nornstone/PurpleNornStone.java`
- [x] `items/nornstone/YellowNornStone.java`

## items → potions

- [x] `items/potions/PotionOfMana.java`
- [x] `items/potions/PotionOfMending.java`
- [x] `items/potions/PotionOfMight.java`
- [x] `items/potions/PotionOfOverHealing.java`

## items → quest

- [x] `items/quest/RatSkull.java`

## items → rings

- [x] `items/rings/RingOfMagic.java`

## items → scrolls

- [x] `items/scrolls/ScrollOfMagicalInfusion.java`
- [x] `items/scrolls/ScrollOfMultiUpgrade.java`
- [x] `items/scrolls/ScrollOfPsionicBlast.java`
- [x] `items/scrolls/ScrollOfRegrowth.java`

## items → spells

- [x] `items/spells/SpellOfAmok.java`
- [x] `items/spells/SpellOfAmok2.java`
- [x] `items/spells/SpellOfArmor.java`
- [x] `items/spells/SpellOfBlink.java`
- [x] `items/spells/SpellOfCharm.java`
- [x] `items/spells/SpellOfCountdown.java`
- [x] `items/spells/SpellOfDeath.java`
- [x] `items/spells/SpellOfDewDraw.java`
- [x] `items/spells/SpellOfDispel.java`
- [x] `items/spells/SpellOfFireblast.java`
- [x] `items/spells/SpellOfFirebolt.java`
- [x] `items/spells/SpellOfFirestorm.java`
- [x] `items/spells/SpellOfFright.java`
- [x] `items/spells/SpellOfGasImmunity.java`
- [x] `items/spells/SpellOfHaste.java`
- [x] `items/spells/SpellOfIceblast.java`
- [x] `items/spells/SpellOfIcebolt.java`
- [x] `items/spells/SpellOfIcestorm.java`
- [x] `items/spells/SpellOfInvisibility.java`
- [x] `items/spells/SpellOfLevitation.java`
- [x] `items/spells/SpellOfLight.java`
- [x] `items/spells/SpellOfLightningblast.java`
- [x] `items/spells/SpellOfLightningbolt.java`
- [x] `items/spells/SpellOfLightningstorm.java`
- [x] `items/spells/SpellOfMagicMissile.java`
- [x] `items/spells/SpellOfMoonFury.java`
- [x] `items/spells/SpellOfPoison.java`
- [x] `items/spells/SpellOfRecharge.java`
- [x] `items/spells/SpellOfRegen.java`
- [x] `items/spells/SpellOfRoot.java`
- [x] `items/spells/SpellOfSleep.java`
- [x] `items/spells/SpellOfSlowing.java`

## items → wands

- [x] `items/wands/WandOfAmok.java`
- [x] `items/wands/WandOfAvalanche.java`
- [x] `items/wands/WandOfBlink.java`
- [x] `items/wands/WandOfDisintegration2.java`
- [x] `items/wands/WandOfFirebolt.java`
- [x] `items/wands/WandOfFlock.java`
- [x] `items/wands/WandOfPoison.java`
- [x] `items/wands/WandOfSlowness.java`
- [x] `items/wands/WandOfTelekinesis.java`
- [x] `items/wands/WandOfTeleportation.java`

## items → weapon

- [x] `items/weapon/enchantments/AresLeech.java`
- [x] `items/weapon/enchantments/BuzzSaw.java`
- [x] `items/weapon/enchantments/CromLuck.java`
- [x] `items/weapon/enchantments/Death.java`
- [x] `items/weapon/enchantments/Fire.java`
- [x] `items/weapon/enchantments/Horror.java`
- [x] `items/weapon/enchantments/Instability.java`
- [x] `items/weapon/enchantments/JupitersHorror.java`
- [x] `items/weapon/enchantments/Leech.java`
- [x] `items/weapon/enchantments/LokisPoison.java`
- [x] `items/weapon/enchantments/Luck.java`
- [x] `items/weapon/enchantments/NeptuneShock.java`
- [x] `items/weapon/enchantments/Nomnom.java`
- [x] `items/weapon/enchantments/Osmose.java`
- [x] `items/weapon/enchantments/Paralysis.java`
- [x] `items/weapon/enchantments/Poison.java`
- [x] `items/weapon/enchantments/Shock.java`
- [x] `items/weapon/enchantments/Slashing.java`
- [x] `items/weapon/enchantments/Slow.java`
- [x] `items/weapon/melee/AssassinsKnife.java`
- [x] `items/weapon/melee/Axe.java`
- [x] `items/weapon/melee/BroadSword.java`
- [x] `items/weapon/melee/Chainsaw.java`
- [x] `items/weapon/melee/GreatSword.java`
- [x] `items/weapon/melee/Knuckles.java`
- [x] `items/weapon/melee/MageStaff.java`
- [x] `items/weapon/melee/RoyalSpork.java`
- [x] `items/weapon/melee/ShortSword.java`
- [x] `items/weapon/melee/Spork.java`
- [x] `items/weapon/melee/relic/AresSword.java`
- [x] `items/weapon/melee/relic/CromCruachAxe.java`
- [x] `items/weapon/melee/relic/LokisFlail.java`
- [x] `items/weapon/melee/relic/NeptunusTrident.java`
- [x] `items/weapon/melee/relic/RelicMeleeWeapon.java`
- [x] `items/weapon/missiles/Boomerang.java`
- [x] `items/weapon/missiles/CurareDart.java`
- [x] `items/weapon/missiles/CurareShuriken.java`
- [x] `items/weapon/missiles/Dart.java`
- [x] `items/weapon/missiles/ForestDart.java`
- [x] `items/weapon/missiles/IncendiaryDart.java`
- [x] `items/weapon/missiles/IncendiaryShuriken.java`
- [x] `items/weapon/missiles/JupitersWraith.java`
- [x] `items/weapon/missiles/RiceBall.java`
- [x] `items/weapon/missiles/Skull.java`
- [x] `items/weapon/missiles/Tamahawk.java`
- [x] `items/weapon/missiles/Wave.java`
- [x] `items/weapon/ranged/Bow.java`
- [x] `items/weapon/ranged/RangedWeapon.java`

## levels

- [x] `levels/BattleLevel.java`
- [x] `levels/CatacombLevel.java`
- [x] `levels/ChasmLevel.java`
- [x] `levels/CrabBossLevel.java`
- [x] `levels/DragonCaveLevel.java`
- [x] `levels/FieldLevel.java`
- [x] `levels/FishingLevel.java`
- [x] `levels/FortressLevel.java`
- [x] `levels/InfestBossLevel.java`
- [x] `levels/Layouts.java`
- [x] `levels/MazeLayout.java`
- [x] `levels/MineLevel.java`
- [x] `levels/MinesBossLevel.java`
- [x] `levels/Room.java`
- [x] `levels/SafeLevel.java`
- [x] `levels/SafeLevel1.java`
- [x] `levels/SkeletonBossLevel.java`
- [x] `levels/SokobanCastle.java`
- [x] `levels/SokobanIntroLevel.java`
- [x] `levels/SokobanLayouts.java`
- [x] `levels/SokobanLayouts2.java`
- [x] `levels/SokobanPuzzles2Level.java`
- [x] `levels/SokobanPuzzlesLevel.java`
- [x] `levels/SokobanTeleportLevel.java`
- [x] `levels/SokobanVaultLevel.java`
- [x] `levels/TenguDenLevel.java`
- [x] `levels/TenguHideoutLevel.java`
- [x] `levels/ThiefBossLevel.java`
- [x] `levels/ThiefCatchLevel.java`
- [x] `levels/TownLayouts.java`
- [x] `levels/TownLevel.java`
- [x] `levels/ZotBossLevel.java`

## levels → features

- [x] `levels/features/AlchemyPot.java`
- [x] `levels/features/Sign.java`

## levels → painters

- [x] `levels/painters/ArmoryPainter.java`
- [x] `levels/painters/BlacksmithPainter.java`
- [x] `levels/painters/BossExitPainter.java`
- [x] `levels/painters/CryptPainter.java`
- [x] `levels/painters/EntrancePainter.java`
- [x] `levels/painters/ExitPainter.java`
- [x] `levels/painters/GardenPainter.java`
- [x] `levels/painters/LaboratoryPainter.java`
- [x] `levels/painters/LibraryPainter.java`
- [x] `levels/painters/MagicWellPainter.java`
- [x] `levels/painters/PassagePainter.java`
- [x] `levels/painters/PitPainter.java`
- [x] `levels/painters/PoolPainter.java`
- [x] `levels/painters/RatKingPainter.java`
- [x] `levels/painters/RatKingPainter2.java`
- [x] `levels/painters/ShopPainter.java`
- [x] `levels/painters/StandardPainter.java`
- [x] `levels/painters/StatuePainter.java`
- [x] `levels/painters/StoragePainter.java`
- [x] `levels/painters/TrapsPainter.java`
- [x] `levels/painters/TreasuryPainter.java`
- [x] `levels/painters/TunnelPainter.java`
- [x] `levels/painters/VaultPainter.java`
- [x] `levels/painters/WeakFloorPainter.java`

## levels → traps

- [x] `levels/traps/ActivatePortalTrap.java`
- [x] `levels/traps/ChangeSheepTrap.java`
- [x] `levels/traps/FireTrap.java`
- [x] `levels/traps/FleecingTrap.java`
- [x] `levels/traps/HeapGenTrap.java`
- [x] `levels/traps/LightningTrap.java`
- [x] `levels/traps/ParalyticTrap.java`
- [x] `levels/traps/PoisonTrap.java`
- [x] `levels/traps/SokobanPortalTrap.java`

## plants

- [x] `plants/Dewcatcher.java`
- [x] `plants/Dreamfoil.java`
- [x] `plants/Flytrap.java`
- [x] `plants/Phaseshift.java`

## scenes

- [x] `scenes/BadgesScene.java`
- [x] `scenes/IntroScene.java`

## sprites

- [x] `sprites/AdultDragonVioletSprite.java`
- [x] `sprites/AlbinoPiranhaSprite.java`
- [x] `sprites/AssassinSprite.java`
- [x] `sprites/BanditKingSprite.java`
- [x] `sprites/BlueDragonSprite.java`
- [x] `sprites/BlueWraithSprite.java`
- [x] `sprites/BrokenRobotSprite.java`
- [x] `sprites/BrownBatSprite.java`
- [x] `sprites/BunnySprite.java`
- [x] `sprites/BurningFistSprite.java`
- [x] `sprites/CrabKingSprite.java`
- [x] `sprites/DemonGooSprite.java`
- [x] `sprites/DewProtectorSprite.java`
- [x] `sprites/DwarfKingTombSprite.java`
- [x] `sprites/DwarfLichSprite.java`
- [x] `sprites/FairySprite.java`
- [x] `sprites/FishProtectorSprite.java`
- [x] `sprites/FlyingProtectorSprite.java`
- [x] `sprites/ForestProtectorSprite.java`
- [x] `sprites/FossilSkeletonSprite.java`
- [x] `sprites/GnollArcherSprite.java`
- [x] `sprites/GoldThiefSprite.java`
- [x] `sprites/GraveProtectorSprite.java`
- [x] `sprites/GreenDragonSprite.java`
- [x] `sprites/GreyOniSprite.java`
- [x] `sprites/GreyRatSprite.java`
- [x] `sprites/GullinSprite.java`
- [x] `sprites/InfectingFistSprite.java`
- [x] `sprites/KupuaSprite.java`
- [x] `sprites/LitTowerSprite.java`
- [x] `sprites/MagicEyeSprite.java`
- [x] `sprites/MonsterBoxSprite.java`
- [x] `sprites/MossySkeletonSprite.java`
- [x] `sprites/MrDestructo2dot0Sprite.java`
- [x] `sprites/MrDestructoSprite.java`
- [x] `sprites/OniSprite.java`
- [x] `sprites/OrbOfZotSprite.java`
- [x] `sprites/OtilukeNPCSprite.java`
- [x] `sprites/OtilukeSprite.java`
- [x] `sprites/PinningFistSprite.java`
- [x] `sprites/PlantSprite.java`
- [x] `sprites/PoisonGooSprite.java`
- [x] `sprites/RatBossSprite.java`
- [x] `sprites/RedDragonSprite.java`
- [x] `sprites/RedWraithSprite.java`
- [x] `sprites/RottingFistSprite.java`
- [x] `sprites/ScorpionSprite.java`
- [x] `sprites/SeekingBombSprite.java`
- [x] `sprites/SeekingClusterBombSprite.java`
- [x] `sprites/SentinelSprite.java`
- [x] `sprites/ShadowDragonSprite.java`
- [x] `sprites/ShadowYogSprite.java`
- [x] `sprites/ShellSprite.java`
- [x] `sprites/SkeletonHand1Sprite.java`
- [x] `sprites/SkeletonHand2Sprite.java`
- [x] `sprites/SkeletonKingSprite.java`
- [x] `sprites/SokobanBlackSheepSprite.java`
- [x] `sprites/SokobanCornerSheepSprite.java`
- [x] `sprites/SokobanSentinelSprite.java`
- [x] `sprites/SokobanSheepSprite.java`
- [x] `sprites/SokobanSheepSwitchSprite.java`
- [x] `sprites/SpectralRatSprite.java`
- [x] `sprites/SpiderSprite.java`
- [x] `sprites/SteelBeeSprite.java`
- [x] `sprites/SugarplumFairySprite.java`
- [x] `sprites/ThiefKingSprite.java`
- [x] `sprites/TinkererSprite.java`
- [x] `sprites/TowerSprite.java`
- [x] `sprites/VaultProtectorSprite.java`
- [x] `sprites/VelociroosterSprite.java`
- [x] `sprites/VillagerSprite.java`
- [x] `sprites/VioletDragonSprite.java`
- [x] `sprites/ZotPhaseSprite.java`
- [x] `sprites/ZotSprite.java`

## ui

- [x] `ui/GoldIndicator.java`
- [x] `ui/HealthIndicator.java`
- [x] `ui/PrefsButton.java`
- [x] `ui/SimpleButton.java`
- [x] `ui/SpellButton.java`

## utils

- [x] `utils/BArray.java`
- [x] `utils/Utils.java`

## windows

- [x] `windows/WndAscend.java`
- [x] `windows/WndBlacksmith2.java`
- [x] `windows/WndCatalogus.java`
- [x] `windows/WndChooseWay.java`
- [x] `windows/WndClass.java`
- [x] `windows/WndDescend.java`
- [x] `windows/WndDewDrawInfo.java`
- [x] `windows/WndDewVial.java`
- [x] `windows/WndItem.java`
- [x] `windows/WndLevelUp.java`
- [x] `windows/WndOtiluke.java`
- [x] `windows/WndOtilukeMessage.java`
- [x] `windows/WndPetHaste.java`
- [x] `windows/WndTinkerer.java`
- [x] `windows/WndTinkerer2.java`
- [x] `windows/WndTinkerer3.java`
