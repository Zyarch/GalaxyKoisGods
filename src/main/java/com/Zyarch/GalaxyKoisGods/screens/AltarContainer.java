package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;

public class AltarContainer extends Container
{
    private final AltarInventory altarInventory = new AltarInventory(this, 1);

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

        @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.DUMMY, playerIn, ModBlocks.ALTAR.get());
    }

    public void shrinkInventory(int amount) {
        this.altarInventory.die(amount);
    }
}
