package com.cinderous.crystalarchitect.blocks;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class HyperlaneGelBlock extends Block {

    public HyperlaneGelBlock() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.SNOW)
        );
    }
}