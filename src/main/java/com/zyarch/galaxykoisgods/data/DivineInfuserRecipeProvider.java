package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipeBuilder;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class DivineInfuserRecipeProvider extends RecipeProvider {
    public DivineInfuserRecipeProvider(PackOutput packOutput) { super(packOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        DivineInfuserRecipeBuilder.build(new ItemLike[] {GalasItems.THUNDER_STONE.get(), GalasItems.THUNDER_STONE.get(), Items.BOW, GalasItems.THUNDER_STONE.get(), GalasItems.THUNDER_STONE.get()}, GalasItems.STORM_BOW.get(), 1).unlockedByItem(GalasItems.THUNDER_STONE.get()).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.WITHER_ROSE, Items.DEAD_BUSH, GalasItems.SILVER_DAGGER.get(), Items.CACTUS, Items.TNT}, GalasItems.VOID_DAGGER.get(), 1).unlockedByItem(GalasItems.SILVER_DAGGER.get()).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SILVER_INGOT.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_BLOCK)).unlockedBy("has_silver", has(GalasItems.SILVER_INGOT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.RUBY.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_BLOCK)).unlockedBy("has_ruby", has(GalasItems.RUBY.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.THUNDER_STONE.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_BLOCK)).unlockedBy("has_thunder_stone", has(GalasItems.THUNDER_STONE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SAPPHIRE.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SAPPHIRE_BLOCK)).unlockedBy("has_sapphire", has(GalasItems.SAPPHIRE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SELENIUM.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_BLOCK)).unlockedBy("has_selenium", has(GalasItems.SELENIUM.get())).save(consumer);
    }
}
