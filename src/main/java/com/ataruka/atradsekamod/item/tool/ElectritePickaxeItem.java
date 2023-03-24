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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

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
		Item item = this.getItem();
		ItemStack stacks = player.getItemInHand(Hand.MAIN_HAND); 
		if(AdsekaKeyBind.adsekaKey[0].consumeClick() && player.getItemInHand(hand).getItem() == item) {
			player.setItemInHand(hand, stack);
			modeChange2(stack);
			player.sendMessage((new StringTextComponent("MultiMode " + modeName2(stack)).withStyle(TextFormatting.WHITE)), player.getUUID());
		}  
		if (stacks.getDamageValue() >= stacks.getMaxDamage() && player.getItemInHand(hand).getItem() == item) {
			player.broadcastBreakEvent(Hand.MAIN_HAND);
			player.awardStat(Stats.ITEM_BROKEN.get(item));
			stacks.setCount(0);
		}

	}
	
	public boolean mineBlock(ItemStack stack, World level, BlockState state, BlockPos pos, LivingEntity EntityLiving) {
		PlayerEntity player = (PlayerEntity) EntityLiving;
		System.out.println(stack.getItem().getHarvestLevel(stack, ToolType.PICKAXE, player, state));
    	Block block = state.getBlock();
    	Item item = this.getItem();
    	int a [] = {-1,0,1};
    	for(int ax = 0; ax < 3; ax++) {
    		for(int az = 0; az < 3; az++) {
    			for(int ay = 0; ay < 3; ay++) {
    				BlockPos aPos = new BlockPos(pos.getX() + a[ax],pos.getY() + a[ay], pos.getZ() + a[az]);
    				if (level.getBlockState(aPos).getBlock().getHarvestTool(state)==block.getHarvestTool(state) && block.getHarvestTool(state) == ToolType.PICKAXE && level.getBlockState(aPos).getBlock().getHarvestLevel(state)<= stack.getItem().getHarvestLevel(stack, ToolType.PICKAXE, player, state) && modeInt2(stack)==1 && !player.isShiftKeyDown()) {
    					level.destroyBlock(aPos, true, EntityLiving);
    					player.awardStat(Stats.ITEM_USED.get(item));
    					player.awardStat(Stats.BLOCK_MINED.get(level.getBlockState(aPos).getBlock()));
    				    if (modeInt(stack) == 0) {
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    }
    				    if (modeInt(stack) == 1) {
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    }
    				    if (modeInt(stack) == 2) {
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    }
    				    if (modeInt(stack) == 3) {
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    	stack.setDamageValue( stack.getDamageValue() +1);
    				    }
    			}}}
	    if (modeInt(stack) == 0) {
	    	stack.setDamageValue( stack.getDamageValue() +1);
		    }
	    }
	    if (modeInt(stack) == 1) {
	    	stack.setDamageValue( stack.getDamageValue() +1);

	    }
	    if (modeInt(stack) == 2) {
	    	stack.setDamageValue( stack.getDamageValue() +1);
	    	stack.setDamageValue( stack.getDamageValue() +1);
	    	
	    }
	    if (modeInt(stack) == 3) {
	    	stack.setDamageValue( stack.getDamageValue() +1);
	    	stack.setDamageValue( stack.getDamageValue() +1);
	    	stack.setDamageValue( stack.getDamageValue() +1);
	    }
		return true;
	}
	
	public void modeChange(ItemStack stack) {
		
		if (stack.getTag() == null) {
			
			stack.setTag(new CompoundNBT());
		}
		stack.getTag().putInt("mode", modeInt(stack) < 3 ? modeInt(stack) + 1 : 0);
		
	}
	
	public void modeChange2(ItemStack stack) {
		
		if (stack.getTag() == null) {
			
			stack.setTag(new CompoundNBT());
		}
		stack.getTag().putInt("mode2", modeInt2(stack) == 0 ? modeInt2(stack) + 1 : 0);
		
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
	    
   		case 0 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 10.0F;
   		
   		case 1 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 14.0F;
   		
   		case 2 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 19.0F;
   		
   		case 3 : return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 24.0F;
	    }
        return material != Material.METAL && material != Material.HEAVY_METAL && material != Material.STONE ? super.getDestroySpeed(stack,state) : 10.0F;
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
	    switch (modeInt2(stack)) {
	    
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
