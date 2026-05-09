# Sprouted Feature Checklist (vs Shattered)

This checklist is generated from source comparison between:
- `dachhack/SproutedPixelDungeon-Gradle` (Sprouted reference)
- `ispankzombiez/shattered-pixel-dungeon` (current repo)

Each unchecked item is a Sprouted-side feature/class path that does not currently exist as a matching Java path in this Shattered codebase.
Use this as the implementation tracking list in follow-up updates.

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
- [ ] `items/Bomb.java`
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
- [ ] `items/SanChikarahDeath.java`
- [ ] `items/SanChikarahLife.java`
- [ ] `items/SanChikarahTranscend.java`
- [ ] `items/SeekingBombItem.java`
- [ ] `items/SeekingClusterBombItem.java`
- [ ] `items/SewersKey.java`
- [ ] `items/ShadowDragonEgg.java`
- [ ] `items/SmartBomb.java`
- [ ] `items/Spellbook.java`
- [ ] `items/Spellbook_old.java`
- [ ] `items/SteelHoneypot.java`
- [ ] `items/StoneOre.java`
- [ ] `items/TenguKey.java`
- [ ] `items/TomeOfMastery.java`
- [ ] `items/TownReturnBeacon.java`
- [ ] `items/Weightstone.java`
- [ ] `items/Whistle.java`

## items → armor

- [ ] `items/armor/MetalUnderwear.java`
- [ ] `items/armor/glyphs/AntiEntropy.java`
- [ ] `items/armor/glyphs/Bounce.java`
- [ ] `items/armor/glyphs/Displacement.java`
- [ ] `items/armor/glyphs/Metabolism.java`
- [ ] `items/armor/glyphs/Multiplicity.java`
- [ ] `items/armor/glyphs/Stench.java`

## items → artifacts

- [ ] `items/artifacts/RingOfDisintegration.java`
- [ ] `items/artifacts/RingOfFrost.java`

## items → bags

- [ ] `items/bags/AnkhChain.java`
- [ ] `items/bags/KeyRing.java`
- [ ] `items/bags/Quiver.java`
- [ ] `items/bags/SeedPouch.java`
- [ ] `items/bags/SpellBook.java`
- [ ] `items/bags/WandHolster.java`

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

- [ ] `items/journalpages/DragonCave.java`
- [ ] `items/journalpages/JournalPage.java`
- [ ] `items/journalpages/SafeSpotPage.java`
- [ ] `items/journalpages/Sokoban1.java`
- [ ] `items/journalpages/Sokoban2.java`
- [ ] `items/journalpages/Sokoban3.java`
- [ ] `items/journalpages/Sokoban4.java`
- [ ] `items/journalpages/Town.java`
- [ ] `items/journalpages/Vault.java`

## items → keys

- [ ] `items/keys/GoldenSkeletonKey.java`
- [ ] `items/keys/SkeletonKey.java`

## items → misc

- [ ] `items/misc/AutoPotion.java`
- [ ] `items/misc/MiscEquippable.java`
- [ ] `items/misc/Spectacles.java`

## items → nornstone

- [ ] `items/nornstone/BlueNornStone.java`
- [ ] `items/nornstone/GreenNornStone.java`
- [ ] `items/nornstone/NornStone.java`
- [ ] `items/nornstone/OrangeNornStone.java`
- [ ] `items/nornstone/PurpleNornStone.java`
- [ ] `items/nornstone/YellowNornStone.java`

## items → potions

- [ ] `items/potions/PotionOfMana.java`
- [ ] `items/potions/PotionOfMending.java`
- [ ] `items/potions/PotionOfMight.java`
- [ ] `items/potions/PotionOfOverHealing.java`

## items → quest

- [ ] `items/quest/RatSkull.java`

## items → rings

- [ ] `items/rings/RingOfMagic.java`

## items → scrolls

- [ ] `items/scrolls/ScrollOfMagicalInfusion.java`
- [ ] `items/scrolls/ScrollOfMultiUpgrade.java`
- [ ] `items/scrolls/ScrollOfPsionicBlast.java`
- [ ] `items/scrolls/ScrollOfRegrowth.java`

## items → spells

