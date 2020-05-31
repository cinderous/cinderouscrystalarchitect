package com.cinderous.crystalarchitect.util;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrystalArchitect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(CrystalArchitect.CINDERBANE_DIM_TYPE, RegistryHandler.CINDERBANE_DIM.get(), null,
                    true);
        }
        CrystalArchitect.LOGGER.info("Dimensions Registered!");
    } 
}