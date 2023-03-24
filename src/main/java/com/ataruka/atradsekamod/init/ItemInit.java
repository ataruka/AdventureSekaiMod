package com.ataruka.atradsekamod.init;

import com.ataruka.atradsekamod.AdventureSekaiMod;
import com.ataruka.atradsekamod.item.food.PoppyDeuceItem;
import com.ataruka.atradsekamod.item.meta.BossCoreItem;
import com.ataruka.atradsekamod.item.meta.HeatedCoreItem;
import com.ataruka.atradsekamod.item.meta.IncompleteCoreItem;
import com.ataruka.atradsekamod.item.ore.ElectricRedstoneItem;
import com.ataruka.atradsekamod.item.ore.ElectriteIngotItem;
import com.ataruka.atradsekamod.item.tool.ElectriteAxeItem;
import com.ataruka.atradsekamod.item.tool.ElectriteHoeItem;
import com.ataruka.atradsekamod.item.tool.ElectritePickaxeItem;
import com.ataruka.atradsekamod.item.tool.ElectriteShovelItem;
import com.ataruka.atradsekamod.item.weapon.DiamondDaggerItem;
import com.ataruka.atradsekamod.item.weapon.ElectriteDaggerItem;
import com.ataruka.atradsekamod.item.weapon.ElectriteSwordItem;
import com.ataruka.atradsekamod.item.weapon.GoldenDaggerItem;
import com.ataruka.atradsekamod.item.weapon.IronDaggerItem;
import com.ataruka.atradsekamod.item.weapon.NetheriteDaggerItem;
import com.ataruka.atradsekamod.item.weapon.StoneDaggerItem;
import com.ataruka.atradsekamod.item.weapon.WoodenDaggerItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
 
 public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,AdventureSekaiMod.MOD_ID);
 
 public static final RegistryObject<Item> BOSS_CORE = ITEMS.register("boss_core", () -> new BossCoreItem());
 public static final RegistryObject<Item> Heated_CORE = ITEMS.register("heated_core", () -> new HeatedCoreItem());
 public static final RegistryObject<Item> INCOMPLETE_CORE = ITEMS.register("incomplete_core", () -> new IncompleteCoreItem());
 public static final RegistryObject<Item> ELECTRIC_REDSTONE = ITEMS.register("electric_redstone", () -> new ElectricRedstoneItem());
 public static final RegistryObject<Item> ELECTRITE_INGOT = ITEMS.register("electrite_ingot", () -> new ElectriteIngotItem());
 
 public static final RegistryObject<Item> POPPY_DEUCE = ITEMS.register("poppy_deuce", () -> new PoppyDeuceItem());
 
 public static final RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger", () -> new WoodenDaggerItem());
 public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger", () -> new StoneDaggerItem());
 public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger", () -> new IronDaggerItem());
 public static final RegistryObject<Item> GOLDEN_DAGGER = ITEMS.register("golden_dagger", () -> new GoldenDaggerItem());
 public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger", () -> new DiamondDaggerItem());
 public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger", () -> new NetheriteDaggerItem());
 public static final RegistryObject<Item> ELECTRITE_DAGGER = ITEMS.register("electrite_dagger", () -> new ElectriteDaggerItem());
 
 public static final RegistryObject<Item> ELECTRITE_SWORD = ITEMS.register("electrite_sword", () -> new ElectriteSwordItem());
 public static final RegistryObject<Item> ELECTRITE_PICKAXE = ITEMS.register("electrite_pickaxe", () -> new ElectritePickaxeItem());
 public static final RegistryObject<Item> ELECTRITE_AXE = ITEMS.register("electrite_axe", () -> new ElectriteAxeItem());
 public static final RegistryObject<Item> ELECTRITE_SHOVEL = ITEMS.register("electrite_shovel", () -> new ElectriteShovelItem());
 public static final RegistryObject<Item> ELECTRITE_HOE = ITEMS.register("electrite_hoe", () -> new ElectriteHoeItem());
 
 public static final RegistryObject<Item> SOLID_COAL_BLOCK = ITEMS.register("solid_coal_block",
			() -> new BlockItem(BlockInit.SOLID_COAL_BLOCK.get(),new Properties().tab(ItemGroupInit.ATRADSEKA_MOD)) {
				@Override
				public int getBurnTime(ItemStack itemstack) {
					return 160000;
				}
			});
 public static final RegistryObject<Item> ELECTRIC_REDSTONE_ORE = ITEMS.register("electric_redstone_ore",
			() -> new BlockItem(BlockInit.ELECTRIC_REDSTONE_ORE.get(),new Properties().tab(ItemGroupInit.ATRADSEKA_MOD)));
}