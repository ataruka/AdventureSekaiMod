package com.ataruka.atradsekamod.init.keybind;

import java.awt.event.KeyEvent;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
public class AdsekaKeyBind {

	public static KeyBinding[] adsekaKey;
	
	public static void register(final FMLClientSetupEvent event) {
		adsekaKey = new KeyBinding[1];
		
		adsekaKey[0] = crate("modechange", KeyEvent.VK_V);
		
		for (int a = 0; a < adsekaKey.length; a++) {
			ClientRegistry.registerKeyBinding(adsekaKey[a]);
		}
	}
	
	private static KeyBinding crate (String name,int key) {
		return new KeyBinding("key.adsekamod." + name , key , "key.category.adsekamod");
	}
}
