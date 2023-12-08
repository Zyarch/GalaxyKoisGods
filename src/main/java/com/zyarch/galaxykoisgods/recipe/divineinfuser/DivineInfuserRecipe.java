package com.zyarch.galaxykoisgods.recipe.divineinfuser;

import com.google.gson.JsonObject;
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
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class DivineInfuserRecipe implements Recipe<Container> {
    public static final Serializer SERIALIZER = new Serializer();

    public final Ingredient[] ingredients = new Ingredient[5];
    public final ItemStack result;
    private final ResourceLocation id;

    public DivineInfuserRecipe(ResourceLocation resLoc, Ingredient i1, Ingredient i2, Ingredient i3, Ingredient i4, Ingredient i5, ItemStack itemStack) {
        this.id = resLoc;
        this.ingredients[0] = i1;
        this.ingredients[1] = i2;
        this.ingredients[2] = i3;
        this.ingredients[3] = i4;
        this.ingredients[4] = i5;
        this.result = itemStack;
    }
    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return this.ingredients[0].test(p_44002_.getItem(0))
                && this.ingredients[1].test(p_44002_.getItem(1))
                && this.ingredients[2].test(p_44002_.getItem(2))
                && this.ingredients[3].test(p_44002_.getItem(3))
                && this.ingredients[4].test(p_44002_.getItem(4));
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
        return new ItemStack(Blocks.FLETCHING_TABLE);
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
            Ingredient i1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i1"));
            Ingredient i2 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i2"));
            Ingredient i3 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i3"));
            Ingredient i4 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i4"));
            Ingredient i5 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "i5"));
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            return new DivineInfuserRecipe(resLoc, i1, i2, i3, i4, i5, itemstack);
        }

        @Override
        public DivineInfuserRecipe fromNetwork(ResourceLocation resLoc, FriendlyByteBuf byteBuf) {
            Ingredient i1 = Ingredient.fromNetwork(byteBuf);
            Ingredient i2 = Ingredient.fromNetwork(byteBuf);
            Ingredient i3 = Ingredient.fromNetwork(byteBuf);
            Ingredient i4 = Ingredient.fromNetwork(byteBuf);
            Ingredient i5 = Ingredient.fromNetwork(byteBuf);
            ItemStack itemstack = byteBuf.readItem();
            return new DivineInfuserRecipe(resLoc, i1, i2, i3, i4, i5, itemstack);
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
    }
}
