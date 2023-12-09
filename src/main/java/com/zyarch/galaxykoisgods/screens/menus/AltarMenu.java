package com.zyarch.galaxykoisgods.screens.menus;

import com.zyarch.galaxykoisgods.blocks.AltarBlockEntity;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AltarMenu extends AbstractContainerMenu {
    protected ContainerLevelAccess context = ContainerLevelAccess.NULL;
    protected Player player;

    private Level level;
    private  ContainerData data;
    private Container container;

    public AltarMenu(int i, Inventory playerInventory, Container container, ContainerData containerData) {
        super(GalasMenus.ALTAR.get(), i);
        checkContainerSize(container, 1);
        checkContainerDataCount(containerData, 2);
        this.container = container;
        this.data = containerData;
        this.player = playerInventory.player;
        this.level = this.player.level();

        this.addSlot(new Slot(container, 0, 115, 32));

        //inventory
        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }

        this.addSlotListener(new ContainerListener() {
            @Override
            public void slotChanged(AbstractContainerMenu containerMenu, int index, ItemStack itemStack) {
                if(itemStack.isEmpty() || index != 0) {
                    return;
                }

                if(!(containerMenu instanceof AltarMenu altarMenu)) {
                    return;
                }

                altarMenu.getContainer().offeringPlayer = altarMenu.getPlayer();
            }

            @Override
            public void dataChanged(AbstractContainerMenu containerMenu, int p_150525_, int p_150526_) { }
        });
    }
    public AltarMenu(int i, Inventory playerInventory, ContainerLevelAccess containerLevelAccess) {
        this(i, playerInventory, new SimpleContainer(1), new SimpleContainerData(2));
        this.context = containerLevelAccess;
    }

    public AltarMenu(int i, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotItemStack = slot.getItem();
            itemstack = slotItemStack.copy();

            if (index == 0) {
                if (!this.moveItemStackTo(slotItemStack, 1, 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, 1, true)) {
                return ItemStack.EMPTY;
            }

            if (slotItemStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotItemStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, slotItemStack);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, GalasBlocks.ALTAR.get());
    }

    public Player getPlayer() {
        return this.player;
    }

    public AltarBlockEntity getContainer() {
        return this.container instanceof AltarBlockEntity ? (AltarBlockEntity)this.container : null;
    }
}
