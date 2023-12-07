package com.zyarch.galaxykoisgods.screens.menus;

import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AltarMenu extends AbstractContainerMenu {
    protected final ContainerLevelAccess context;
    protected final Player player;
    protected final Container input = new SimpleContainer(3)
    {
        public void setChanged() {
            super.setChanged();
            AltarMenu.this.slotsChanged(this);
        }
    };

    private final Level level;

    public AltarMenu(int i, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
        this(i, playerInventory, ContainerLevelAccess.NULL);
    }
    public AltarMenu(int i, Inventory playerInventory, ContainerLevelAccess containerLevelAccess) {
        super(GalasMenus.ALTAR.get(), i);
        this.context = containerLevelAccess;
        this.player = playerInventory.player;
        this.level = this.player.level();

        this.addSlot(new Slot(this.input, 0, 115, 32));

        //inventory
        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 0, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, GalasBlocks.ALTAR.get());
    }

    public void removed(Player p_39790_) {
        super.removed(p_39790_);
        this.context.execute((p_39796_, p_39797_) -> {
            this.clearContainer(p_39790_, this.input);
        });
    }
}
