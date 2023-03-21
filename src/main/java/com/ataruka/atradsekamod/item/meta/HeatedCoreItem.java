package com.ataruka.atradsekamod.item.meta;

import com.ataruka.atradsekamod.init.ItemGroupInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class HeatedCoreItem extends Item{

	public HeatedCoreItem() {
		super(new Properties().tab(ItemGroupInit.ATRADSEKA_MOD).rarity(Rarity.RARE));
	}
	
	@Override
	public int getBurnTime(ItemStack itemstack) {
		return 2000;
	}

}
