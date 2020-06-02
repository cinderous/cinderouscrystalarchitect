package com.cinderous.crystalarchitect.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HyperlaneGravel  extends Block {

    public HyperlaneGravel() {
        super(Block.Properties.create(Material.SAND)
                .hardnessAndResistance(0.5f,0.5f)
                .sound(SoundType.SAND)

        );
    }

//    @Override
//    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
//        return super.allowsMovement(state, worldIn, pos, type);
//    }
}