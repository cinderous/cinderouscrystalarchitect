package com.cinderous.crystalarchitect.util;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.client.entity.model.render.CinderlingRender;
import com.cinderous.crystalarchitect.client.entity.model.render.HyperlanePhantomRender;
import com.cinderous.crystalarchitect.client.gui.ExperimentBoxScreen;
import com.cinderous.crystalarchitect.client.gui.HyperlaneFurnaceScreen;
import com.cinderous.crystalarchitect.client.gui.MultiboxChestScreen;
import com.cinderous.crystalarchitect.entities.Cinderling;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CrystalArchitect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERWOOD_SAPLING.get(), RenderType.getCutout());

        ScreenManager.registerFactory(RegistryHandler.EXPERIMENT_BOX_CONTAINER.get(), ExperimentBoxScreen::new);
        ScreenManager.registerFactory(RegistryHandler.MULTIBOX_CHEST_CONTAINER.get(), MultiboxChestScreen::new);

        ScreenManager.registerFactory(RegistryHandler.HYPERLANE_FURNACE_CONTAINER.get(), HyperlaneFurnaceScreen::new);


        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.CINDERLING.get(), CinderlingRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HYPERLANE_PHANTOM.get(), HyperlanePhantomRender::new);
    }
}
