package com.Zyarch.GalaxyKoisGods.crafting.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class DivineInfuserRecipeSerializer<T extends DivineInfuserRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<DivineInfuserRecipe> {
    private final DivineInfuserRecipeSerializer.IFactory<T> factory;

    public DivineInfuserRecipeSerializer(DivineInfuserRecipeSerializer.IFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    @Nonnull
    public T read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        // group
        String groupString = JSONUtils.getString(json, "group", "");

        // ingredient
        JsonElement ingredientJSON = JSONUtils.isJsonArray(json, "inputGem") ? JSONUtils.getJsonArray(json, "inputGem") : JSONUtils.getJsonObject(json, "inputGem");
        Ingredient ingredient = Ingredient.deserialize(ingredientJSON);

        // ingredient
        ingredientJSON = JSONUtils.isJsonArray(json, "input") ? JSONUtils.getJsonArray(json, "input") : JSONUtils.getJsonObject(json, "input");
        Ingredient ingredient2 = Ingredient.deserialize(ingredientJSON);

        ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
        itemStacks.add(ingredient2.getMatchingStacks()[0]);
        itemStacks.add(ingredient.getMatchingStacks()[0]);

        // result
        ItemStack resultItemStack;
        if (!json.has("result")) {
            resultItemStack = ItemStack.EMPTY;
        }
        else if (json.get("result").isJsonObject()) {
            resultItemStack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
        } else {
            String resultString = JSONUtils.getString(json, "result");
            ResourceLocation resultRS = new ResourceLocation(resultString);
            resultItemStack = new ItemStack(ForgeRegistries.ITEMS.getValue(resultRS));
        }

        System.out.println("Recipe made!");

        return this.factory.create(recipeId, groupString, Ingredient.fromStacks(itemStacks.get(0), itemStacks.get(1)), resultItemStack);
    }

    @Nullable
    @Override
    public T read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
        // group
        String groupString = buffer.readString(32767);

        // ingredient
        Ingredient ingredient = Ingredient.read(buffer);

        // result
        ItemStack itemstack = buffer.readItemStack();

        return this.factory.create(recipeId, groupString, ingredient, itemstack);
    }

    @Override
    public void write(PacketBuffer buffer, DivineInfuserRecipe recipe) {
        // group
        buffer.writeString(recipe.group);

        // ingredient
        recipe.ingredient.write(buffer);

        // result
        buffer.writeItemStack(recipe.result);
    }

    public interface IFactory<T extends DivineInfuserRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result);
    }

}
