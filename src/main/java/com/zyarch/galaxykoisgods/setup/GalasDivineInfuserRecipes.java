package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipe;
import com.zyarch.galaxykoisgods.recipe.divineinfuser.DivineInfuserRecipeType;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class GalasDivineInfuserRecipes {
    public static final RecipeType<DivineInfuserRecipe> DIVINE_INFUSER_RECIPE = new DivineInfuserRecipeType();

    public static void registerRecipeSerializers(RegisterEvent event) {
        if (event.getRegistryKey().location() == ForgeRegistries.RECIPE_TYPES.getRegistryKey().location()) {
            System.out.println(DIVINE_INFUSER_RECIPE);
            event.getForgeRegistry().register(new ResourceLocation(DIVINE_INFUSER_RECIPE.toString()), DIVINE_INFUSER_RECIPE);
            CommonUtility.LOGGER.debug("registerRecipeSerializers Recipe type");
            CommonUtility.LOGGER.debug("Registry Key: " + ForgeRegistries.RECIPE_TYPES.getRegistryKey().location());
            CommonUtility.LOGGER.debug("Recipe as String: " + DIVINE_INFUSER_RECIPE.toString());
        }
        if (event.getRegistryKey().location() == ForgeRegistries.RECIPE_SERIALIZERS.getRegistryKey().location()) {
            event.getForgeRegistry().register(new ResourceLocation(DIVINE_INFUSER_RECIPE.toString()), DivineInfuserRecipe.SERIALIZER);
            CommonUtility.LOGGER.debug("registerRecipeSerializers other one");
            CommonUtility.LOGGER.debug("Recipe Serializer: " + DivineInfuserRecipe.SERIALIZER.toString());
            CommonUtility.LOGGER.debug("Recipe as String: " + DIVINE_INFUSER_RECIPE.toString());
        }
    }
}

