package com.Zyarch.GalaxyKoisGods.gods;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

public class GGod
{
    private String name;
    private String[] goodOfferResponse;
    private String[] neutralOfferResponse;
    private String[] badOfferResponse;
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

    public GGod setGoodOfferResponse(String[] goodOfferResponse) {
        this.goodOfferResponse = goodOfferResponse;
        return this;
    }

    public GGod setNeutralOfferResponse(String[] neutralOfferResponse) {
        this.neutralOfferResponse = neutralOfferResponse;
        return this;
    }

    public GGod setBadOfferResponse(String[] badOfferResponse) {
        this.badOfferResponse = badOfferResponse;
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

    public String[] getGoodOfferResponse() { return goodOfferResponse; }

    public String[] getNeutralOfferResponse() { return neutralOfferResponse; }

    public String[] getBadOfferResponse() { return badOfferResponse; }

    public String goodOffer (ItemStack item) { return name+": "+goodOfferResponse[0] + item.getDisplayName().getString() + goodOfferResponse[1];}

    public String badOffer (ItemStack item) { return name+": "+badOfferResponse[0] + item.getDisplayName().getString() + badOfferResponse[1];}

    public String neutralOffer (ItemStack item) { return name+": "+neutralOfferResponse[0] + item.getDisplayName().getString() + neutralOfferResponse[1];}
}
