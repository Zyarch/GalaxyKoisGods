package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

import javax.annotation.Nullable;

public class AltarContainer extends Container
{
    private final IInventory altarInventory;

    public AltarContainer(int id, PlayerInventory playerInventoryIn) {
        this(ModContainers.ALTAR, id, playerInventoryIn);
    }

    public AltarContainer(@Nullable ContainerType<?> type, int id, PlayerInventory playerInventoryIn, IInventory p_i50092_4_) {
        super(type, id);
        this.altarInventory = p_i50092_4_;
        p_i50092_4_.openInventory(playerInventoryIn.player);

        int i = (9 - 4) * 18;

        //Adds slots for player inventory
        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        //Adds slots for player hotbar
        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.altarInventory.isUsableByPlayer(playerIn);
    }
}
