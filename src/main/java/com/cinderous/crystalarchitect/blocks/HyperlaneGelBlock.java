package com.cinderous.crystalarchitect.blocks;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class HyperlaneGelBlock extends Block {

    public HyperlaneGelBlock() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.SNOW)
                .doesNotBlockMovement()
                .slipperiness(2.0f)
                .speedFactor(2.0f)
                .jumpFactor(1.0f)
        );
    }

//    @Override
//    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
//        return super.allowsMovement(state, worldIn, pos, type);
//    }
}