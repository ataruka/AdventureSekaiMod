package com.ataruka.atradsekamod.world;

import com.ataruka.atradsekamod.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class Generation {
		public static void addOres(final BiomeLoadingEvent event) {
			addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
					BlockInit.ELECTRIC_REDSTONE_ORE.get().defaultBlockState(), 3, 2, 30, 2);
		}
	
	public static void addOre(final BiomeLoadingEvent event, RuleTest blocktype, BlockState state,int veinSize, int minHeight, int maxHeight, int amountPerChunk) {
		event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
		Feature.ORE.configured(new OreFeatureConfig(blocktype, state, veinSize))
		.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
	    .squared()
	    .count(amountPerChunk));
	}

}
