package com.ataruka.atradsekamod.item.ore;

import com.ataruka.atradsekamod.init.ItemGroupInit;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ElectriteIngotItem extends Item{

	public ElectriteIngotItem() {
		super(new Properties().tab(ItemGroupInit.ATRADSEKA_MOD).rarity(Rarity.EPIC));
	}
}
