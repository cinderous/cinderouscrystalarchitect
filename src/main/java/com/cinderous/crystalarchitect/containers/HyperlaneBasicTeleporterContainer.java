//package com.cinderous.crystalarchitect.containers;
//
//import com.cinderous.crystalarchitect.tileentities.ExperimentBoxTileEntity;
//import com.cinderous.crystalarchitect.tileentities.HyperlaneBasicTeleporterTileEntity;
//import com.cinderous.crystalarchitect.util.RegistryHandler;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.Slot;
//import net.minecraft.item.ItemStack;
//import net.minecraft.network.PacketBuffer;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.IWorldPosCallable;
//
//import java.util.Objects;
//
//public class HyperlaneBasicTeleporterContainer extends Container {
//
//    public final HyperlaneBasicTeleporterTileEntity tileEntity;
//
//    private final IWorldPosCallable canInteractWithCallable;
//
//    public HyperlaneBasicTeleporterContainer(final int windowId, final PlayerInventory playerInventory,
//                                  final HyperlaneBasicTeleporterTileEntity tileEntity) {
//        super(RegistryHandler.HYPERLANE_BASIC_TELEPORTER_CONTAINER.get(), windowId);
//        this.tileEntity = tileEntity;
//        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
//
//        // Main Inventory
//        int startX = 8;
//        int startY = 18;
//        int slotSizePlus2 = 18;
////        for (int row = 0; row < 4; ++row) {
////            for (int column = 0; column < 9; ++column) {
////                this.addSlot(new Slot(tileEntity, (row * 9) + column, startX + (column * slotSizePlus2),
////                        startY + (row * slotSizePlus2)));
////            }
////        }
//
//        this.addSlot(new Slot(tileEntity, 1, 51,7));
//        this.addSlot(new Slot(tileEntity, 2, 145,7));
//        this.addSlot(new Slot(tileEntity, 3, 141,66));
//
//
//        // Main Player Inventory
//        int startPlayerInvY = startY * 5 + 12;
//        for (int row = 0; row < 3; ++row) {
//            for (int column = 0; column < 9; ++column) {
//                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
//                        startPlayerInvY + (row * slotSizePlus2)));
//            }
//        }
//
//        // Hotbar
//        int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
//        for (int column = 0; column < 9; ++column) {
//            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
//        }
//    }
//
//    private static HyperlaneBasicTeleporterTileEntity getTileEntity(final PlayerInventory playerInventory,
//                                                         final PacketBuffer data) {
//        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
//        Objects.requireNonNull(data, "data cannot be null");
//        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
//        if (tileAtPos instanceof HyperlaneBasicTeleporterTileEntity) {
//            return (HyperlaneBasicTeleporterTileEntity) tileAtPos;
//        }
//        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
//    }
//
//    public HyperlaneBasicTeleporterContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
//        this(windowId, playerInventory, getTileEntity(playerInventory, data));
//    }
//
//    @Override
//    public boolean canInteractWith(PlayerEntity playerIn) {
//        return isWithinUsableDistance(canInteractWithCallable, playerIn, RegistryHandler.EXPERIMENT_BOX.get());
//    }
//
//
//    @Override
//    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
//        ItemStack itemstack = ItemStack.EMPTY;
//        Slot slot = this.inventorySlots.get(index);
//        if (slot != null && slot.getHasStack()) {
//            ItemStack itemstack1 = slot.getStack();
//            itemstack = itemstack1.copy();
//            if (index < 36) {
//                if (!this.mergeItemStack(itemstack1, 36, this.inventorySlots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.mergeItemStack(itemstack1, 0, 36, false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (itemstack1.isEmpty()) {
//                slot.putStack(ItemStack.EMPTY);
//            } else {
//                slot.onSlotChanged();
//            }
//        }
//        return itemstack;
//    }
//
////    @Override
////    public boolean canDragIntoSlot(Slot slotIn) {
////        if ( slotIn.getSlotIndex() == 3 )
////            return false;
////        return super.canDragIntoSlot(slotIn);
////    }
//}