- [ ] `items/spells/SpellOfAmok.java`
- [ ] `items/spells/SpellOfAmok2.java`
- [ ] `items/spells/SpellOfArmor.java`
- [ ] `items/spells/SpellOfBlink.java`
- [ ] `items/spells/SpellOfCharm.java`
- [ ] `items/spells/SpellOfCountdown.java`
- [ ] `items/spells/SpellOfDeath.java`
- [ ] `items/spells/SpellOfDewDraw.java`
- [ ] `items/spells/SpellOfDispel.java`
- [ ] `items/spells/SpellOfFireblast.java`
- [ ] `items/spells/SpellOfFirebolt.java`
- [ ] `items/spells/SpellOfFirestorm.java`
- [ ] `items/spells/SpellOfFright.java`
- [ ] `items/spells/SpellOfGasImmunity.java`
- [ ] `items/spells/SpellOfHaste.java`
- [ ] `items/spells/SpellOfIceblast.java`
- [ ] `items/spells/SpellOfIcebolt.java`
- [ ] `items/spells/SpellOfIcestorm.java`
- [ ] `items/spells/SpellOfInvisibility.java`
- [ ] `items/spells/SpellOfLevitation.java`
- [ ] `items/spells/SpellOfLight.java`
- [ ] `items/spells/SpellOfLightningblast.java`
- [ ] `items/spells/SpellOfLightningbolt.java`
- [ ] `items/spells/SpellOfLightningstorm.java`
- [ ] `items/spells/SpellOfMagicMissile.java`
- [ ] `items/spells/SpellOfMoonFury.java`
- [ ] `items/spells/SpellOfPoison.java`
- [ ] `items/spells/SpellOfRecharge.java`
- [ ] `items/spells/SpellOfRegen.java`
- [ ] `items/spells/SpellOfRoot.java`
- [ ] `items/spells/SpellOfSleep.java`
- [ ] `items/spells/SpellOfSlowing.java`

## items → wands

- [ ] `items/wands/WandOfAmok.java`
- [ ] `items/wands/WandOfAvalanche.java`
- [ ] `items/wands/WandOfBlink.java`
- [ ] `items/wands/WandOfDisintegration2.java`
- [ ] `items/wands/WandOfFirebolt.java`
- [ ] `items/wands/WandOfFlock.java`
- [ ] `items/wands/WandOfPoison.java`
- [ ] `items/wands/WandOfSlowness.java`
- [ ] `items/wands/WandOfTelekinesis.java`
- [ ] `items/wands/WandOfTeleportation.java`

## items → weapon

- [ ] `items/weapon/enchantments/AresLeech.java`
- [ ] `items/weapon/enchantments/BuzzSaw.java`
- [ ] `items/weapon/enchantments/CromLuck.java`
- [ ] `items/weapon/enchantments/Death.java`
- [ ] `items/weapon/enchantments/Fire.java`
- [ ] `items/weapon/enchantments/Horror.java`
- [ ] `items/weapon/enchantments/Instability.java`
- [ ] `items/weapon/enchantments/JupitersHorror.java`
- [ ] `items/weapon/enchantments/Leech.java`
- [ ] `items/weapon/enchantments/LokisPoison.java`
- [ ] `items/weapon/enchantments/Luck.java`
- [ ] `items/weapon/enchantments/NeptuneShock.java`
- [ ] `items/weapon/enchantments/Nomnom.java`
- [ ] `items/weapon/enchantments/Osmose.java`
- [ ] `items/weapon/enchantments/Paralysis.java`
- [ ] `items/weapon/enchantments/Poison.java`
- [ ] `items/weapon/enchantments/Shock.java`
- [ ] `items/weapon/enchantments/Slashing.java`
- [ ] `items/weapon/enchantments/Slow.java`
- [ ] `items/weapon/melee/AssassinsKnife.java`
- [ ] `items/weapon/melee/Axe.java`
- [ ] `items/weapon/melee/BroadSword.java`
- [ ] `items/weapon/melee/Chainsaw.java`
- [ ] `items/weapon/melee/GreatSword.java`
- [ ] `items/weapon/melee/Knuckles.java`
- [ ] `items/weapon/melee/MageStaff.java`
- [ ] `items/weapon/melee/RoyalSpork.java`
- [ ] `items/weapon/melee/ShortSword.java`
- [ ] `items/weapon/melee/Spork.java`
- [ ] `items/weapon/melee/relic/AresSword.java`
- [ ] `items/weapon/melee/relic/CromCruachAxe.java`
- [ ] `items/weapon/melee/relic/LokisFlail.java`
- [ ] `items/weapon/melee/relic/NeptunusTrident.java`
- [ ] `items/weapon/melee/relic/RelicMeleeWeapon.java`
- [ ] `items/weapon/missiles/Boomerang.java`
- [ ] `items/weapon/missiles/CurareDart.java`
- [ ] `items/weapon/missiles/CurareShuriken.java`
- [ ] `items/weapon/missiles/Dart.java`
- [ ] `items/weapon/missiles/ForestDart.java`
- [ ] `items/weapon/missiles/IncendiaryDart.java`
- [ ] `items/weapon/missiles/IncendiaryShuriken.java`
- [ ] `items/weapon/missiles/JupitersWraith.java`
- [ ] `items/weapon/missiles/RiceBall.java`
- [ ] `items/weapon/missiles/Skull.java`
- [ ] `items/weapon/missiles/Tamahawk.java`
- [ ] `items/weapon/missiles/Wave.java`
- [ ] `items/weapon/ranged/Bow.java`
- [ ] `items/weapon/ranged/RangedWeapon.java`

