package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;

public final class MapSizeProfiles {

	public static final class Profile {
		public final float roomCountMultiplier;
		public final float trapMultiplier;
		public final float mobMultiplier;
		public final float itemMultiplier;
		public final int extraPadding;
		public final int spawnRetryLimit;

		private Profile(float roomCountMultiplier, float trapMultiplier, float mobMultiplier, float itemMultiplier, int extraPadding, int spawnRetryLimit) {
			this.roomCountMultiplier = roomCountMultiplier;
			this.trapMultiplier = trapMultiplier;
			this.mobMultiplier = mobMultiplier;
			this.itemMultiplier = itemMultiplier;
			this.extraPadding = extraPadding;
			this.spawnRetryLimit = spawnRetryLimit;
		}
	}

	private static final Profile DEFAULT_REGULAR = new Profile(1f, 1f, 1f, 1f, 0, 30);

	private MapSizeProfiles() {
	}

	public static Profile forLevel(Level level) {
		if (!(level instanceof RegularLevel)) {
			return DEFAULT_REGULAR;
		}

		if (Dungeon.branch == 2 || Dungeon.branch == 3) {
			if (level instanceof TownLevel || level instanceof MineLevel || level instanceof FortressLevel || level instanceof CatacombLevel) {
				return new Profile(1.45f, 1.35f, 1.30f, 1.25f, 1, 48);
			}
			if (level instanceof SokobanIntroLevel || level instanceof SokobanPuzzlesLevel || level instanceof SokobanPuzzles2Level
					|| level instanceof SokobanTeleportLevel || level instanceof SokobanVaultLevel) {
				return new Profile(1.15f, 1f, 1.1f, 1.1f, 0, 40);
			}
		}

		if (level instanceof HallsLevel) {
			return new Profile(1.30f, 1.25f, 1.22f, 1.20f, 1, 42);
		}
		if (level instanceof CityLevel) {
			return new Profile(1.24f, 1.20f, 1.18f, 1.15f, 1, 40);
		}
		if (level instanceof CavesLevel) {
			return new Profile(1.20f, 1.15f, 1.12f, 1.10f, 1, 38);
		}
		if (level instanceof PrisonLevel) {
			return new Profile(1.16f, 1.12f, 1.10f, 1.08f, 0, 36);
		}
		if (level instanceof SewerLevel) {
			return new Profile(1.12f, 1.08f, 1.06f, 1.05f, 0, 34);
		}

		return DEFAULT_REGULAR;
	}

	public static int arenaSizeFor(SproutedArenaLevel level) {
		int depth = Dungeon.depth;
		if (level instanceof TenguDenLevel || level instanceof TenguHideoutLevel) {
			return depth >= 25 ? 45 : 41;
		}
		if (level instanceof FishingLevel) {
			return depth >= 29 ? 47 : 43;
		}
		if (level instanceof BattleLevel) {
			return depth >= 28 ? 45 : 41;
		}
		if (level instanceof FieldLevel) {
			return depth >= 27 ? 43 : 39;
		}
		return 39;
	}
}
