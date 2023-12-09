package com.zyarch.galaxykoisgods.recipe.divineinfuser;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class DivineInfuserRecipeBuilder implements RecipeBuilder {
    private final String category = "divine_infuser";
    public final Ingredient[] ingredients;
    private final Item result;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @javax.annotation.Nullable
    private String group;

    private DivineInfuserRecipeBuilder(Ingredient[] ingredients, ItemLike itemLike, int iCount) {
        this.ingredients = ingredients;
        this.result = itemLike.asItem();
        this.count = iCount;
    }

    public static DivineInfuserRecipeBuilder build(ItemLike[] itemLikes, ItemLike itemLike, int iCount) {
        int j=0;
        //fill an ingredient list with empty ingredients
        Ingredient[] ingredients = new Ingredient[] {Ingredient.EMPTY,Ingredient.EMPTY,Ingredient.EMPTY,Ingredient.EMPTY,Ingredient.EMPTY};
        for(ItemLike i : itemLikes)
        {
            ingredients[j] = Ingredient.of(i);
            j++;
        }
        return new DivineInfuserRecipeBuilder(ingredients, itemLike, iCount);
    }

    public DivineInfuserRecipeBuilder unlockedBy(String p_126255_, CriterionTriggerInstance p_126256_) {
        this.advancement.addCriterion(p_126255_, p_126256_);
        return this;
    }

    public DivineInfuserRecipeBuilder unlockedByItem(ItemLike item) {
        this.advancement.addCriterion("has_" + item.asItem().toString(), has(item));
        return this;
    }

    protected static InventoryChangeTrigger.TriggerInstance has(ItemLike p_125978_) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(p_125978_).build());
    }

    protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... p_126012_) {
        return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, p_126012_);
    }

    public DivineInfuserRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        RecipeBuilder.super.save(finishedRecipeConsumer);
    }

    public Item getResult() {
        return this.result;
    }

    public void save(Consumer<FinishedRecipe> p_126205_, ResourceLocation p_126206_) {
        this.ensureValid(p_126206_);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_126206_)).rewards(AdvancementRewards.Builder.recipe(p_126206_)).requirements(RequirementsStrategy.OR);
        p_126205_.accept(new DivineInfuserRecipeBuilder.Result(p_126206_,
                this.result,
                this.count,
                this.group == null ? "" : this.group,
                this.ingredients,
                this.advancement,
                new ResourceLocation(p_126206_.getNamespace(), "recipes/" + this.category + "/" + p_126206_.getPath())));
    }

    private void ensureValid(ResourceLocation p_126208_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126208_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        public final Ingredient[] ingredients;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation resLoc, Item result, int count, String group, Ingredient[] ingredients, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = resLoc;
            this.result = result;
            this.count = count;
            this.group = group;
            this.ingredients = ingredients;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            json.add("i1", ingredients[0].toJson());
            json.add("i2", ingredients[1].toJson());
            json.add("i3", ingredients[2].toJson());
            json.add("i4", ingredients[3].toJson());
            json.add("i5", ingredients[4].toJson());

            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            jsonobject.addProperty("count", this.count);

            json.add("result", jsonobject);
        }

        public RecipeSerializer<?> getType() {
            return DivineInfuserRecipe.SERIALIZER;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
