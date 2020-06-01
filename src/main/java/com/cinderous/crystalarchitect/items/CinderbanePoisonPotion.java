package com.cinderous.crystalarchitect.items;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.cinderous.crystalarchitect.world.CinderbaneTeleporter;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.UUID;

public class CinderbanePoisonPotion extends PotionItem implements ITeleporter {

    public CinderbanePoisonPotion() {
        super(new Item.Properties().group(CrystalArchitect.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        CinderbaneTeleporter tp = new CinderbaneTeleporter(entityLiving.getPosition());
        if (!worldIn.isRemote) {

            if (worldIn.dimension.getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
                entityLiving.changeDimension(DimensionType.OVERWORLD, tp);
            } else {
                entityLiving.changeDimension(DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE), tp);
            }

        }
//        return new ActionResult<>(ActionResultType.SUCCESS, entityLiving.getHeldItem(entityLiving.hand));
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        CinderbaneTeleporter tp = new CinderbaneTeleporter(playerIn.getPosition());
//        if (!worldIn.isRemote) {
//
//                if (worldIn.dimension.getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
//                    playerIn.changeDimension(DimensionType.OVERWORLD, tp);
//                } else {
//                    playerIn.changeDimension(DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE), tp);
//                }
//
//        }
//        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
//    }


    public UseAction getUseAction(ItemStack stack) {
        if (this.isInGroup(group)) {
            for (Potion potion : Registry.POTION) {
                if (potion == Potions.EMPTY || potion == Potions.WATER) {
                    return UseAction.DRINK;
                }
            }
        } return null;
    }


    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
//        if (this.isInGroup(group)) {
//            for(Potion potion : Registry.POTION) {
//                if (potion != Potions.EMPTY) {
//                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potion));
//                }
//            }
//        }
        if (this.isInGroup(group)) {
            for(Potion potion : Registry.POTION) {
                if (potion == RegistryHandler.CINDERBANE_POTION.get() || potion == Potions.EMPTY || potion == Potions.WATER) {
                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potion));
                }
            }
        }

    }

}

