package com.ataruka.atradsekamod.init;

import com.ataruka.atradsekamod.AdventureSekaiMod;
import com.ataruka.atradsekamod.init.keybind.AdsekaKeyBind;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AdventureSekaiMod.MOD_ID , bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		AdsekaKeyBind.register(event);
	}
}
