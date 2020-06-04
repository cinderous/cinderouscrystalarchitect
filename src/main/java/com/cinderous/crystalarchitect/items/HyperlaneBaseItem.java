package com.cinderous.crystalarchitect.items;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HyperlaneBaseItem extends Item {
    public HyperlaneBaseItem() {
        super(new Item.Properties().group(CrystalArchitect.HYPERLANE_TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }
}
