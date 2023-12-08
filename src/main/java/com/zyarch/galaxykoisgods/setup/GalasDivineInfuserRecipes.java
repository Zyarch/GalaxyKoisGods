package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipe;
import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipeType;
import com.zyarch.galaxykoisgods.setup.mixin.RecipeManagerMixin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Map;

public class GalasDivineInfuserRecipes {
    public static final RecipeType<DivineInfuserRecipe> DIVINE_INFUSER_RECIPE = new DivineInfuserRecipeType();

    public static void registerRecipeSerializers(RegisterEvent event) {
        if (event.getRegistryKey().location() == ForgeRegistries.RECIPE_TYPES.getRegistryKey().location()) {
            System.out.println(DIVINE_INFUSER_RECIPE);
            event.getForgeRegistry().register(new ResourceLocation(DIVINE_INFUSER_RECIPE.toString()), DIVINE_INFUSER_RECIPE);
        }
        if (event.getRegistryKey().location() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey().location()) {
            event.getForgeRegistry().register(new ResourceLocation(DIVINE_INFUSER_RECIPE.toString()), DivineInfuserRecipe.SERIALIZER);
        }
    }

    public static <C extends Container, T extends Recipe<C>> Map<ResourceLocation, T> getRecipes(Level level, RecipeType<T> type) {
        return ((RecipeManagerMixin) level.getRecipeManager()).galaxykoisgods_getRecipes(type);
    }
}

