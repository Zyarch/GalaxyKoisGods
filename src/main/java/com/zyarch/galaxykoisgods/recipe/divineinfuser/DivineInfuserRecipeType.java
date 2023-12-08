package com.zyarch.galaxykoisgods.recipe.divineinfuser;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import net.minecraft.world.item.crafting.RecipeType;

public class DivineInfuserRecipeType implements RecipeType<DivineInfuserRecipe> {
    @Override
    public String toString () {
        return GalaxyKoisGods.MODID + ":divine_infuser";
    }
}
