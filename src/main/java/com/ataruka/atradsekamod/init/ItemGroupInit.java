package com.ataruka.atradsekamod.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ItemGroupInit {

	public static final ItemGroup ATRADSEKA_MOD = new ItemGroup("atradseka") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.ACACIA_BOAT);
		}
	};
}
