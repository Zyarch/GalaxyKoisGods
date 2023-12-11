package com.zyarch.galaxykoisgods.data;

import com.google.common.collect.ImmutableList;
import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipeBuilder;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class DivineInfuserRecipeProvider extends RecipeProvider {
    private static final ImmutableList<ItemLike> SILVER_SMELTABLES =
            ImmutableList.of(GalasBlocks.SILVER_ORE.get().asItem(), GalasBlocks.DEEPSLATE_SILVER_ORE.get().asItem(), GalasItems.RAW_SILVER.get().asItem());
    private static final ImmutableList<ItemLike> RUBY_SMELTABLES =
            ImmutableList.of(GalasBlocks.RUBY_ORE.get().asItem());
    private static final ImmutableList<ItemLike> SAPPHIRE_SMELTABLES =
            ImmutableList.of(GalasBlocks.SAPPHIRE_ORE.get().asItem());
    private static final ImmutableList<ItemLike> SELENIUM_SMELTABLES =
            ImmutableList.of(GalasBlocks.SELENIUM_ORE.get().asItem());
    private static final ImmutableList<ItemLike> THUNDER_STONE_SMELTABLES =
            ImmutableList.of(GalasBlocks.THUNDER_STONE_ORE.get().asItem());

    public DivineInfuserRecipeProvider(PackOutput packOutput) { super(packOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        DivineInfuserRecipeBuilder.build(new ItemLike[] {GalasItems.THUNDER_STONE.get(), GalasItems.THUNDER_STONE.get(), Items.BOW, GalasItems.THUNDER_STONE.get(), GalasItems.THUNDER_STONE.get()}, GalasItems.STORM_BOW.get(), 1).unlockedByItem(GalasItems.THUNDER_STONE.get()).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.WITHER_ROSE, Items.DEAD_BUSH, GalasItems.SILVER_DAGGER.get(), Items.CACTUS, Items.TNT}, GalasItems.VOID_DAGGER.get(), 1).unlockedByItem(GalasItems.SILVER_DAGGER.get()).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.CACTUS}, GalasItems.HEALING_TOKEN.get(), 1).unlockedByItem(Items.CACTUS).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.CACTUS, Items.CACTUS}, GalasItems.STORM_CALLER.get(), 1).unlockedByItem(Items.CACTUS).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.CACTUS, Items.CACTUS, Items.CACTUS}, GalasItems.LUCKY_COIN.get(), 1).unlockedByItem(Items.CACTUS).save(consumer);
        DivineInfuserRecipeBuilder.build(new ItemLike[] {Items.CACTUS, Items.CACTUS, Items.CACTUS, Items.CACTUS}, GalasItems.TELEPORTING_ORB.get(), 1).unlockedByItem(Items.CACTUS).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SILVER_INGOT.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_BLOCK)).unlockedBy("has_silver", has(GalasItems.SILVER_INGOT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.RUBY.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_BLOCK)).unlockedBy("has_ruby", has(GalasItems.RUBY.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.THUNDER_STONE.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_BLOCK)).unlockedBy("has_thunder_stone", has(GalasItems.THUNDER_STONE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SAPPHIRE.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SAPPHIRE_BLOCK)).unlockedBy("has_sapphire", has(GalasItems.SAPPHIRE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.SELENIUM.get(), 9).requires(GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_BLOCK)).unlockedBy("has_selenium", has(GalasItems.SELENIUM.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasBlocks.SILVER_BLOCK.get(), 1).requires(GalasItems.SILVER_INGOT.get(), 9).unlockedBy("has_silver", has(GalasItems.SILVER_INGOT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasBlocks.RUBY_BLOCK.get(), 1).requires(GalasItems.RUBY.get(), 9).unlockedBy("has_ruby", has(GalasItems.RUBY.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasBlocks.SAPPHIRE_BLOCK.get(), 1).requires(GalasItems.SAPPHIRE.get(), 9).unlockedBy("has_sapphire", has(GalasItems.SAPPHIRE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasBlocks.THUNDER_STONE_BLOCK.get(), 1).requires(GalasItems.THUNDER_STONE.get(), 9).unlockedBy("has_thunder_stone", has(GalasItems.THUNDER_STONE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasBlocks.SELENIUM_BLOCK.get(), 1).requires(GalasItems.SELENIUM.get(), 9).unlockedBy("has_selenium", has(GalasItems.SELENIUM.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GalasItems.OFFER_AMALGUM.get(), 1)
                .requires(GalasItems.SELENIUM.get(), 1).requires(Items.COAL, 1)
                .requires(GalasItems.THUNDER_STONE.get(), 1).requires(Items.GOLD_INGOT, 1)
                .requires(Items.LAPIS_LAZULI, 1).requires(Items.REDSTONE, 1)
                .unlockedBy("has_selenium", has(GalasItems.SELENIUM.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GalasBlocks.ALTAR.get())
                .define('S', Blocks.SMOOTH_STONE.asItem()).define('_', Blocks.SMOOTH_STONE_SLAB)
                .pattern("_ _")
                .pattern(" S ")
                .pattern("___")
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE.asItem()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GalasBlocks.DIVINE_INFUSER.get())
                .define('q', Blocks.SMOOTH_QUARTZ.asItem()).define('g', Items.GOLD_INGOT)
                .define('s', Blocks.STONE.asItem()).define('d', Items.DIAMOND)
                .pattern("gdg")
                .pattern("qqq")
                .pattern("s s")
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GalasItems.SILVER_DAGGER.get())
                .define('s', GalasItems.SILVER_INGOT.get()).define('/', Items.STICK)
                .pattern("s")
                .pattern("s")
                .pattern("/")
                .unlockedBy("has_silver", has(GalasItems.SILVER_INGOT.get()))
                .save(consumer);

        oreSmelting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, GalasItems.SILVER_INGOT.get(), 0.1f, 200, "silver");
        oreSmelting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, GalasItems.RUBY.get(), 0.25f, 200, "ruby");
        oreSmelting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, GalasItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreSmelting(consumer, SELENIUM_SMELTABLES, RecipeCategory.MISC, GalasItems.SELENIUM.get(), 0.25f, 200, "selenium");
        oreSmelting(consumer, THUNDER_STONE_SMELTABLES, RecipeCategory.MISC, GalasItems.THUNDER_STONE.get(), 0.25f, 200, "thunder_stone");

        oreBlasting(consumer, SILVER_SMELTABLES, RecipeCategory.MISC, GalasItems.SILVER_INGOT.get(), 0.1f, 100, "silver");
        oreBlasting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, GalasItems.RUBY.get(), 0.25f, 100, "ruby");
        oreBlasting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, GalasItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreBlasting(consumer, SELENIUM_SMELTABLES, RecipeCategory.MISC, GalasItems.SELENIUM.get(), 0.25f, 100, "selenium");
        oreBlasting(consumer, THUNDER_STONE_SMELTABLES, RecipeCategory.MISC, GalasItems.THUNDER_STONE.get(), 0.25f, 100, "thunder_stone");
    }
}
