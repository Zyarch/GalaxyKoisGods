package com.Zyarch.GalaxyKoisGods.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;

public class PortableCraftingTableContainer extends RecipeBookContainer<CraftingInventory> {

    public PortableCraftingTableContainer(ContainerType<?> type, int id) {
        super(type, id);
    }

    @Override
    public void fillStackedContents(RecipeItemHelper itemHelperIn) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean matches(IRecipe<? super CraftingInventory> recipeIn) {
        return false;
    }

    @Override
    public int getOutputSlot() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public RecipeBookCategory func_241850_m() {
        return null;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }
}