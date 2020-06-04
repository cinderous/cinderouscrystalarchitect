package com.cinderous.crystalarchitect.world.biomes;



import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class HyperlaneDriftsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public HyperlaneDriftsSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
        super(function);
    }


    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

        double d0 = Biome.INFO_NOISE.noiseAt((double)x * 0.25D, (double)z * 0.25D, false);
        if (d0 > 0.0D) {
            int i = x & 15;
            int j = z & 15;
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(int k = startHeight; k >= 0; --k) {
                blockpos$mutable.setPos(i, k, j);
                if (!chunkIn.getBlockState(blockpos$mutable).isAir()) {
                    if (k == 62 && chunkIn.getBlockState(blockpos$mutable).getBlock() != defaultFluid.getBlock()) {
                        chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
                    }
                    break;
                }
            }
        }

        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
//        Random rd = new Random();
//        int i = rd.nextInt(3);
//        if (i == 0) {
//            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
//                    defaultFluid, seaLevel, seed,
//                    new SurfaceBuilderConfig(BlockInit.EXAMPLE_BLOCK.get().getDefaultState(),
//                            RegistryHandler.DEF_BLOCK.get().getDefaultState(), Blocks.ACACIA_PLANKS.getDefaultState()));
//        } else {
//            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
//                    defaultFluid, seaLevel, seed,
//                    new SurfaceBuilderConfig(
//                            i == 1 ? Blocks.GRASS_BLOCK.getDefaultState()
//                                    : BlockInit.EXAMPLE_BLOCK.get().getDefaultState(),
//                            BlockInit.DEF_BLOCK.get().getDefaultState(), Blocks.ACACIA_PLANKS.getDefaultState()));
//        }
    }
}