## levels

- [ ] `levels/BattleLevel.java`
- [ ] `levels/CatacombLevel.java`
- [ ] `levels/ChasmLevel.java`
- [ ] `levels/CrabBossLevel.java`
- [ ] `levels/DragonCaveLevel.java`
- [ ] `levels/FieldLevel.java`
- [ ] `levels/FishingLevel.java`
- [ ] `levels/FortressLevel.java`
- [ ] `levels/InfestBossLevel.java`
- [ ] `levels/Layouts.java`
- [ ] `levels/MazeLayout.java`
- [ ] `levels/MineLevel.java`
- [ ] `levels/MinesBossLevel.java`
- [ ] `levels/Room.java`
- [ ] `levels/SafeLevel.java`
- [ ] `levels/SafeLevel1.java`
- [ ] `levels/SkeletonBossLevel.java`
- [ ] `levels/SokobanCastle.java`
- [ ] `levels/SokobanIntroLevel.java`
- [ ] `levels/SokobanLayouts.java`
- [ ] `levels/SokobanLayouts2.java`
- [ ] `levels/SokobanPuzzles2Level.java`
- [ ] `levels/SokobanPuzzlesLevel.java`
- [ ] `levels/SokobanTeleportLevel.java`
- [ ] `levels/SokobanVaultLevel.java`
- [ ] `levels/TenguDenLevel.java`
- [ ] `levels/TenguHideoutLevel.java`
- [ ] `levels/ThiefBossLevel.java`
- [ ] `levels/ThiefCatchLevel.java`
- [ ] `levels/TownLayouts.java`
- [ ] `levels/TownLevel.java`
- [ ] `levels/ZotBossLevel.java`

## levels → features

- [ ] `levels/features/AlchemyPot.java`
- [ ] `levels/features/Sign.java`

## levels → painters

- [ ] `levels/painters/ArmoryPainter.java`
- [ ] `levels/painters/BlacksmithPainter.java`
- [ ] `levels/painters/BossExitPainter.java`
- [ ] `levels/painters/CryptPainter.java`
- [ ] `levels/painters/EntrancePainter.java`
- [ ] `levels/painters/ExitPainter.java`
- [ ] `levels/painters/GardenPainter.java`
- [ ] `levels/painters/LaboratoryPainter.java`
- [ ] `levels/painters/LibraryPainter.java`
- [ ] `levels/painters/MagicWellPainter.java`
- [ ] `levels/painters/PassagePainter.java`
- [ ] `levels/painters/PitPainter.java`
- [ ] `levels/painters/PoolPainter.java`
- [ ] `levels/painters/RatKingPainter.java`
- [ ] `levels/painters/RatKingPainter2.java`
- [ ] `levels/painters/ShopPainter.java`
- [ ] `levels/painters/StandardPainter.java`
- [ ] `levels/painters/StatuePainter.java`
- [ ] `levels/painters/StoragePainter.java`
- [ ] `levels/painters/TrapsPainter.java`
- [ ] `levels/painters/TreasuryPainter.java`
- [ ] `levels/painters/TunnelPainter.java`
- [ ] `levels/painters/VaultPainter.java`
- [ ] `levels/painters/WeakFloorPainter.java`

## levels → traps

- [ ] `levels/traps/ActivatePortalTrap.java`
- [ ] `levels/traps/ChangeSheepTrap.java`
- [ ] `levels/traps/FireTrap.java`
- [ ] `levels/traps/FleecingTrap.java`
- [ ] `levels/traps/HeapGenTrap.java`
- [ ] `levels/traps/LightningTrap.java`
- [ ] `levels/traps/ParalyticTrap.java`
- [ ] `levels/traps/PoisonTrap.java`
- [ ] `levels/traps/SokobanPortalTrap.java`

## plants

- [ ] `plants/Dewcatcher.java`
- [ ] `plants/Dreamfoil.java`
- [ ] `plants/Flytrap.java`
- [ ] `plants/Phaseshift.java`

## scenes

- [ ] `scenes/BadgesScene.java`
- [ ] `scenes/IntroScene.java`

## sprites

