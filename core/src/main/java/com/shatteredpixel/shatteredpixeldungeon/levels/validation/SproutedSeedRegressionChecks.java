package com.shatteredpixel.shatteredpixeldungeon.levels.validation;

import com.shatteredpixel.shatteredpixeldungeon.levels.Layouts;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanLayouts;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanLayouts2;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanIntroLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanPuzzles2Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanPuzzlesLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanTeleportLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanVaultLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.TenguDenLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.TenguHideoutLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.TownLayouts;
import com.shatteredpixel.shatteredpixeldungeon.levels.TownLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.CatacombLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.InfestBossLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.FortressLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.CrabBossLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.DragonCaveLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.MinesBossLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.MineLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SafeLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SafeLevel1;
import com.shatteredpixel.shatteredpixeldungeon.levels.SkeletonBossLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanCastle;
import com.shatteredpixel.shatteredpixeldungeon.levels.ThiefBossLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.VaultLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.ZotBossLevel;
import com.watabou.utils.Random;

public class SproutedSeedRegressionChecks {

	public static void main(String[] args) {
		verifyDeterministicLayouts();
		verifyBranchRoutes();
		System.out.println("Sprouted seed regression checks passed.");
	}

	private static void verifyDeterministicLayouts() {
		String firstTown = seededLayoutHash(1337L, LayoutType.TOWN);
		String secondTown = seededLayoutHash(1337L, LayoutType.TOWN);
		assertEquals(firstTown, secondTown, "Town layout selection must be deterministic for a fixed seed");

		String firstSokoban = seededLayoutHash(4242L, LayoutType.SOKOBAN_1);
		String secondSokoban = seededLayoutHash(4242L, LayoutType.SOKOBAN_1);
		assertEquals(firstSokoban, secondSokoban, "Sokoban layout selection must be deterministic for a fixed seed");

		String firstSokoban2 = seededLayoutHash(9999L, LayoutType.SOKOBAN_2);
		String secondSokoban2 = seededLayoutHash(9999L, LayoutType.SOKOBAN_2);
		assertEquals(firstSokoban2, secondSokoban2, "Sokoban2 layout selection must be deterministic for a fixed seed");

		String firstTeleport = seededLayoutHash(2468L, LayoutType.SOKOBAN_TELEPORT);
		String secondTeleport = seededLayoutHash(2468L, LayoutType.SOKOBAN_TELEPORT);
		assertEquals(firstTeleport, secondTeleport, "Sokoban teleport layout selection must be deterministic for a fixed seed");

		String firstVault = seededLayoutHash(8642L, LayoutType.SOKOBAN_VAULT);
		String secondVault = seededLayoutHash(8642L, LayoutType.SOKOBAN_VAULT);
		assertEquals(firstVault, secondVault, "Sokoban vault layout selection must be deterministic for a fixed seed");
	}

	private static void verifyBranchRoutes() {
		assertRoute(11, 2, MineLevel.class);
		assertRoute(14, 2, MineLevel.class);
		assertRoute(15, 2, InfestBossLevel.class);
		assertRoute(16, 2, FortressLevel.class);
		assertRoute(19, 2, FortressLevel.class);
		assertRoute(20, 2, CatacombLevel.class);
		assertRoute(22, 2, CatacombLevel.class);
		assertRoute(23, 2, TownLevel.class);
		assertRoute(24, 2, TenguDenLevel.class);
		assertRoute(25, 2, TenguHideoutLevel.class);
		assertRoute(26, 2, SokobanIntroLevel.class);
		assertRoute(27, 2, SokobanPuzzlesLevel.class);
		assertRoute(28, 2, SokobanPuzzles2Level.class);
		assertRoute(29, 2, SokobanTeleportLevel.class);
		assertRoute(30, 2, SokobanVaultLevel.class);
		assertMissingRoute(31, 2);

		assertRoute(24, 3, TownLevel.class);
		assertRoute(25, 3, TenguHideoutLevel.class);
		assertMissingRoute(23, 3);
		assertMissingRoute(26, 3);

		verifyDocumentedRouteAudit();
	}

