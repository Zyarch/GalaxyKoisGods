package com.Zyarch.GalaxyKoisGods.crafting.builder;

import com.google.common.collect.Lists;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DivineInfuserRecipeBuilder extends ShapelessRecipeBuilder {
    public DivineInfuserRecipeBuilder(IItemProvider resultIn, int countIn) {
        super(resultIn, countIn);
    }
}
