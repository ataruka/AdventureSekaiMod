package com.ataruka.atradsekamod.item.food;

import com.ataruka.atradsekamod.init.ItemGroupInit;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class PoppyDeuceItem extends Item{

	public PoppyDeuceItem() {
		super(new Properties().rarity(Rarity.RARE).tab(ItemGroupInit.ATRADSEKA_MOD).stacksTo(64)
				.food(new Food.Builder()
				.nutrition(3)
				.saturationMod(3.2F)
				.effect(() -> new EffectInstance(Effects.REGENERATION,60,0),1)
				.alwaysEat()
				.build()));
	}
	   public ItemStack finishUsingItem(ItemStack pStack, World pLevel, LivingEntity pEntityLiving) {
		      super.finishUsingItem(pStack, pLevel, pEntityLiving);
		      if (pEntityLiving instanceof ServerPlayerEntity) {
		         ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)pEntityLiving;
		         CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, pStack);
		         serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
		      }

		      if (pStack.isEmpty()) {
		         return new ItemStack(Items.GLASS_BOTTLE);
		      } else {
		         if (pEntityLiving instanceof PlayerEntity && !((PlayerEntity)pEntityLiving).abilities.instabuild) {
		            ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
		            PlayerEntity playerentity = (PlayerEntity)pEntityLiving;
		            if (!playerentity.inventory.add(itemstack)) {
		               playerentity.drop(itemstack, false);
		            }
		         }

		         return pStack;
		      }
		   }
}

