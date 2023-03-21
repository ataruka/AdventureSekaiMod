package com.ataruka.atradsekamod.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ItemTierInit implements IItemTier {
	
	ELECTRITE(5, 3561, 12.0F, 5.0F, 15,Ingredient.of(ItemInit.ELECTRITE_INGOT.get()));
	
	private final int uses,level,enchantmentValue;
	private final float speed,damage;
	private final Ingredient repairIngredient;
	
	   private ItemTierInit(int Level, int Uses, float Speed, float Damage, int EnchantmentValue, Ingredient RepairIngredient) {
		      this.level = Level;
		      this.uses = Uses;
		      this.speed = Speed;
		      this.damage = Damage;
		      this.enchantmentValue = EnchantmentValue;
		      this.repairIngredient = RepairIngredient;
		   }
	
	public int getUses() { return this.uses; }

	public float getSpeed() { return this.speed;}

	public float getAttackDamageBonus() { return this.damage; }

	public int getLevel() { return this.level; }

	public int getEnchantmentValue() { return this.enchantmentValue; }

	public Ingredient getRepairIngredient() { return this.repairIngredient; }
	}

