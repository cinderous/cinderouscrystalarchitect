package com.cinderous.crystalarchitect.world.dimensions;

import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class HyperlaneDimensionBiomeProvider  extends BiomeProvider {

    private Random rand;

    public HyperlaneDimensionBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(RegistryHandler.HYPERLANE_DRIFTS.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return RegistryHandler.HYPERLANE_DRIFTS.get();
    }

}