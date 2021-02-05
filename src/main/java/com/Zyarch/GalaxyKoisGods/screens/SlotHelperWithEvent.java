package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.block.DivineInfuserTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotHelperWithEvent extends SlotItemHandler {

    private DivineInfuserTileEntity infuser;

    public SlotHelperWithEvent(IItemHandler itemHandler, int index, int xPosition, int yPosition, DivineInfuserTileEntity infuser) {
        super(itemHandler, index, xPosition, yPosition);
        this.infuser = infuser;
    }

    @Override
    public void onSlotChange(@Nonnull ItemStack oldStackIn, @Nonnull ItemStack newStackIn) {
        infuser.onSlotsChanged();
    }
}
