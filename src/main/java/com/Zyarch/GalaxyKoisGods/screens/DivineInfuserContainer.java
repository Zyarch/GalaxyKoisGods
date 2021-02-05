package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.block.DivineInfuserTileEntity;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class DivineInfuserContainer extends Container
{
    private TileEntity tileEntity;
    private PlayerEntity playerEntity;
    private IItemHandler playerInventory;

    public DivineInfuserContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventoryIn, PlayerEntity player) {
        super(ModContainers.DIVINE_INFUSER_CONTAINER.get(), windowId);
        tileEntity = world.getTileEntity(pos);
        this.playerEntity = player;
        this.playerInventory = new InvWrapper(playerInventoryIn);

        if(tileEntity != null)
        {
            this.tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                addSlot(new SlotHelperWithEvent(h, 0, 80, 10, (DivineInfuserTileEntity) tileEntity));
                addSlot(new SlotHelperWithEvent(h, 1, 50, 39, (DivineInfuserTileEntity) tileEntity));
                addSlot(new SlotHelperWithEvent(h, 2, 54, 59, (DivineInfuserTileEntity) tileEntity));
                addSlot(new SlotHelperWithEvent(h, 3, 110, 39, (DivineInfuserTileEntity) tileEntity));
                addSlot(new SlotHelperWithEvent(h, 4, 106, 59, (DivineInfuserTileEntity) tileEntity));
                addSlot(new SlotHelperWithEvent(h, 5, 80, 50, (DivineInfuserTileEntity) tileEntity));
            });
        }

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

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player){
        ItemStack itemStack = super.slotClick(slotId, dragType, clickTypeIn, player);

        if(slotId >= 0 && slotId < 6)
        if(getSlot(slotId) instanceof SlotHelperWithEvent)
        {
            DivineInfuserTileEntity di = (DivineInfuserTileEntity) this.tileEntity;
            di.onSlotsChanged();
        }

        return itemStack;
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
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerIn, ModBlocks.DIVINE_INFUSER.get());
    }
}
