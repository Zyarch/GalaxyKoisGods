package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.crafting.recipe.DivineInfuserRecipe;
import com.Zyarch.GalaxyKoisGods.crafting.recipe.DivineInfuserRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final RegistryObject<DivineInfuserRecipeSerializer<DivineInfuserRecipe>> DIVINE_INFUSER =
            register("infuser", () -> new DivineInfuserRecipeSerializer(DivineInfuserRecipe::new));

    static void register() { }

    private static <T extends IRecipeSerializer<?>> RegistryObject<T> register(String name, Supplier<T> entityType)
    {
        return Registration.RECIPES.register("infuser", entityType);
    }
}