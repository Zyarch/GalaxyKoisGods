package com.zyarch.galaxykoisgods.screens.menus;

import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipe;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasDivineInfuserRecipes;
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

import java.util.ArrayList;
import java.util.List;

public class DivineInfuserMenu extends AbstractContainerMenu {
    protected final ResultContainer output = new ResultContainer();
    protected final Container input = new SimpleContainer(5)
    {
        public void setChanged() {
            super.setChanged();
            DivineInfuserMenu.this.slotsChanged(this);
        }
    };
    protected final ContainerLevelAccess context;
    protected final Player player;

    private final Level level;
    private DivineInfuserRecipe recipe;
    private final List<DivineInfuserRecipe> divineInfuserList;

    public DivineInfuserMenu(int i, Inventory playerInventory, FriendlyByteBuf packetBuffer)
    {
        this(i, playerInventory, ContainerLevelAccess.NULL);
    }

    public DivineInfuserMenu(int integer, Inventory inventory, ContainerLevelAccess containerAccess) {
        super(GalasMenus.DIVINE_INFUSER_MENU.get(), integer);
        this.context = containerAccess;
        this.player = inventory.player;
        this.level = inventory.player.level();
        //This is for when the recipes are set up.
        this.divineInfuserList = this.level.getRecipeManager().getAllRecipesFor(GalasDivineInfuserRecipes.DIVINE_INFUSER_RECIPE);

        //input slots
        this.addSlot(new Slot(this.input, 0, 50, 39));
        this.addSlot(new Slot(this.input, 1, 54, 59));
        this.addSlot(new Slot(this.input, 2, 80, 50));
        this.addSlot(new Slot(this.input, 3, 110, 39));
        this.addSlot(new Slot(this.input, 4, 106, 59));
        //output slot
        this.addSlot(new Slot(this.output, 5, 80, 10) {
            public boolean mayPlace(@NotNull ItemStack itemStack) {
                return false;
            }

            public boolean mayPickup(@NotNull Player player) {
                return DivineInfuserMenu.this.canTakeOutput(player, this.hasItem());
            }

            public void onTake(@NotNull Player player, @NotNull ItemStack itemStack) {
                DivineInfuserMenu.this.onTakeOutput(player, itemStack);
            }

        });

        //inventory
        //rest of inventory
        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(inventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        //hotbar
        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 8 + l * 18, 142));
        }
    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.context, player, GalasBlocks.DIVINE_INFUSER.get());
    }
    public ItemStack quickMoveStack(Player player, int i1) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i1);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (i1 == 0) {
                this.context.execute((level, blockpos) -> {
                    itemstack1.getItem().onCraftedBy(itemstack1, level, player);
                });
                if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (i1 >= 4 && i1 < 40) {
                if (!this.moveItemStackTo(itemstack1, 0, 4, false)) {
                    if (i1 < 31) {
                        if (!this.moveItemStackTo(itemstack1, 31, 40, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemstack1, 4, 31, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 4, 40, false)) {
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
            if (i1 == 0) {
                player.drop(itemstack1, false);
            }
        }

        return itemstack;
    }

    public void slotsChanged(Container container) {
        super.slotsChanged(container);
        if (container == this.input) {
            this.updateRepairOutput();
        }

    }

    public void updateRepairOutput() {
        List<DivineInfuserRecipe> list = this.level.getRecipeManager().getRecipesFor(GalasDivineInfuserRecipes.DIVINE_INFUSER_RECIPE, this.input, this.level);
        if (list.isEmpty()) {
            this.output.setItem(0, ItemStack.EMPTY);
        } else {
            this.recipe = list.get(0);
            ItemStack itemstack = this.recipe.assemble(this.input, this.level.registryAccess());
            this.output.setRecipeUsed(this.recipe);
            this.output.setItem(0, itemstack);
        }

    }

    protected boolean canTakeOutput(Player player, boolean bool) {
        return this.recipe != null && this.recipe.matches(this.input, this.level);
    }

    protected void onTakeOutput(Player player, ItemStack itemStack) {
        itemStack.onCraftedBy(player.level(), player, itemStack.getCount());
        this.output.awardUsedRecipes(player, new ArrayList<ItemStack>() {{add(itemStack);}});
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.shrinkStackInSlot(3);
        this.shrinkStackInSlot(4);
        this.context.execute((_level, _blockpos) -> {
            _level.levelEvent(1044, _blockpos, 0);
        });
    }

    private void shrinkStackInSlot(int i1) {
        ItemStack itemstack = this.input.getItem(i1);
        itemstack.shrink(1);
        this.input.setItem(i1, itemstack);
    }

    public void removed(Player player) {
        super.removed(player);
        this.context.execute((_level, _blockpos) -> {
            this.clearContainer(player, this.input);
        });
    }
}