	private static void verifyDocumentedRouteAudit() {
		assertClassMappedExactly(InfestBossLevel.class, 15, 2);

		assertClassNeverMappedInLayouts(MinesBossLevel.class);
		assertClassNeverMappedInLayouts(SkeletonBossLevel.class);
		assertClassNeverMappedInLayouts(CrabBossLevel.class);
		assertClassNeverMappedInLayouts(ThiefBossLevel.class);
		assertClassNeverMappedInLayouts(DragonCaveLevel.class);
		assertClassNeverMappedInLayouts(ZotBossLevel.class);
		assertClassNeverMappedInLayouts(SokobanCastle.class);
		assertClassNeverMappedInLayouts(SafeLevel.class);
		assertClassNeverMappedInLayouts(SafeLevel1.class);
		assertClassNeverMappedInLayouts(VaultLevel.class);
	}

	private static String seededLayoutHash(long seed, LayoutType layoutType) {
		Random.resetGenerators();
		Random.pushGenerator(seed);
		try {
			String[] layout;
			switch (layoutType) {
				case TOWN:
					layout = TownLayouts.randomLayout();
					break;
				case SOKOBAN_1:
					layout = SokobanLayouts.randomLayout();
					break;
				case SOKOBAN_2:
					layout = SokobanLayouts2.randomLayout();
					break;
				case SOKOBAN_TELEPORT:
					layout = SokobanLayouts.randomTeleportLayout();
					break;
				case SOKOBAN_VAULT:
					layout = SokobanLayouts2.randomVaultLayout();
					break;
				default:
					throw new IllegalStateException("Unexpected layout type: " + layoutType);
			}
			return String.join("|", layout);
		} finally {
			Random.popGenerator();
		}
	}

	private static void assertEquals(String a, String b, String message) {
		if (!a.equals(b)) {
			throw new IllegalStateException(message + " [" + a + " != " + b + "]");
		}
	}

	private static void assertRoute(int depth, int branch, Class<? extends Level> expectedType) {
		Level level = Layouts.branchLevel(depth, branch);
		if (level == null || level.getClass() != expectedType) {
			throw new IllegalStateException("Expected branch " + branch + " depth " + depth
					+ " to map to " + expectedType.getSimpleName()
					+ " but got " + (level == null ? "null" : level.getClass().getSimpleName()));
		}
	}

	private static void assertMissingRoute(int depth, int branch) {
		if (Layouts.hasBranchRoute(depth, branch)) {
			throw new IllegalStateException("Expected no Sprouted branch route for branch " + branch + " depth " + depth);
		}
	}

	private static void assertClassNeverMappedInLayouts(Class<? extends Level> type) {
		for (int branch = 0; branch <= 3; branch++) {
			for (int depth = 1; depth <= 40; depth++) {
				Level level = Layouts.branchLevel(depth, branch);
				if (level != null && level.getClass() == type) {
					throw new IllegalStateException("Expected " + type.getSimpleName()
							+ " to remain unmapped in Layouts.branchLevel(), but found at branch " + branch
							+ " depth " + depth);
				}
			}
		}
	}

	private static void assertClassMappedExactly(Class<? extends Level> type, int expectedDepth, int expectedBranch) {
		int matches = 0;
		for (int branch = 0; branch <= 3; branch++) {
			for (int depth = 1; depth <= 40; depth++) {
				Level level = Layouts.branchLevel(depth, branch);
				if (level != null && level.getClass() == type) {
					matches++;
					if (depth != expectedDepth || branch != expectedBranch) {
						throw new IllegalStateException("Expected " + type.getSimpleName() + " only at branch "
								+ expectedBranch + " depth " + expectedDepth + ", but found mapping at branch "
								+ branch + " depth " + depth);
					}
				}
			}
		}
		if (matches != 1) {
			throw new IllegalStateException("Expected exactly one mapping for " + type.getSimpleName()
					+ " in Layouts.branchLevel(), but found " + matches);
		}
	}

	private enum LayoutType {
		TOWN,
		SOKOBAN_1,
		SOKOBAN_2,
		SOKOBAN_TELEPORT,
		SOKOBAN_VAULT
	}
}
