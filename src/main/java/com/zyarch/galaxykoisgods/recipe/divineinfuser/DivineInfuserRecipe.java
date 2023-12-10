package com.zyarch.galaxykoisgods.recipe.divineinfuser;

import com.google.gson.JsonObject;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasDivineInfuserRecipes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DivineInfuserRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();
    public final Ingredient[] ingredients = new Ingredient[5];
    public final ItemStack result;
    private final ResourceLocation id;

    public DivineInfuserRecipe(ResourceLocation resLoc, Ingredient[] ingredients, ItemStack itemStack) {
        this.id = resLoc;
        for(int i = 0; i < 5; i++)
            this.ingredients[i] = Ingredient.of(Items.AIR);
        for(int i = 0; i < ingredients.length; i++)
            this.ingredients[i] = ingredients[i];
        this.result = itemStack;
    }
    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredients[0].test(container.getItem(0))
                && this.ingredients[1].test(container.getItem(1))
                && this.ingredients[2].test(container.getItem(2))
                && this.ingredients[3].test(container.getItem(3))
                && this.ingredients[4].test(container.getItem(4));
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
            for(int i=0; i < 5; i++)
                ingredients[i] = checkIngredient(Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i" + (i+1))));

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
            Ingredient out = Ingredient.of(Items.AIR);
            if(!i.isEmpty())
                out = i;
            return out;
        }
    }
}
