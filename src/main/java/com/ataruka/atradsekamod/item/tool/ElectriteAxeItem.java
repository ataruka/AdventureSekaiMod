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
		Tooltip.add(new StringTextComponent("CutMode:" + modeName(Stack)).withStyle(TextFormatting.WHITE));
	}
	
	public void inventoryTick(ItemStack stack, World Level, Entity Entity, int ItemSlot, boolean IsSelected) {
		PlayerEntity player = (PlayerEntity) Entity;
		if(AdsekaKeyBind.adsekaKey[0].consumeClick() && player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == stack.getItem()) {
			modeChanges(stack, Level, Entity, ItemSlot, IsSelected);
		} 
	}
		public void modeChanges(ItemStack stack, World Level, Entity Entity, int ItemSlot, boolean IsSelected) {
			PlayerEntity player = (PlayerEntity) Entity;
			Hand hand = Hand.MAIN_HAND;
			System.out.println(stack.getItem());
			player.setItemInHand(hand, stack);
			modeChange(stack);
			player.sendMessage((new StringTextComponent("CutMode:" + modeName(stack)).withStyle(TextFormatting.WHITE)), player.getUUID());
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
		System.out.print("aaaaa");
		PlayerEntity player = (PlayerEntity) EntityLiving;
    	Block block = state.getBlock();
    	int a [] = {-3,-2,-1,0,1,2,3};
    	for(int ax = 0; ax < 7; ax++) {
    		for(int az = 0; az < 7; az++) {
    			for(int y = 0; y < 50; y++) {
    				BlockPos aPos = new BlockPos(pos.getX() + a[ax],pos.getY() + y, pos.getZ() + a[az]);
    				if (level.getBlockState(aPos).getBlock()==block.getBlock() && modeInt(stack)==1 && !player.isShiftKeyDown()) {
    					level.destroyBlock(aPos, true, EntityLiving);
    					stack.setDamageValue( stack.getDamageValue() +1);
    				}
    			}}}
		stack.setDamageValue( stack.getDamageValue() +1);
    	return true;
	}

}
