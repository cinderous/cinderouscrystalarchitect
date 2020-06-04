//package com.cinderous.crystalarchitect.tileentities;
//
//import com.cinderous.crystalarchitect.blocks.MultiboxChest;
//import com.cinderous.crystalarchitect.containers.HyperlaneBasicTeleporterContainer;
//import com.cinderous.crystalarchitect.containers.MultiboxChestContainer;
//import com.cinderous.crystalarchitect.util.RegistryHandler;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.ItemStackHelper;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.tileentity.LockableLootTileEntity;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.Direction;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.SoundCategory;
//import net.minecraft.util.SoundEvent;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//import net.minecraft.world.IBlockReader;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.CapabilityItemHandler;
//import net.minecraftforge.items.IItemHandlerModifiable;
//import net.minecraftforge.items.wrapper.InvWrapper;
//
//import javax.annotation.Nonnull;
//
//public class HyperlaneBasicTeleporterTileEntity extends LockableLootTileEntity {
//
//    private int capacity = 1;
//
//    private NonNullList<ItemStack> chestContents = NonNullList.withSize(36, ItemStack.EMPTY);
//    protected int numPlayersUsing;
//    //private IItemHandlerModifiable items = createHandler();
//    //private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
//
//
//    public HyperlaneBasicTeleporterTileEntity(TileEntityType<?> typeIn) {
//
//        super(typeIn);
//
//
//    }
//
//    public HyperlaneBasicTeleporterTileEntity() {
//        super(entity);this(RegistryHandler.HYPERLANE_BASIC_TELEPORTER_TILE_ENTITY.get();
//
//    }
//}
//
