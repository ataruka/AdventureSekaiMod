package com.ataruka.atradsekamod.init;

import com.ataruka.atradsekamod.AdventureSekaiMod;
import com.ataruka.atradsekamod.block.ElectricRedstoneOreBlock;
import com.ataruka.atradsekamod.block.SolidCoalBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,AdventureSekaiMod.MOD_ID);
	
	public static final RegistryObject<Block> SOLID_COAL_BLOCK = BLOCKS.register("solid_coal_block", () -> new SolidCoalBlock());
	public static final RegistryObject<Block> ELECTRIC_REDSTONE_ORE = BLOCKS.register("electric_redstone_ore", () -> new ElectricRedstoneOreBlock());
}
