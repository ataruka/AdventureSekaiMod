package com.ataruka.atradsekamod.item.tool;

import java.util.List;

import com.ataruka.atradsekamod.init.AdsekaDamageSource;
import com.ataruka.atradsekamod.init.ItemGroupInit;
import com.ataruka.atradsekamod.init.ItemTierInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ElectriteHoeItem extends HoeItem{

	public ElectriteHoeItem() {
		super(ItemTierInit.ELECTRITE, -5, 1.0F , new Properties().tab(ItemGroupInit.ATRADSEKA_MOD));
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.invulnerableTime = 0;
		target.hurt(AdsekaDamageSource.mobSekai_Magic_Lightning(attacker), 1.0F);
		target.invulnerableTime = 0;
		return super.hurtEnemy(stack, target, attacker);
	}
	
	   public void appendHoverText(ItemStack Stack, World Level, List<ITextComponent> Tooltip, ITooltipFlag Flag) {
		   Tooltip.add(new TranslationTextComponent("dsco.atradseka.weapon.addition_damage.sekai_magic_lightning").withStyle(TextFormatting.YELLOW)
				   .append(new StringTextComponent(" +1.0").withStyle(TextFormatting.DARK_GRAY)));
		   Tooltip.add(new StringTextComponent(" ").withStyle(TextFormatting.DARK_GRAY));
		   Tooltip.add(new StringTextComponent("oraoraoraoraoraora...ORA!!!!").withStyle(TextFormatting.GRAY));
	   }

}