- [ ] `sprites/AdultDragonVioletSprite.java`
- [ ] `sprites/AlbinoPiranhaSprite.java`
- [ ] `sprites/AssassinSprite.java`
- [ ] `sprites/BanditKingSprite.java`
- [ ] `sprites/BlueDragonSprite.java`
- [ ] `sprites/BlueWraithSprite.java`
- [ ] `sprites/BrokenRobotSprite.java`
- [ ] `sprites/BrownBatSprite.java`
- [ ] `sprites/BunnySprite.java`
- [ ] `sprites/BurningFistSprite.java`
- [ ] `sprites/CrabKingSprite.java`
- [ ] `sprites/DemonGooSprite.java`
- [ ] `sprites/DewProtectorSprite.java`
- [ ] `sprites/DwarfKingTombSprite.java`
- [ ] `sprites/DwarfLichSprite.java`
- [ ] `sprites/FairySprite.java`
- [ ] `sprites/FishProtectorSprite.java`
- [ ] `sprites/FlyingProtectorSprite.java`
- [ ] `sprites/ForestProtectorSprite.java`
- [ ] `sprites/FossilSkeletonSprite.java`
- [ ] `sprites/GnollArcherSprite.java`
- [ ] `sprites/GoldThiefSprite.java`
- [ ] `sprites/GraveProtectorSprite.java`
- [ ] `sprites/GreenDragonSprite.java`
- [ ] `sprites/GreyOniSprite.java`
- [ ] `sprites/GreyRatSprite.java`
- [ ] `sprites/GullinSprite.java`
- [ ] `sprites/InfectingFistSprite.java`
- [ ] `sprites/KupuaSprite.java`
- [ ] `sprites/LitTowerSprite.java`
- [ ] `sprites/MagicEyeSprite.java`
- [ ] `sprites/MonsterBoxSprite.java`
- [ ] `sprites/MossySkeletonSprite.java`
- [ ] `sprites/MrDestructo2dot0Sprite.java`
- [ ] `sprites/MrDestructoSprite.java`
- [ ] `sprites/OniSprite.java`
- [ ] `sprites/OrbOfZotSprite.java`
- [ ] `sprites/OtilukeNPCSprite.java`
- [ ] `sprites/OtilukeSprite.java`
- [ ] `sprites/PinningFistSprite.java`
- [ ] `sprites/PlantSprite.java`
- [ ] `sprites/PoisonGooSprite.java`
- [ ] `sprites/RatBossSprite.java`
- [ ] `sprites/RedDragonSprite.java`
- [ ] `sprites/RedWraithSprite.java`
- [ ] `sprites/RottingFistSprite.java`
- [ ] `sprites/ScorpionSprite.java`
- [ ] `sprites/SeekingBombSprite.java`
- [ ] `sprites/SeekingClusterBombSprite.java`
- [ ] `sprites/SentinelSprite.java`
- [ ] `sprites/ShadowDragonSprite.java`
- [ ] `sprites/ShadowYogSprite.java`
- [ ] `sprites/ShellSprite.java`
- [ ] `sprites/SkeletonHand1Sprite.java`
- [ ] `sprites/SkeletonHand2Sprite.java`
- [ ] `sprites/SkeletonKingSprite.java`
- [ ] `sprites/SokobanBlackSheepSprite.java`
- [ ] `sprites/SokobanCornerSheepSprite.java`
- [ ] `sprites/SokobanSentinelSprite.java`
- [ ] `sprites/SokobanSheepSprite.java`
- [ ] `sprites/SokobanSheepSwitchSprite.java`
- [ ] `sprites/SpectralRatSprite.java`
- [ ] `sprites/SpiderSprite.java`
- [ ] `sprites/SteelBeeSprite.java`
- [ ] `sprites/SugarplumFairySprite.java`
- [ ] `sprites/ThiefKingSprite.java`
- [ ] `sprites/TinkererSprite.java`
- [ ] `sprites/TowerSprite.java`
- [ ] `sprites/VaultProtectorSprite.java`
- [ ] `sprites/VelociroosterSprite.java`
- [ ] `sprites/VillagerSprite.java`
- [ ] `sprites/VioletDragonSprite.java`
- [ ] `sprites/ZotPhaseSprite.java`
- [ ] `sprites/ZotSprite.java`

## ui

- [ ] `ui/GoldIndicator.java`
- [ ] `ui/HealthIndicator.java`
- [ ] `ui/PrefsButton.java`
- [ ] `ui/SimpleButton.java`
- [ ] `ui/SpellButton.java`

## utils

- [ ] `utils/BArray.java`
- [ ] `utils/Utils.java`

## windows

- [ ] `windows/WndAscend.java`
- [ ] `windows/WndBlacksmith2.java`
- [ ] `windows/WndCatalogus.java`
- [ ] `windows/WndChooseWay.java`
- [ ] `windows/WndClass.java`
- [ ] `windows/WndDescend.java`
- [ ] `windows/WndDewDrawInfo.java`
- [ ] `windows/WndDewVial.java`
- [ ] `windows/WndItem.java`
- [ ] `windows/WndLevelUp.java`
- [ ] `windows/WndOtiluke.java`
- [ ] `windows/WndOtilukeMessage.java`
- [ ] `windows/WndPetHaste.java`
- [ ] `windows/WndTinkerer.java`
- [ ] `windows/WndTinkerer2.java`
- [ ] `windows/WndTinkerer3.java`
