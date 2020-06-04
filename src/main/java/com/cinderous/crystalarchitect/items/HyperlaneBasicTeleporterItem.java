//package com.cinderous.crystalarchitect.items;
//
//import com.cinderous.crystalarchitect.CrystalArchitect;
//import com.cinderous.crystalarchitect.tileentities.HyperlaneBasicTeleporterTileEntity;
//import com.cinderous.crystalarchitect.tileentities.MultiboxChestTileEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.potion.Effects;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.ActionResultType;
//import net.minecraft.util.Hand;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.network.NetworkHooks;
//
//public class HyperlaneBasicTeleporterItem  extends Item {
//
//    public HyperlaneBasicTeleporterItem() {
//        super(new Item.Properties().group(CrystalArchitect.HYPERLANE_TAB));
//    }
//
//    @Override
//    public boolean hasEffect(ItemStack stack) {
//        return super.hasEffect(stack);
//    }
//
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
////        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION,500,255));
////        worldIn.setRainStrength(1.0f);
//        if (!worldIn.isRemote) {
//
//            TileEntity tile = worldIn.getTileEntity(playerIn.getPosition());
//
//            if (tile instanceof HyperlaneBasicTeleporterTileEntity) {
//
//                NetworkHooks.openGui((ServerPlayerEntity) playerIn, (HyperlaneBasicTeleporterTileEntity) tile, playerIn.getPosition());
//
//
//            }
//        }
//
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//    }
//}