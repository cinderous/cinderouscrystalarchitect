package com.cinderous.crystalarchitect.util;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.blocks.*;
import com.cinderous.crystalarchitect.containers.ExperimentBoxContainer;

import com.cinderous.crystalarchitect.containers.HyperlaneFurnaceContainer;
import com.cinderous.crystalarchitect.containers.MultiboxChestContainer;
import com.cinderous.crystalarchitect.effects.CinderbanedEffect;
import com.cinderous.crystalarchitect.effects.HyperlaneEffect;
import com.cinderous.crystalarchitect.entities.Cinderling;
import com.cinderous.crystalarchitect.entities.HyperlanePhantom;
import com.cinderous.crystalarchitect.items.CinderbanePoisonPotion;
import com.cinderous.crystalarchitect.items.CinderiteDust;
import com.cinderous.crystalarchitect.items.HyperlaneBaseItem;
import com.cinderous.crystalarchitect.items.ItemBase;
//import com.cinderous.crystalarchitect.particles.ColouredParticle;
import com.cinderous.crystalarchitect.tileentities.ExperimentBoxTileEntity;

import com.cinderous.crystalarchitect.tileentities.HyperlaneFurnaceTileEntity;
import com.cinderous.crystalarchitect.tileentities.MultiboxChestTileEntity;
import com.cinderous.crystalarchitect.tileentities.SolutionTankTileEntity;
import com.cinderous.crystalarchitect.util.enums.ModItemTiers;
import com.cinderous.crystalarchitect.world.biomes.CinderbaneBiome;
import com.cinderous.crystalarchitect.world.biomes.HyperlaneDrifts;
import com.cinderous.crystalarchitect.world.biomes.HyperlaneDriftsSurfaceBuilder;
import com.cinderous.crystalarchitect.world.dimensions.CinderbaneModDimension;
import com.cinderous.crystalarchitect.world.dimensions.HyperlaneModDimension;
import com.cinderous.crystalarchitect.world.feature.CinderwoodTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {


    public static final ResourceLocation COBBLESTONE_SOLUTION_STILL_RL = new ResourceLocation(CrystalArchitect.MOD_ID,
            "blocks/cobblestone_solution_still");
    public static final ResourceLocation COBBLESTONE_SOLUTION_FLOWING_RL = new ResourceLocation(CrystalArchitect.MOD_ID,
            "blocks/cobblestone_solution_flow");
    public static final ResourceLocation COBBLESTONE_SOLUTION_OVERLAY_RL = new ResourceLocation(CrystalArchitect.MOD_ID,
            "blocks/cobblestone_solution_overlay");

    //public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, CrystalArchitect.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.CONTAINERS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS, CrystalArchitect.MOD_ID);
    public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, CrystalArchitect.MOD_ID);

    //public static final DeferredRegister<Gui<?>> GUI = new DeferredRegister<>(ForgeRegistries.CONTAINERS, CrystalArchitect.MOD_ID);


    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, CrystalArchitect.MOD_ID);
    //


    public static void init() {
       // PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTION_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINER_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());


        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());




    }



    //Items
    public static final RegistryObject<Item> CINDERIUM_INGOT = ITEMS.register("cinderium_ingot", ItemBase::new);
    public static final RegistryObject<Item> CINDERITE_DUST = ITEMS.register("cinderite_dust", CinderiteDust::new);
    public static final RegistryObject<Item> CINDERFLUX = ITEMS.register("cinderflux", ItemBase::new);

    //POTION ITEMS
    public static final RegistryObject<PotionItem> CINDERBANE_POTION_BOTTLE = ITEMS.register("cinderbane_potion_bottle", CinderbanePoisonPotion::new);



    //potion effects
    public static final RegistryObject<Effect> CINDERBANED_EFFECT = POTIONS.register("cinderbaned_effect",
            () -> new CinderbanedEffect(EffectType.BENEFICIAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<Effect> HYPERLANE_EFFECT = POTIONS.register("hyperlane_effect",
            () -> new HyperlaneEffect(EffectType.NEUTRAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));
    //potions
    public static final RegistryObject<Potion> CINDERBANE_POTION = POTION_EFFECTS.register("cinderbane_potion",
            () -> new Potion(new EffectInstance(CINDERBANED_EFFECT.get())));

    //Tool Items
    public static final RegistryObject<AxeItem> SHARPENED_CINDERITE_ROCK = ITEMS.register("sharpened_cinderite_rock",
            () -> new AxeItem( ModItemTiers.SHARPENED_CINDERITE_ROCK_CONFIG, 6.0F, -3.2f, new Item.Properties().group(CrystalArchitect.TAB)));

    public static final RegistryObject<BucketItem> CINDERLING_SHELL = ITEMS.register("cinderling_shell",
            () -> new BucketItem(Fluids.EMPTY, new Item.Properties().group(CrystalArchitect.TAB)));

    public static final RegistryObject<BucketItem> CINDERLING_SHELL_WATER = ITEMS.register("cinderling_shell_water",
            () -> new BucketItem(Fluids.WATER, new Item.Properties().group(CrystalArchitect.TAB)));

    public static final RegistryObject<BucketItem> CINDERLING_SHELL_COBBLESTONE_SOLUTION = ITEMS.register("cinderling_shell_cobblestone_solution",
            () -> new BucketItem(RegistryHandler.COBBLESTONE_SOLUTION_FLUID, new Item.Properties().group(CrystalArchitect.TAB)));

    //hyperlanetools
    //public static final RegistryObject<HyperlaneBaseItem> HYPERLANE_BASIC_TELEPORTER = ITEMS.register("hyperlane_basic_teleporter", HyperlaneBaseItem::new);

    //fluids
    public static final RegistryObject<FlowingFluid> COBBLESTONE_SOLUTION_FLUID = FLUIDS.register("cobblestone_solution_fluid",
            () -> new ForgeFlowingFluid.Source(RegistryHandler.COBBLESTONE_SOLUTION_PROPERTIES));

    public static final RegistryObject<FlowingFluid> COBBLESTONE_SOLUTION_FLOWING = FLUIDS.register("cobblestone_solution_flowing",
            () -> new ForgeFlowingFluid.Flowing(RegistryHandler.COBBLESTONE_SOLUTION_PROPERTIES));

    public static final ForgeFlowingFluid.Properties COBBLESTONE_SOLUTION_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> COBBLESTONE_SOLUTION_FLUID.get(), () -> COBBLESTONE_SOLUTION_FLOWING.get(),
            FluidAttributes.builder(COBBLESTONE_SOLUTION_STILL_RL, COBBLESTONE_SOLUTION_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE).color(13158600)
                    .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(COBBLESTONE_SOLUTION_OVERLAY_RL))
            .block(() -> RegistryHandler.COBBLESTONE_SOLUTION_BLOCK.get());

    public static final RegistryObject<FlowingFluidBlock> COBBLESTONE_SOLUTION_BLOCK = RegistryHandler.BLOCKS.register("milk",
            () -> new FlowingFluidBlock(() -> RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get(), Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));



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


    public static final RegistryObject<Block> MULTIBOX_CHEST = BLOCKS.register("multibox_chest", MultiboxChest::new);

    public static final RegistryObject<Block> EXPERIMENT_BOX = BLOCKS.register("experiment_box", ExperimentBox::new);

    public static final RegistryObject<Block> SOLUTION_TANK = BLOCKS.register("solution_tank", SolutionTank::new);

    public static final RegistryObject<Block> HYPERLANE_GEL_BLOCK = BLOCKS.register("hyperlane_gel_block", HyperlaneGelBlock::new);

    public static final RegistryObject<Block> HYPERLANE_GEL_SLAB = BLOCKS.register("hyperlane_gel_slab",
            () -> new SlabBlock(Block.Properties.from(RegistryHandler.HYPERLANE_GEL_BLOCK.get())));

    public static final RegistryObject<Block> HYPERLANE_GRAVEL = BLOCKS.register("hyperlane_gravel", HyperlaneGravel::new);

    public static final RegistryObject<Block> HYPERLANE_FURNACE = BLOCKS.register("hyperlane_furnace", HyperlaneFurnace::new);



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
    public static final RegistryObject<Item> EXPERIMENT_BOX_ITEM = ITEMS.register("experiment_box", () -> new BlockItemBase(EXPERIMENT_BOX.get()));
    public static final RegistryObject<Item> MULTIBOX_CHEST_ITEM = ITEMS.register("multibox_chest", () -> new BlockItemBase(MULTIBOX_CHEST.get()));
    public static final RegistryObject<Item> SOLUTION_TANK_ITEM = ITEMS.register("solution_tank", () -> new BlockItemBase(SOLUTION_TANK.get()));
    public static final RegistryObject<Item> HYPERLANE_GEL_BLOCK_ITEM = ITEMS.register("hyperlane_gel_block", () -> new BlockHyperlaneBase(HYPERLANE_GEL_BLOCK.get()));
    public static final RegistryObject<Item> HYPERLANE_GEL_SLAB_ITEM = ITEMS.register("hyperlane_gel_slab", () -> new BlockHyperlaneBase(HYPERLANE_GEL_SLAB.get()));
    public static final RegistryObject<Item> HYPERLANE_GRAVEL_ITEM = ITEMS.register("hyperlane_gravel", () -> new BlockHyperlaneBase(HYPERLANE_GRAVEL.get()));
    public static final RegistryObject<Item> HYPERLANE_FURNACE_ITEM = ITEMS.register("hyperlane_furnace", () -> new BlockHyperlaneBase(HYPERLANE_FURNACE.get()));

    //entities
    public static final RegistryObject<EntityType<Cinderling>> CINDERLING = ENTITY_TYPES
            .register("cinderling",
                    () -> EntityType.Builder.<Cinderling>create(Cinderling::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(CrystalArchitect.MOD_ID, "cinderling").toString()));

    public static final RegistryObject<EntityType<HyperlanePhantom>> HYPERLANE_PHANTOM = ENTITY_TYPES
            .register("hyperlane_phantom",
                    () -> EntityType.Builder.<HyperlanePhantom>create(HyperlanePhantom::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(CrystalArchitect.MOD_ID, "hyperlane_phantom").toString()));



    //tile entities

    public static final RegistryObject<TileEntityType<ExperimentBoxTileEntity>> EXPERIMENT_BOX_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("experiment_box", () -> TileEntityType.Builder
                    .create(ExperimentBoxTileEntity::new, RegistryHandler.EXPERIMENT_BOX.get()).build(null));

    public static final RegistryObject<TileEntityType<MultiboxChestTileEntity>> MULTIBOX_CHEST_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("multiblock_chest", () -> TileEntityType.Builder
                    .create(MultiboxChestTileEntity::new, RegistryHandler.MULTIBOX_CHEST.get()).build(null));

    public static final RegistryObject<TileEntityType<SolutionTankTileEntity>> SOLUTION_TANK_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("solution_tank", () -> TileEntityType.Builder
                    .create(SolutionTankTileEntity::new, RegistryHandler.SOLUTION_TANK.get()).build(null));

//    public static final RegistryObject<TileEntityType<HyperlaneBasicTeleporterTileEntity>> HYPERLANE_BASIC_TELEPORTER_TILE_ENTITY = TILE_ENTITY_TYPES
//            .register("hyperlane_basic_teleporter", () -> TileEntityType.Builder
//                    .create(HyperlaneBasicTeleporterTileEntity::new, RegistryHandler.HYPERLANE_BASIC_TELEPORTER.get()).build(null));

    public static final RegistryObject<TileEntityType<HyperlaneFurnaceTileEntity>> HYPERLANE_FURNACE_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("hyperlane_furnace", () -> TileEntityType.Builder
                    .create(HyperlaneFurnaceTileEntity::new, RegistryHandler.HYPERLANE_FURNACE.get()).build(null));



    //containers

    public static final RegistryObject<ContainerType<ExperimentBoxContainer>> EXPERIMENT_BOX_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("experiment_box_container", () -> IForgeContainerType.create(ExperimentBoxContainer::new));

    public static final RegistryObject<ContainerType<MultiboxChestContainer>> MULTIBOX_CHEST_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("multibox_chest_container", () -> IForgeContainerType.create(MultiboxChestContainer::new));

//    public static final RegistryObject<ContainerType<HyperlaneBasicTeleporterContainer>> HYPERLANE_BASIC_TELEPORTER_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
//            .register("hyperlane_basic_teleporter_container", () -> IForgeContainerType.create(HyperlaneBasicTeleporterContainer::new));

    public static final RegistryObject<ContainerType<HyperlaneFurnaceContainer>> HYPERLANE_FURNACE_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("hyperlane_furance_container", () -> IForgeContainerType.create(HyperlaneFurnaceContainer::new));


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
    public static final RegistryObject<Biome> HYPERLANE_DRIFTS = BIOMES.register("hyperlane_drifts",
            () -> new HyperlaneDrifts(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16777215).waterFogColor(16777215)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState()))
                    .category(Biome.Category.ICY)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));

    public static void registerBiomes(){
        registerBiome(CINDERBANE.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(HYPERLANE_DRIFTS.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    //dimensions
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, CrystalArchitect.MOD_ID);
    public static final RegistryObject<ModDimension> CINDERBANE_DIM = MOD_DIMENSIONS.register("cinderbane_dim", () -> new CinderbaneModDimension());

    public static final RegistryObject<ModDimension> HYPERLANE_DIM = MOD_DIMENSIONS.register("hyperlane_dim", () -> new HyperlaneModDimension());



////effects
//public static final RegistryObject<Effect> CINDERBANED_EFFECT = POTIONS.register("cinderbaned_effect",
//        () -> new CinderbanedEffect(EffectType.HARMFUL, 37848743).addAttributesModifier(
//                SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
//                AttributeModifier.Operation.ADDITION));

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
