package com.ataruka.atradsekamod.item.tool;

import java.util.List;

import com.ataruka.atradsekamod.init.AdsekaDamageSource;
import com.ataruka.atradsekamod.init.ItemGroupInit;
import com.ataruka.atradsekamod.init.ItemTierInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ElectriteAxeItem extends AxeItem{

	public ElectriteAxeItem() {
		super(ItemTierInit.ELECTRITE, 3 ,-2.9F , new Properties().tab(ItemGroupInit.ATRADSEKA_MOD).fireResistant());
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target.invulnerableTime == 20)
		{
		target.invulnerableTime = 0;
		}
		target.hurt(AdsekaDamageSource.mobSekai_Magic_Lightning(attacker), 1.0F);
		return super.hurtEnemy(stack, target, attacker);
	}
	
	public void appendHoverText(ItemStack Stack, World Level, List<ITextComponent> Tooltip, ITooltipFlag Flag) {
		Tooltip.add(new TranslationTextComponent("dsco.atradseka.weapon.addition_damage.sekai_magic_lightning").withStyle(TextFormatting.YELLOW)
			   .append(new StringTextComponent(" +2.0").withStyle(TextFormatting.DARK_GRAY)));
	}
	
	public boolean mineBlock;

}
