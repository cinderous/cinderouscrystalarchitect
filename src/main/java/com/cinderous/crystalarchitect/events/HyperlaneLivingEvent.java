package com.cinderous.crystalarchitect.events;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrystalArchitect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyperlaneLivingEvent {

    @SubscribeEvent
    public static void HyperlaneLivingEvent(LivingEvent event) {
    LivingEntity livingEntity = event.getEntityLiving();
    World world = livingEntity.getEntityWorld();
        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null) {
            livingEntity.setGlowing(true);
            if (world.getBlockState(livingEntity.getPosition()) == Blocks.AIR.getDefaultState() || world.getBlockState(livingEntity.getPosition()) == Blocks.WATER.getDefaultState()) {
                CrystalArchitect.LOGGER.info("HYPERLANE GEL BEING ADDED BELOW PLAYER");
                world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
            }


        }
//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension().getType() == DimensionType.OVERWORLD) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF BECAUSE HYPERLANE EFFECT ISNT NULL AND THE DIMENSIONTYPE IS OVERWORLD");
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension() == RegistryHandler.HYPERLANE_DIM.get().getFactory()) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF BECAUSE HYPERLANE EFFECT ISNT NULL AND THE DIMENSIONTYPE IS HYPERLANE");
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if(world.getDimension().getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF!!!");
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//        }



//        if (world.getDimension().getType() == RegistryHandler.HYPERLANE_DIM.get().getFactory() ) {
//            //livingEntity.setGlowing(true);
//        }
    }
}