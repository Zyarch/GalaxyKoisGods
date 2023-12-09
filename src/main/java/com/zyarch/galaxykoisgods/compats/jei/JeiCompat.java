package com.zyarch.galaxykoisgods.compats.jei;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.screens.DivineInfuserScreen;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasDivineInfuserRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.*;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(GalaxyKoisGods.MODID, "jei_compat");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        registration.addRecipeCatalyst(new ItemStack(GalasBlocks.DIVINE_INFUSER.get()), DivineInfuserRecipeCategory.DIVINE_INFUSER_TYPE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new DivineInfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        registration.addRecipes(DivineInfuserRecipeCategory.DIVINE_INFUSER_TYPE, rm.getAllRecipesFor(GalasDivineInfuserRecipes.DIVINE_INFUSER_RECIPE));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        //registration.addRecipeClickArea(DivineInfuserScreen.class, 99, 10,20,30, DivineInfuserRecipeCategory.DIVINE_INFUSER_TYPE);
    }
}