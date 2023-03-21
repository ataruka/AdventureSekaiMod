package com.ataruka.atradsekamod.init;

import com.ataruka.atradsekamod.AdventureSekaiMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class AdsekaDamageSource {
	public static DamageSource mobSekai_Magic(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic", Mob);
	}
	public static DamageSource mobSekai_Magic_Lightning(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Lightning", Mob);
	}
	public static DamageSource mobSekai_Magic_Fire(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Fire", Mob);
	}
	public static DamageSource mobSekai_Magic_Water(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Water", Mob);
	}
	public static DamageSource mobSekai_Magic_Explosion(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Explosion", Mob);
	}
	public static DamageSource mobSekai_Magic_Abyss(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Abyss", Mob);
	}
	public static DamageSource mobSekai_Magic_Wind(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Wind", Mob);
	}
	public static DamageSource mobSekai_Physics(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Physics", Mob);
	}
	public static DamageSource mobSekai_Magic_Reflection(LivingEntity Mob) {
		return new EntityDamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Reflection", Mob);
	}
	public static final DamageSource SEKAI_MAGIC = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic"));
	public static final DamageSource SEKAI_MAGIC_LIGHTNING = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Lightning"));
	public static final DamageSource SEKAI_MAGIC_FIRE = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Fire"));
	public static final DamageSource SEKAI_MAGIC_WATER = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Water"));
	public static final DamageSource SEKAI_MAGIC_EXPLOSION = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Explosion"));
	public static final DamageSource SEKAI_MAGIC_ABYSS = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Abyss"));
	public static final DamageSource SEKAI_MAGIC_WIND = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Wind"));
	public static final DamageSource SEKAI_PHYSICS = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Physics"));
	
	public static final DamageSource SEKAI_REFLECTION = (new DamageSource(AdventureSekaiMod.MOD_ID + "sekai_Magic_Reflection"));
}
