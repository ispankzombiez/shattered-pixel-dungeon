/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2026 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.journal.Catalog;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;

import java.util.ArrayList;

public abstract class UpgradeBlob extends Item {

	private static final float TIME_TO_UPGRADE	= 2f;
	private static final String AC_UPGRADE		= "UPGRADE";

	private final int upgrades;

	protected UpgradeBlob(int upgrades) {
		this.upgrades = upgrades;
		stackable = true;
		bones = true;
		defaultAction = AC_UPGRADE;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_UPGRADE);
		return actions;
	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);
		if (action.equals(AC_UPGRADE)) {
			curUser = hero;
			GameScene.selectItem(itemSelector);
		}
	}

	private void upgrade(Item item) {
		int toApply = Math.max(0, Math.min(upgrades, 15 - item.level()));
		if (toApply <= 0) {
			GLog.w(Messages.get(this, "already_maxed"));
			return;
		}

		detach(curUser.belongings.backpack);
		Catalog.countUse(getClass());

		item.upgrade(toApply);
		Badges.validateItemLevelAquired(item);
		GLog.p(Messages.get(this, "upgraded", item.name()));

		curUser.sprite.operate(curUser.pos);
		curUser.sprite.emitter().start(Speck.factory(Speck.UP), 0.2f, 3);
		Sample.INSTANCE.play(Assets.Sounds.TELEPORT);

		curUser.spendAndNext(TIME_TO_UPGRADE);
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	@Override
	public int value() {
		return 30 * quantity;
	}

	private final WndBag.ItemSelector itemSelector = new WndBag.ItemSelector() {
		@Override
		public String textPrompt() {
			return Messages.get(UpgradeBlob.this, "prompt");
		}

		@Override
		public Class<? extends Bag> preferredBag() {
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return item.isUpgradable();
		}

		@Override
		public void onSelect(Item item) {
			if (item != null) {
				UpgradeBlob.this.upgrade(item);
			}
		}
	};
}
