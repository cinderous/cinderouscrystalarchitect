package com.cinderous.crystalarchitect.util;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.blocks.*;
import com.cinderous.crystalarchitect.entities.Cinderling;
import com.cinderous.crystalarchitect.items.CinderiteDust;
import com.cinderous.crystalarchitect.items.ItemBase;
//import com.cinderous.crystalarchitect.particles.ColouredParticle;
import com.cinderous.crystalarchitect.util.enums.ModItemTiers;
import com.cinderous.crystalarchitect.world.biomes.CinderbaneBiome;
import com.cinderous.crystalarchitect.world.feature.CinderwoodTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class RegistryHandler {

    //public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, CrystalArchitect.MOD_ID);


    public static void init() {
       // PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());


    }



    //Items
    public static final RegistryObject<Item> CINDERIUM_INGOT = ITEMS.register("cinderium_ingot", ItemBase::new);
    public static final RegistryObject<Item> CINDERITE_DUST = ITEMS.register("cinderite_dust", CinderiteDust::new);

    //Tool Items
    public static final RegistryObject<AxeItem> SHARPENED_CINDERITE_ROCK = ITEMS.register("sharpened_cinderite_rock",
            () -> new AxeItem( ModItemTiers.SHARPENED_CINDERITE_ROCK_CONFIG, 6.0F, -3.2f, new Item.Properties().group(CrystalArchitect.TAB)));

    //blocks
    public static final RegistryObject<Block> CINDERIUM_BLOCK = BLOCKS.register("cinderium_block", CinderiumBlock::new);
    public static final RegistryObject<Block> CINDERITE_STONE = BLOCKS.register("cinderite_stone", CinderiteStone::new);

    public static final RegistryObject<Block> CINDERITE_ROCK = BLOCKS.register("cinderite_rock", CinderiteRock::new);

    public static final RegistryObject<Block> CINDERITE_MULCH = BLOCKS.register("cinderite_mulch", CinderiteMulch::new);

    public static final RegistryObject<Block> CINDIRT = BLOCKS.register("cindirt",
            () -> new Block(Block.Properties.from(Blocks.DIRT)));

    public static final RegistryObject<Block> CINDIRT_GRASS = BLOCKS.register("cindirt_grass", CindirtGrass::new);





    public static final RegistryObject<Block> CINDERWOOD_PLANKS = BLOCKS.register("cinderwood_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CINDERWOOD_LOG = BLOCKS.register("cinderwood_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINDERWOOD_LEAVES = BLOCKS.register("cinderwood_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> CINDERWOOD_SAPLING = BLOCKS.register("cinderwood_sapling",
            () -> new CinderwoodSapling(() -> new CinderwoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));


    //block items
    public static final RegistryObject<Item> CINDERIUM_BLOCK_ITEM = ITEMS.register("cinderium_block", () -> new BlockItemBase(CINDERIUM_BLOCK.get()));
    public static final RegistryObject<Item> CINDERITE_STONE_ITEM = ITEMS.register("cinderite_stone", () -> new BlockItemBase(CINDERITE_STONE.get()));
    public static final RegistryObject<Item> CINDERITE_ROCK_ITEM = ITEMS.register("cinderite_rock", () -> new BlockItemBase(CINDERITE_ROCK.get()));
    public static final RegistryObject<Item> CINDERITE_MULCH_ITEM = ITEMS.register("cinderite_mulch", () -> new BlockItemBase(CINDERITE_MULCH.get()));
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItemBase(CINDIRT.get()));
    public static final RegistryObject<Item> CINDIRT_GRASS_ITEM = ITEMS.register("cindirt_grass", () -> new BlockItemBase(CINDIRT_GRASS.get()));

    public static final RegistryObject<Item> CINDERWOOD_PLANKS_ITEM = ITEMS.register("cinderwood_planks", () -> new BlockItemBase(CINDERWOOD_PLANKS.get()));
    public static final RegistryObject<Item> CINDERWOOD_LOG_ITEM = ITEMS.register("cinderwood_log", () -> new BlockItemBase(CINDERWOOD_LOG.get()));
    public static final RegistryObject<Item> CINDERWOOD_LEAVES_ITEM = ITEMS.register("cinderwood_leaves", () -> new BlockItemBase(CINDERWOOD_LEAVES.get()));
    public static final RegistryObject<Item> CINDERWOOD_SAPLING_ITEM = ITEMS.register("cinderwood_sapling", () -> new BlockItemBase(CINDERWOOD_SAPLING.get()));

    //entities
    public static final RegistryObject<EntityType<Cinderling>> CINDERLING = ENTITY_TYPES
            .register("cinderling",
                    () -> EntityType.Builder.<Cinderling>create(Cinderling::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(CrystalArchitect.MOD_ID, "example_entity").toString()));


    //sounds
    public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity.cinderling.ambient",
            () -> new SoundEvent(new ResourceLocation(CrystalArchitect.MOD_ID, "entity.cinderling.ambient")));

    //biomes
    public static final RegistryObject<Biome> CINDERBANE = BIOMES.register("cinderbane_biome",
            () -> new CinderbaneBiome(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16762304).waterFogColor(66762304)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.CINDIRT_GRASS.get().getDefaultState(),
                                    RegistryHandler.CINDIRT.get().getDefaultState(),
                                    RegistryHandler.CINDERITE_STONE.get().getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)
            ));

    public static void registerBiomes(){
        registerBiome(CINDERBANE.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }


    //particles


//    public static final RegistryObject<ParticleType<ColouredParticle.ColouredParticleData>> COLOURED_PARTICLE = PARTICLE_TYPES.register(
//            "coloured_particle",
//            () -> new ParticleType<ColouredParticle.ColouredParticleData>(false, ColouredParticle.ColouredParticleData.DESERIALIZER));
//
//    @SuppressWarnings("resource")
//    @SubscribeEvent
//    public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
//        Minecraft.getInstance().particles.registerFactory(RegistryHandler.COLOURED_PARTICLE.get(),
//                ColouredParticle.Factory::new);
//    }
}
