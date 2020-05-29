package com.cinderous.crystalarchitect.blocks;

import com.cinderous.crystalarchitect.containers.MultiboxChestContainer;
import com.cinderous.crystalarchitect.tileentities.MultiboxChestTileEntity;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
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

public class MultiboxChest extends Block {


    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public MultiboxChest() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GROUND)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override

    public boolean hasTileEntity(BlockState state) {

        return true;

    }



    @Override

    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return RegistryHandler.MULTIBOX_CHEST_TILE_ENTITY.get().create();

    }



    @Override

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,

                                             Hand handIn, BlockRayTraceResult result) {

        if (!worldIn.isRemote) {

            TileEntity tile = worldIn.getTileEntity(pos);

            if (tile instanceof MultiboxChestTileEntity) {

                NetworkHooks.openGui((ServerPlayerEntity) player, (MultiboxChestTileEntity) tile, pos);

                return ActionResultType.SUCCESS;

            }

        }

        return ActionResultType.FAIL;

    }



    @Override

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {

        if (state.getBlock() != newState.getBlock()) {

            TileEntity te = worldIn.getTileEntity(pos);

            if (te instanceof MultiboxChestTileEntity) {

                InventoryHelper.dropItems(worldIn, pos, ((MultiboxChestTileEntity) te).getItems());

            }

        }

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}