//package com.cinderous.crystalarchitect.blocks;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.SlabBlock;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.pathfinding.PathType;
//import net.minecraft.state.StateContainer;
//import net.minecraft.state.properties.SlabType;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.util.math.shapes.VoxelShapes;
//import net.minecraft.world.IBlockReader;
//
//
//
//public class HyperlaneGelSlab extends SlabBlock  {
//
//    protected static final VoxelShape BOTTOM_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
//    protected static final VoxelShape TOP_SHAPE = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
//
//    public HyperlaneGelSlab(Properties properties) {
//        super(Block.Properties.create(Material.WATER)
//                .hardnessAndResistance(0.1f,0.1f)
//                .sound(SoundType.NETHER_WART)
//        );
//        this.setDefaultState(this.getDefaultState().with(TYPE, SlabType.BOTTOM).with(WATERLOGGED, Boolean.valueOf(false)));
//    }
//
//    @Override
//    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
//        builder.add(TYPE, WATERLOGGED);
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        SlabType slabtype = state.get(TYPE);
//        switch(slabtype) {
//            case DOUBLE:
//                return VoxelShapes.fullCube();
//            case TOP:
//                return TOP_SHAPE;
//            default:
//                return BOTTOM_SHAPE;
//        }
//    }
//
//    @Override
//    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
//        return super.allowsMovement(state, worldIn, pos, type);
//    }
//}
