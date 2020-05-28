package com.cinderous.crystalarchitect.world.biomes;

import com.cinderous.crystalarchitect.entities.Cinderling;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.cinderous.crystalarchitect.world.feature.CinderwoodTree;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class CinderbaneBiome extends Biome {

    public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK.get().getDefaultState()), new SimpleBlockPlacer())).tries(64).build();
  //  public static final BlockClusterFeatureConfig SNOWDONIA_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SnowdoniaFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    public CinderbaneBiome(Builder biomeBuilder) {
        super(biomeBuilder);



        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(RegistryHandler.CINDERLING.get(), 200,5,10));
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.04f)));
        //addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(CinderwoodTree.CINDERWOOD_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSparseGrass(this);


        //public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK), new SimpleBlockPlacer())).tries(32).build();

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CINDERITE_ROCK_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    }
}
