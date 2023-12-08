package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipeBuilder;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class DivineInfuserRecipeProvider extends RecipeProvider {
    public DivineInfuserRecipeProvider(PackOutput packOutput) { super(packOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.BOW, GalasItems.THUNDER_STONE.get(), Items.AIR, Items.AIR, Items.AIR}, GalasItems.STORM_CALLER.get(), 1).unlockedByItem(GalasItems.THUNDER_STONE.get()).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.WITHER_ROSE, Items.DEAD_BUSH, GalasItems.SILVER_DAGGER.get(), Items.AIR, Items.AIR}, GalasItems.VOID_DAGGER.get(), 1).unlockedByItem(GalasItems.SILVER_DAGGER.get()).save(consumer);
    }
}
