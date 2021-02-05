package com.Zyarch.GalaxyKoisGods.crafting.recipe;

import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModRecipeSerializers;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class DivineInfuserRecipe implements IRecipe<RecipeWrapper> {
    public static final IRecipeType<DivineInfuserRecipe> DIVINE_INFUSER_RECIPE_TYPE = Registration.DIVINE_INFUSER_RECIPE_TYPE;

    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final String group;
    final Ingredient ingredient;
    final ItemStack result;

    public DivineInfuserRecipe(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result) {
        type = DIVINE_INFUSER_RECIPE_TYPE;
        id = resourceLocation;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        System.out.println("Running in matches:");
        System.out.println("\t" + this.ingredient.test(inv.getStackInSlot(0)));
        System.out.println("\t" + this.ingredient.test(inv.getStackInSlot(5)));
        return this.ingredient.test(inv.getStackInSlot(0)) && this.ingredient.test(inv.getStackInSlot(5));
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return this.result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return result;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.DIVINE_INFUSER.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.DIVINE_INFUSER.get());
    }
}
