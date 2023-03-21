package com.ataruka.atradsekamod.block;

import java.util.Random;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

public class ElectricRedstoneOreBlock extends OreBlock{

	public ElectricRedstoneOreBlock() {
		super(Properties
				.of(Material.METAL,MaterialColor.COLOR_GRAY)
				.requiresCorrectToolForDrops()
				.strength(3.0F, 3.0F)
		        .sound(SoundType.STONE)
		        .harvestTool(ToolType.PICKAXE)
		        .harvestLevel(2));
	}
	
	public int getExperience(Random rand, int fortune, int silktouch) {
	      return silktouch == 0 ? MathHelper.nextInt(rand, 1, 5) * (fortune + 1) : 0;
	}

}
