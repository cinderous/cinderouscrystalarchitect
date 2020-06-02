package com.cinderous.crystalarchitect.world.biomes;

import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.cinderous.crystalarchitect.world.feature.CinderwoodTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class HyperlaneDrifts  extends Biome {

//    public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(
//            new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK.get().getDefaultState()), new SimpleBlockPlacer())).tries(5).build();
    //  public static final BlockClusterFeatureConfig SNOWDONIA_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SnowdoniaFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    public HyperlaneDrifts(Biome.Builder biomeBuilder) {
        super(biomeBuilder);


        //broke
        //addSpawn(EntityClassification.CREATURE, new SpawnListEntry(RegistryHandler.CINDERLING.get(), 10,5,10));
        //addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.01f)));
        //addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));

//        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
//                Feature.NORMAL_TREE.withConfiguration(CinderwoodTree.CINDERWOOD_TREE_CONFIG).withPlacement(
//                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));

//        DefaultBiomeFeatures.addOres(this);
//        DefaultBiomeFeatures.addSparseGrass(this);
        //DefaultBiomeFeatures.addStructures();


        //public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK), new SimpleBlockPlacer())).tries(32).build();

        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CINDERITE_ROCK_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    }
}