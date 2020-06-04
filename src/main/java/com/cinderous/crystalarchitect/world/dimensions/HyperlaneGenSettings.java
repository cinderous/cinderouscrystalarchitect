package com.cinderous.crystalarchitect.world.dimensions;

import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationSettings;

public class HyperlaneGenSettings extends GenerationSettings {

    public int getBiomeSize() {
        return 4;
    }

    public int getRiverSize() {
        return 4;
    }

    public int getBiomeId() {
        return -1;
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }


    @Override
    public BlockState getDefaultBlock() {
        setDefaultBlock(RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState());
        return super.getDefaultBlock();
    }
}