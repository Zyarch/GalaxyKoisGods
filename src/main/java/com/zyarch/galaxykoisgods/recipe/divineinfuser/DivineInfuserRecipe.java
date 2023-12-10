package com.zyarch.galaxykoisgods.recipe.divineinfuser;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasDivineInfuserRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DivineInfuserRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();
    public final Ingredient[] ingredients = new Ingredient[5];
    public final ItemStack result;
    private final ResourceLocation id;

    public DivineInfuserRecipe(ResourceLocation resLoc, Ingredient[] ingredients, ItemStack itemStack) {
        this.id = resLoc;
        for(int i = 0; i < 5; i++)
            this.ingredients[i] = Ingredient.EMPTY;
        for(int i = 0; i < ingredients.length; i++)
            this.ingredients[i] = ingredients[i];
        this.result = itemStack;
    }
    @Override
    public boolean matches(Container container, Level level) {
        ArrayList<ItemStack> items = new ArrayList<>();
        boolean out = true;
        boolean itemExists;
        int numIngredients = 0;
        for(int i = 0; i < ingredients.length; i++)
        {
            if(!ingredients[i].isEmpty())
                numIngredients++;
            if(!container.getItem(i).isEmpty())
                items.add(container.getItem(i));
        }

        if(numIngredients != items.size())
            return false;


        for(int i = 0; i < numIngredients; i++)
        {
            itemExists = false;
            for(int k = 0; k < items.toArray().length; k++)
            {
                if(ingredients[i].test(items.get(k)) && !itemExists)
                {
                    items.remove(k);
                    itemExists = true;
                }
            }
            out = itemExists && out;
            if(!out)
                break;
        }
        return out;
    }

    @Override
    @NotNull
    public ItemStack assemble(Container container, RegistryAccess access) {
        ItemStack itemstack = this.result.copy();
        CompoundTag compoundtag = container.getItem(0).getTag();
        if (compoundtag != null) {
            itemstack.setTag(compoundtag.copy());
        }

        return itemstack;
    }

    @NotNull
    public  ItemStack getToastSymbol() {
        return new ItemStack(GalasBlocks.DIVINE_INFUSER.get());
    }

    public boolean canCraftInDimensions(int p_44528_, int p_44529_) {
        return true;
    }

    @Override
    @NotNull
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public RecipeType<?> getType() {
        return GalasDivineInfuserRecipes.DIVINE_INFUSER_RECIPE;
    }

    public static class Serializer<T extends DivineInfuserRecipe> implements RecipeSerializer<DivineInfuserRecipe> {
        Serializer() {
        }

        public DivineInfuserRecipe fromJson(ResourceLocation resLoc, JsonObject json) {
            Ingredient[] ingredients = new Ingredient[5];
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            for(int i=0; i < 5; i++) {
                try {
                    ingredients[i] = checkIngredient(Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i" + (i + 1))));
                }
                catch(JsonSyntaxException e)
                {
                    ingredients[i] = Ingredient.EMPTY;
                }
            }

            return new DivineInfuserRecipe(resLoc, ingredients, itemstack);
        }

        @Override
        public DivineInfuserRecipe fromNetwork(ResourceLocation resLoc, FriendlyByteBuf byteBuf) {
            Ingredient[] ingredients = new Ingredient[5];
            for(int i=0; i < 5; i++)
                ingredients[i] = checkIngredient(Ingredient.fromNetwork(byteBuf));

            ItemStack itemstack = byteBuf.readItem();
            return new DivineInfuserRecipe(resLoc, ingredients, itemstack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf byteBuf, DivineInfuserRecipe recipe) {
            recipe.ingredients[0].toNetwork(byteBuf);
            recipe.ingredients[1].toNetwork(byteBuf);
            recipe.ingredients[2].toNetwork(byteBuf);
            recipe.ingredients[3].toNetwork(byteBuf);
            recipe.ingredients[4].toNetwork(byteBuf);
            byteBuf.writeItem(recipe.result);
        }

        private Ingredient checkIngredient(Ingredient i)
        {
            Ingredient out = Ingredient.EMPTY;
            if(!i.isEmpty())
                out = i;
            return out;
        }
    }
}
