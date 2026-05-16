package com.shatteredpixel.shatteredpixeldungeon.levels.validation;

import com.shatteredpixel.shatteredpixeldungeon.levels.Layouts;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanLayouts;
import com.shatteredpixel.shatteredpixeldungeon.levels.SokobanLayouts2;
import com.shatteredpixel.shatteredpixeldungeon.levels.TownLayouts;
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
	}

	private static void verifyBranchRoutes() {
		for (int depth = 24; depth <= 30; depth++) {
			if (!Layouts.hasBranchRoute(depth, 2)) {
				throw new IllegalStateException("Missing required branch 2 route at depth " + depth);
			}
		}
		if (!Layouts.hasBranchRoute(24, 3) || !Layouts.hasBranchRoute(25, 3)) {
			throw new IllegalStateException("Missing required branch 3 routes at depths 24/25");
		}
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

	private enum LayoutType {
		TOWN,
		SOKOBAN_1,
		SOKOBAN_2
	}
}
