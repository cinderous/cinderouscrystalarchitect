package com.cinderous.crystalarchitect.items;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.UUID;

public class CinderbanePoisonPotion extends Item implements ITeleporter {

    public CinderbanePoisonPotion() {
        super(new Item.Properties().group(CrystalArchitect.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        DimensionType destination = DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE);

//        ServerPlayerEntity entityPlayerMP = (ServerPlayerEntity) playerIn;

        MinecraftServer server = playerIn.getEntityWorld().getServer();

        ServerWorld worldServer = server.getWorld(destination);


        if (!worldIn.isRemote) {

            if (playerIn.getServer() != null) {



                    if (playerIn.world.getDimension() != destination.create(worldIn)) {

                        //playerIn.changeDimension(destination, null);

                    } else {

                        this.placeEntity(playerIn, worldServer.getWorldServer() , worldServer, playerIn.rotationYaw, null);

                    }

                    playerIn.getHeldItemMainhand().shrink(1);

                }

            }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
