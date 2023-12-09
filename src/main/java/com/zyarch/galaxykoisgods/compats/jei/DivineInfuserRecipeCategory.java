package com.zyarch.galaxykoisgods.compats.jei;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipe;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
public class DivineInfuserRecipeCategory implements IRecipeCategory<DivineInfuserRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(GalaxyKoisGods.MODID, "divine_infuser");
    public static final RecipeType<DivineInfuserRecipe> DIVINE_INFUSER_TYPE = new RecipeType<>(UID, DivineInfuserRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    private static final ResourceLocation DIVINE_INFUSER_JEI_TEXTURE = new ResourceLocation(GalaxyKoisGods.MODID, "textures/gui/divine_infuser_screen.png");

    public DivineInfuserRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(DIVINE_INFUSER_JEI_TEXTURE, 48, 9, 79, 67);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(GalasBlocks.DIVINE_INFUSER.get()));
    }

    @Override
    public RecipeType<DivineInfuserRecipe> getRecipeType() {
        return DIVINE_INFUSER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.jei.divineinfuser");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DivineInfuserRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 50, 39)
                .addIngredients(recipe.ingredients[0]);
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 59)
                .addIngredients(recipe.ingredients[1]);
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 50)
                .addIngredients(recipe.ingredients[2]);
        builder.addSlot(RecipeIngredientRole.INPUT, 110, 39)
                .addIngredients(recipe.ingredients[3]);
        builder.addSlot(RecipeIngredientRole.INPUT, 106, 59)
                .addIngredients(recipe.ingredients[4]);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 10)
                .addItemStack(recipe.result);
    }
}
