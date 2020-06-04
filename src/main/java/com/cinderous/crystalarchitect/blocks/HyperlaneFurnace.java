package com.cinderous.crystalarchitect.blocks;

import com.cinderous.crystalarchitect.tileentities.ExperimentBoxTileEntity;
import com.cinderous.crystalarchitect.tileentities.HyperlaneFurnaceTileEntity;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class HyperlaneFurnace extends Block {


    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public HyperlaneFurnace() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.GROUND)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;

    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return RegistryHandler.HYPERLANE_FURNACE_TILE_ENTITY.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (!worldIn.isRemote) {

            TileEntity tile = worldIn.getTileEntity(pos);

            if (tile instanceof HyperlaneFurnaceTileEntity) {

                NetworkHooks.openGui((ServerPlayerEntity) player, (HyperlaneFurnaceTileEntity) tile, pos);

                return ActionResultType.SUCCESS;

            }

        }

        return ActionResultType.FAIL;
    }
}
