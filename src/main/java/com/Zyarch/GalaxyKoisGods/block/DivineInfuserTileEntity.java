package com.Zyarch.GalaxyKoisGods.block;

import com.Zyarch.GalaxyKoisGods.setup.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class DivineInfuserTileEntity extends TileEntity implements ITickableTileEntity {

    private ItemStackHandler itemHandler = creatHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    private int counter;

    public DivineInfuserTileEntity() {
        super(ModTileEntityTypes.DIVINE_INFUSER_TILE.get());
    }

    @Override
    public void tick() {
        if(world.isRemote)
            return;

        if(counter > 0)
        {
            counter --;
            markDirty();
        }

        if(counter <= 0)
        {
            //ItemStack stack = itemHandler.getStackInSlot();

            //test recipe if(stack.getItem())
            {
                itemHandler.extractItem(0, 1, false);
                itemHandler.extractItem(1, 1, false);
                itemHandler.extractItem(2, 1, false);
                itemHandler.extractItem(3, 1, false);
                itemHandler.extractItem(4, 1, false);
                counter = 20 * 7;

                markDirty();
            }
        }

        //BlockState blockState = world.getBlockState(pos);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        counter = nbt.getInt("counter");

        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        compound.putInt("counter", counter);

        return super.write(compound);
    }

    private ItemStackHandler creatHandler()
    {
        return new ItemStackHandler(6){
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return super.isItemValid(slot, stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }
}
