package com.ataruka.atradsekamod.item.tool;

import java.util.List;

import com.ataruka.atradsekamod.init.AdsekaDamageSource;
import com.ataruka.atradsekamod.init.ItemGroupInit;
import com.ataruka.atradsekamod.init.ItemTierInit;
import com.ataruka.atradsekamod.init.keybind.AdsekaKeyBind;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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
		Tooltip.add(new StringTextComponent(" ").withStyle(TextFormatting.DARK_GRAY));
		Tooltip.add(new StringTextComponent("CutMode " + modeName(Stack)).withStyle(TextFormatting.WHITE));
	}
	
	public void inventoryTick(ItemStack stack, World Level, Entity Entity, int ItemSlot, boolean IsSelected) {
		PlayerEntity player = (PlayerEntity) Entity;
		Hand hand = Hand.MAIN_HAND;
		if(AdsekaKeyBind.adsekaKey[0].consumeClick() && player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == stack.getItem()) {
			player.setItemInHand(hand, stack);
			modeChange(stack);
			player.sendMessage((new StringTextComponent("CutMode " + modeName(stack)).withStyle(TextFormatting.WHITE)), player.getUUID());
		} 
	}
		
		public void modeChange(ItemStack stack) {
			
			if (stack.getTag() == null) {
				
				stack.setTag(new CompoundNBT());
			}
			stack.getTag().putInt("mode", modeInt(stack) == 0 ? modeInt(stack) + 1 : 0);
			
		}
		private int modeInt(ItemStack stack) {
			
			if(stack.getTag() == null) {
				
				return 0;
			}
			return stack.getTag().getInt("mode");
		}
	    public String modeName(ItemStack stack) {
		    switch (modeInt(stack)) {
		    
	   		case 0 : return "False";
	   		
	   		case 1 : return "True";
	   		
		    }
		    return "false";
	    	
	    }
		
	public boolean mineBlock(ItemStack stack, World level, BlockState state, BlockPos pos, LivingEntity EntityLiving) {
		PlayerEntity player = (PlayerEntity) EntityLiving;
		System.out.println(stack.getItem().getHarvestLevel(stack, ToolType.PICKAXE, player, state));
    	Block block = state.getBlock();
    	int a [] = {-1,0,1};
    	for(int ax = 0; ax < 3; ax++) {
    		for(int az = 0; az < 3; az++) {
    			for(int ay = 0; ay < 3; ay++) {
    				BlockPos aPos = new BlockPos(pos.getX() + a[ax],pos.getY() + a[ay], pos.getZ() + a[az]);
    				if (level.getBlockState(aPos).getBlock().getHarvestTool(state)==block.getHarvestTool(state) && level.getBlockState(aPos).getBlock().getHarvestLevel(state)<= stack.getItem().getHarvestLevel(stack, ToolType.PICKAXE, player, state) && modeInt(stack)==1 && !player.isShiftKeyDown()) {
    					level.destroyBlock(aPos, true, EntityLiving);
    					stack.setDamageValue( stack.getDamageValue() +50);
    				}
    			}}}
    	return true;
	}

}
