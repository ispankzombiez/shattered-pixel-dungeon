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

package com.shatteredpixel.shatteredpixeldungeon.windows;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.EggPet;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.Group;
import com.watabou.noosa.Image;
import com.watabou.utils.Reflection;

public class PetStatsTab extends Group {

	private static final int GAP = 6;
	private static final int BUTTON_PADDING = 2;

	private final int width;
	private float pos;

	public PetStatsTab( Hero hero, int width ) {
		this.width = width;

		EggPet pet = displayPet(hero);
		if (pet == null) return;

		Image icon = Icons.get(Icons.SNAKE);
		IconTitle title = new IconTitle(icon, Messages.upperCase(Messages.get(this, "title",
				pet.petLevel, Messages.titleCase(pet.name()))));
		title.color(Window.TITLE_COLOR);
		title.setRect(0, 0, width, 0);
		title.health((float) pet.HP / pet.HT);
		add(title);

		pos = title.bottom() + GAP;

		RedButton btnCall = new RedButton(Messages.get(this, "call")) {
			@Override
			protected void onClick() {
				EggPet activePet = hero.activeEggPet();
				if (activePet != null) {
					activePet.callback = true;
					activePet.stay = false;
					activePet.followHero();
					hero.syncEggPet(activePet);
				}
			}
		};
		EggPet activePet = hero.activeEggPet();
		boolean stayMode = activePet != null && activePet.stay;
		RedButton btnStay = new RedButton(Messages.get(this, stayMode ? "release" : "stay")) {
			@Override
			protected void onClick() {
				EggPet activePet = hero.activeEggPet();
				if (activePet != null) {
					activePet.stay = !activePet.stay;
					activePet.callback = false;
					if (!activePet.stay) {
						activePet.followHero();
					}
					text(Messages.get(PetStatsTab.this, activePet.stay ? "release" : "stay"));
					hero.syncEggPet(activePet);
				}
			}
		};
		float buttonHeight = Math.max(btnCall.reqHeight(), btnStay.reqHeight()) + BUTTON_PADDING;
		float buttonWidth = (width - GAP) / 2f;
		btnCall.setRect(0, pos, buttonWidth, buttonHeight);
		btnStay.setRect(btnCall.right() + GAP, pos, width - btnCall.width() - GAP, buttonHeight);
		add(btnCall);
		add(btnStay);
		pos = btnCall.bottom() + GAP;

		statSlot(Messages.get(this, "attack"), Integer.toString(pet.attackSkill(null)));
		statSlot(Messages.get(this, "health"), pet.HP + "/" + pet.HT);
		statSlot(Messages.get(this, "kills"), Integer.toString(pet.kills));
		if (pet.petLevel < 20) {
			statSlot(Messages.get(this, "exp"), pet.experience + "/" + expRequiredForNextLevel(pet));
		} else {
			statSlot(Messages.get(this, "exp"), Messages.get(this, "max"));
		}

		String abilityLabel = abilityLabel(pet);
		if (abilityLabel != null) {
			statSlot(abilityLabel, abilityStatus(pet));
		}
	}

	private EggPet displayPet( Hero hero ) {
		EggPet pet = hero.activeEggPet();
		if (pet != null) return pet;

		if (hero.eggPetClass == null) return null;

		pet = Reflection.newInstance(hero.eggPetClass);
		if (pet == null) return null;

		pet.restoreHeroState(hero);
		return pet;
	}

	private String abilityLabel( EggPet pet ) {
		if (pet instanceof EggPet.SpiderPet) {
			return Messages.get(this, "spin");
		} else if (pet instanceof EggPet.ScorpionPet) {
			return Messages.get(this, "sting");
		} else if (pet instanceof EggPet.VelociroosterPet) {
			return Messages.get(this, "feathers");
		} else if (pet instanceof EggPet.FairyPet || pet instanceof EggPet.SugarplumFairyPet) {
			return Messages.get(this, "sparkle");
		} else if (pet instanceof EggPet.RangedDragonPet) {
			return Messages.get(this, "breath");
		}
		return null;
	}

	private String abilityStatus( EggPet pet ) {
		if (pet.cooldown <= 0) {
			return Messages.get(this, "ready");
		}

		int turns = (int) Math.ceil(pet.cooldown / (double) cooldownRate(pet));
		return Messages.get(this, "turns", turns);
	}

	private int expRequiredForNextLevel( EggPet pet ) {
		int level = Math.max(1, pet.petLevel);
		return 2 * level * level;
	}

	private int cooldownRate( EggPet pet ) {
		int level = Math.max(1, pet.petLevel);
		return level * level;
	}

	private void statSlot( String label, String value ) {
		int size = 8;
		RenderedTextBlock txt;
		do {
			txt = PixelScene.renderTextBlock(label, size);
			size--;
		} while (size > 4 && txt.width() >= width * 0.55f);
		txt.setPos(0, pos + (6 - txt.height()) / 2f);
		PixelScene.align(txt);
		add(txt);

		size = 8;
		do {
			txt = PixelScene.renderTextBlock(value, size);
			size--;
		} while (size > 4 && txt.width() >= width * 0.45f);
		txt.setPos(width * 0.55f, pos + (6 - txt.height()) / 2f);
		PixelScene.align(txt);
		add(txt);

		pos += GAP + txt.height();
	}
}
