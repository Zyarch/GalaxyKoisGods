package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

public class AltarContainer extends Container
{
    private final AltarInventory altarInventory = new AltarInventory(this, 1);
    public GGod god;

    public AltarContainer(int windowId, PlayerInventory playerInventoryIn) {
        super(ModContainers.ALTAR_CONTAINER.get(), windowId);
            this.addSlot(new Slot(this.altarInventory, 0, 115, 32));

            //Adds slots for player inventory
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 9; ++j) {
                    this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                }
            }

            //Adds slots for player hot bar
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
            }
    }

    public AltarContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowID, playerInv);
    }

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0) {
                if (!this.mergeItemStack(itemstack1, 0, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.DUMMY, playerIn, ModBlocks.ALTAR.get());
    }

    public void shrinkInventory(int amount) {
        this.altarInventory.die(amount);
    }

    public void setGod(GGod newGod) { god = newGod; }
}
