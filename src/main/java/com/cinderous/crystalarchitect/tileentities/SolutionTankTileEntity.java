package com.cinderous.crystalarchitect.tileentities;

import com.cinderous.crystalarchitect.util.RegistryHandler;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

//public class SolutionTankTile Entity extends TileEntity implements ITickableTileEntity {
//    private static final Logger LOGGER = LogManager.getLogger();
//    public SolutionTankTileEntity(TileEntityType<?> tileEntityTypeIn) {
//        super(tileEntityTypeIn);
//    }
//
//    public SolutionTankTileEntity() {
//        this(RegistryHandler.SOLUTION_TANK_TILE_ENTITY.get());
//    }
//
//    @Override
//    public void tick() {
//        if (this.world.getBlockState(pos.down()).getBlock().equals(RegistryHandler.COBBLESTONE_SOLUTION_BLOCK.get()));  {
//            LOGGER.info("SOLUTION IS BELOW ME!");
//        }
//
//
//    }
//
//}
public class SolutionTankTileEntity extends TileEntity implements IFluidHandler, IFluidTank {

    private IFluidTank main;
    private IFluidHandler mainhandler;

    public SolutionTankTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);

    }

    public SolutionTankTileEntity() {
        this(RegistryHandler.SOLUTION_TANK_TILE_ENTITY.get());

    }

    public SolutionTankTileEntity(IFluidTank main, IFluidHandler mainhandler) {
        this();
        this.main = main;
        this.mainhandler = mainhandler;
    }




    @Nonnull
        @Override
        public FluidStack getFluid() {
            return main.getFluid();
        }

        @Override
        public int getFluidAmount() {
            return main.getFluidAmount();
        }

        @Override
        public int getCapacity() {
            return main.getCapacity();
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            //if (stack.getFluid().getDefaultState() == RegistryHandler.COBBLESTONE_SOLUTION_BLOCK.get())
            return true;
        }

        @Override
        public int getTanks() {
            return mainhandler.getTanks();
        }

        @Nonnull
        @Override
        public FluidStack getFluidInTank(int tank) {
            return mainhandler.getFluidInTank(tank);
        }

        @Override
        public int getTankCapacity(int tank) {
            return mainhandler.getTankCapacity(tank);
        }

        @Override
        public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
            return true;
        }

        @Override
        public int fill(FluidStack resource, IFluidHandler.FluidAction action) {
            return main.fill(resource, action);
        }

        @Nonnull
        @Override
        public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) {
            return main.drain(maxDrain, action);
        }

        @Nonnull
        @Override
        public FluidStack drain(FluidStack resource, IFluidHandler.FluidAction action) {
            return main.drain(resource, action);
        }
}

