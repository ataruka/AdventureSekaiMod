package com.ataruka.atradsekamod.item.tool;

import java.util.List;

import javax.annotation.Nullable;

import com.ataruka.atradsekamod.init.AdsekaDamageSource;
import com.ataruka.atradsekamod.init.ItemGroupInit;
import com.ataruka.atradsekamod.init.ItemTierInit;
import com.ataruka.atradsekamod.init.keybind.AdsekaKeyBind;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ElectritePickaxeItem extends PickaxeItem{
	
	public ElectritePickaxeItem() {
		super(ItemTierInit.ELECTRITE, 0 ,-2.8F , new Properties().tab(ItemGroupInit.ATRADSEKA_MOD));
		
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if(target.invulnerableTime == 20){
			
			target.invulnerableTime = 0;
		
		}
		target.hurt(AdsekaDamageSource.mobSekai_Magic_Lightning(attacker), 1.0F);
		return super.hurtEnemy(stack, target, attacker);
	}
	
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn){
		ItemStack stack = playerIn.getItemInHand(handIn);
		
		if(playerIn.isShiftKeyDown()) {
			playerIn.setItemInHand(handIn, stack);
			modeChange(stack);
			playerIn.displayClientMessage(new StringTextComponent("Mode" + modeName(stack)).withStyle(TextFormatting.WHITE), true);
			return ActionResult.consume(stack);
		}
		return ActionResult.pass(stack);
		
	}
	
	public void inventoryTick(ItemStack stack, World Level, Entity Entity, int ItemSlot, boolean IsSelected) {
		PlayerEntity player = (PlayerEntity) Entity;
		Hand hand = Hand.MAIN_HAND;
		if(AdsekaKeyBind.adsekaKey[0].consumeClick() && player.getItemBySlot(EquipmentSlotType.MAINHAND).getItem() == stack.getItem()) {
			player.setItemInHand(hand, stack);
			modeChange2(stack);
			player.sendMessage((new StringTextComponent("MultiMode " + modeName2(stack)).withStyle(TextFormatting.WHITE)), player.getUUID());
		}  

	}
	
	public boolean mineBlock(ItemStack stack, World level, ServerWorld serverlevel, BlockState state, BlockPos pos, PlayerEntity EntityLiving) {
    	Block block = state.getBlock();
    	int a [] = {-1,0,1};
    	for(int ax = 0; ax < 3; ax++) {
    		for(int az = 0; az < 3; az++) {
    			for(int ay = 0; ay < 3; ay++) {
    				BlockPos aPos = new BlockPos(pos.getX() + a[ax],pos.getY() + a[ay], pos.getZ() + a[az]);
    				if (level.getBlockState(aPos).getBlock().getHarvestTool(state)==block.getHarvestTool(state) && level.getBlockState(aPos).getBlock().canHarvestBlock(state, level, aPos, EntityLiving)==block.canHarvestBlock(state, level, aPos, EntityLiving) && modeInt2(stack)==1) {
    					level.destroyBlock(aPos, true, EntityLiving);
    				}
    			}
    		}
    	}
	    if (modeInt2(stack) == 0) {
	    	stack.setDamageValue( stack.getDamageValue());
	    }
	    if (modeInt2(stack) == 1) {
	    	stack.setDamageValue( stack.getDamageValue() -10);
	    	
	    }
	    if (modeInt(stack) == 0) {
	    	stack.setDamageValue( stack.getDamageValue());
	    }
	    if (modeInt(stack) == 1) {
	    	stack.setDamageValue( stack.getDamageValue() -2);
	    }
		return true;
	}
	
	
	public void modeChange(ItemStack stack) {
		
		if (stack.getTag() == null) {
			
			stack.setTag(new CompoundNBT());
		}
		stack.getTag().getInt("mode");
		
	}
	
	public void modeChange2(ItemStack stack) {
		
		if (stack.getTag() == null) {
			
			stack.setTag(new CompoundNBT());
		}
		stack.getTag().putInt("mode2", modeInt2(stack) < 1 ? modeInt2(stack) + 1 : 0);
		
	}
	
	private int modeInt(ItemStack stack) {
		
		if(stack.getTag() == null) {
			
			return 0;
		}
		return stack.getTag().getInt("mode");
	}
	
	
	private int modeInt2(ItemStack stack) {
		
		if(stack.getTag() == null) {
			
			return 0;
		}
		return stack.getTag().getInt("mode2");
	}
	
    @Override
    public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
	    switch (modeInt(stack)) {
	    
	   		case 0 : return 5;
	   		
	   		case 1 : return 2;
	   		
	   		case 2 : return 1;
	   		
	   		case 3 : return 0;
	    }
	    return 5;
    }
    
    public float getDestroySpeed(ItemStack stack, BlockState state) {
    	Material material = state.getMaterial();
	    switch (modeInt(stack)) {
	    
   		case 0 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 12.0F;
   		
   		case 1 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 15.0F;
   		
   		case 2 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 19.0F;
   		
   		case 3 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 22.0F;
	    }
        return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 12.0F;
    }
    
    public String modeName(ItemStack stack) {
	    switch (modeInt(stack)) {
	    
   		case 0 : return ".normal";
   		
   		case 1 : return ".super";
   		
   		case 2 : return ".extra";
   		
   		case 3 : return ".infinity";
	    }
	    return ".normal";
    	
    }
    public String modeName2(ItemStack stack) {
	    switch (modeInt(stack)) {
	    
   		case 0 : return "False";
   		
   		case 1 : return "True";
   		
	    }
	    return "false";
    	
    }

	public void appendHoverText(ItemStack stack, World level, List<ITextComponent> Tooltip, ITooltipFlag Flag) {
	   Tooltip.add(new TranslationTextComponent("dsco.atradseka.weapon.addition_damage.sekai_magic_lightning").withStyle(TextFormatting.YELLOW)
			  .append(new StringTextComponent(" +1.0").withStyle(TextFormatting.DARK_GRAY)));
	   Tooltip.add(new StringTextComponent(" ").withStyle(TextFormatting.WHITE));
	   Tooltip.add(new TranslationTextComponent(this.getDescriptionId() + modeName(stack)).withStyle(TextFormatting.WHITE));
	   Tooltip.add(new StringTextComponent("Mode " + modeName2(stack)).withStyle(TextFormatting.WHITE));
	   Tooltip.add(new TranslationTextComponent("dsco.atradseka.tool.efficiency").withStyle(TextFormatting.GRAY)
			   .append(new TranslationTextComponent(this.getDescriptionId() + modeName(stack) + ".efficiency").withStyle(TextFormatting.WHITE)));
	   Tooltip.add(new TranslationTextComponent("dsco.atradseka.tool.level").withStyle(TextFormatting.GRAY)
			   .append(new TranslationTextComponent(this.getDescriptionId() + modeName(stack) + ".level").withStyle(TextFormatting.WHITE)));
	   
	}

}
