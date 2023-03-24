package com.ataruka.atradsekamod.item.weapon;

import java.util.List;

import com.ataruka.atradsekamod.init.ItemGroupInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class IronDaggerItem extends SwordItem{

	public IronDaggerItem() {
		super(ItemTier.IRON, 1 ,-2 , new Properties().tab(ItemGroupInit.ATRADSEKA_MOD));
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target.invulnerableTime == 20)
		{
		target.invulnerableTime = 0;
		}
		target.hurt(DamageSource.mobAttack(attacker), 0.8F);
		target.invulnerableTime = 10;
		return super.hurtEnemy(stack, target, attacker);
	}
	
	   public void appendHoverText(ItemStack Stack, World Level, List<ITextComponent> Tooltip, ITooltipFlag Flag) {
		   Tooltip.add(new TranslationTextComponent("dsco.atradseka.weapon.addition_damage").withStyle(TextFormatting.GRAY)
				  .append(new StringTextComponent(" +0.8").withStyle(TextFormatting.DARK_GRAY)));
	   }

}
