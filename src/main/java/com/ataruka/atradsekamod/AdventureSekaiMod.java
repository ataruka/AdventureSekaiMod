package com.ataruka.atradsekamod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ataruka.atradsekamod.init.BlockInit;
import com.ataruka.atradsekamod.init.ItemInit;
import com.ataruka.atradsekamod.world.Generation;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AdventureSekaiMod.MOD_ID)
public class AdventureSekaiMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "atradseka";

    public AdventureSekaiMod() {
        // Register the setup method for modloading
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, Generation::addOres);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
