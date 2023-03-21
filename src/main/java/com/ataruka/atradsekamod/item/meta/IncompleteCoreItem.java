package com.ataruka.atradsekamod.item.meta;

import com.ataruka.atradsekamod.init.ItemGroupInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class IncompleteCoreItem extends Item{

	public IncompleteCoreItem() {
		super(new Properties().tab(ItemGroupInit.ATRADSEKA_MOD).rarity(Rarity.UNCOMMON));
	}
	
	@Override
	public int getBurnTime(ItemStack itemstack) {
		return 300;
	}

}
