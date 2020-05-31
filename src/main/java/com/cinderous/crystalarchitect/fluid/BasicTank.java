package com.cinderous.crystalarchitect.fluid;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

public class BasicTank implements IFluidHandler, IFluidTank {

    private final IFluidTank main;
    private final IFluidHandler mainhandler;


    public BasicTank(IFluidTank main, IFluidHandler mainhandler) {
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
