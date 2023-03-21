package com.ataruka.atradsekamod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class SolidCoalBlock extends Block{

	public SolidCoalBlock() {
		super(Properties
				.of(Material.METAL,MaterialColor.COLOR_BLACK)
				.requiresCorrectToolForDrops()
				.strength(10.0F, 8.0F)
		        .sound(SoundType.STONE)
		        .harvestTool(ToolType.PICKAXE)
		        .harvestLevel(0));
	}

}
