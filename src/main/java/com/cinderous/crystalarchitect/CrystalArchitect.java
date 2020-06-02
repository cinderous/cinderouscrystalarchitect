package com.cinderous.crystalarchitect;

import com.cinderous.crystalarchitect.entities.Cinderling;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("crystalarchitect")
@Mod.EventBusSubscriber(modid = CrystalArchitect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CrystalArchitect
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "crystalarchitect";
    public static final ResourceLocation CINDERBANE_DIM_TYPE = new ResourceLocation(MOD_ID, "cinderbane");
    public static final ResourceLocation HYPERLANE_DIM_TYPE = new ResourceLocation(MOD_ID, "hyperlane");

    public CrystalArchitect() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Cinderling.registerPlacementTypes();
        registerEntityWorldSpawn(RegistryHandler.CINDERLING.get(), 15, 1, 6,
                RegistryHandler.CINDERBANE.get());
        LOGGER.info("FML common completed???");
    }

    private void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes) {
        for(Biome biome : biomes) {
            if(biome !=null) {
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
                LOGGER.info("Did this work DAMN");
            }

        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    public static final ItemGroup TAB = new ItemGroup("crystalarchitectTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.CINDERIUM_INGOT.get());
        }

    };
    public static final ItemGroup HYPERLANE_TAB = new ItemGroup("hyperlaneTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.HYPERLANE_GEL_BLOCK_ITEM.get());
        }

    };

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        RegistryHandler.registerBiomes();
    }


}
