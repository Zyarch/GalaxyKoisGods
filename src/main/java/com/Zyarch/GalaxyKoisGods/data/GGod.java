package com.Zyarch.GalaxyKoisGods.data;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;

public class GGod
{
    private String name;
    private Ingredient offerItemList;
    private Ingredient badItemList;

    public GGod (String _name)
    {
        name = _name;
    }

    public GGod setOfferItemList(IItemProvider... itemsIn)
    {
        offerItemList = Ingredient.fromItems(itemsIn);
        return this;
    }

    public GGod setBadItemList(IItemProvider... itemsIn)
    {
        badItemList = Ingredient.fromItems(itemsIn);
        return this;
    }

    public String getName()
    {
        return name;
    }

    public boolean isInOfferList(ItemStack itemStack)
    {
        return offerItemList.test(itemStack);
    }

    public boolean isInBadList(ItemStack itemStack)
    {
        return badItemList.test(itemStack);
    }
}
