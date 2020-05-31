package com.cinderous.crystalarchitect.items;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class CinderbanePoisonPotion extends Item {

    public CinderbanePoisonPotion() {
        super(new Item.Properties().group(CrystalArchitect.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.changeDimension(RegistryHandler.CINDERBANE_DIM);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
