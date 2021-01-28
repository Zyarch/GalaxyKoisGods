package com.Zyarch.GalaxyKoisGods.gods;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GGod
{
    private String name;
    private String[] goodOfferResponse;
    private String[] neutralOfferResponse;
    private String[] badOfferResponse;
    private Map<Item, Float> goodOfferMap = new HashMap<>();
    private Map<Item, Float> badOfferMap = new HashMap<>();

    public GGod (String _name)
    {
        name = _name;
    }

    public GGod setOfferItemList(Item[] itemsIn, Float[] valueIn)
    {
        //make sure there is an equivalent amount of items in both arrays
        if(itemsIn.length != valueIn.length)
           return this;
        //throws the items into a map so that you can easily get the associated value
        int _x = 0;
        for(int i = 0; i < itemsIn.length; i++)
        {
            //GalaxyKoisGods.LOGGER.debug(this.name + " i: " + i);
            goodOfferMap.put(itemsIn[i], valueIn[i]);
        }
        return this;
    }

    public GGod setBadItemList(Item[] itemsIn, Float[] valueIn)
    {
        //make sure there is an equivalent amount of items in both arrays
        if(itemsIn.length != valueIn.length)
            return this;
        //throws the items into a map so that you can easily get the associated value
        for(int i = 0; i < itemsIn.length; i++)
        {
            badOfferMap.put(itemsIn[i], valueIn[i]);
        }

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

    public Boolean isInOfferList(ItemStack item) { return goodOfferMap.containsKey(item.getItem()); }

    public Boolean isInBadList(ItemStack item) { return badOfferMap.containsKey(item.getItem()); }

    //returns the favor value for the item
    public float getValue(ItemStack item) {
        Float ret = 0f;
        if(isInOfferList(item))
            return goodOfferMap.get(item.getItem());
        else if(isInBadList(item))
            return badOfferMap.get(item.getItem());
        return ret;
    }

    public String getName() { return name; }

    public String[] getGoodOfferResponse() { return goodOfferResponse; }

    public String[] getNeutralOfferResponse() { return neutralOfferResponse; }

    public String[] getBadOfferResponse() { return badOfferResponse; }

    public String goodOffer (ItemStack item) { return name+": "+goodOfferResponse[0] + item.getDisplayName().getString() + goodOfferResponse[1];}

    public String badOffer (ItemStack item) { return name+": "+badOfferResponse[0] + item.getDisplayName().getString() + badOfferResponse[1];}

    public String neutralOffer (ItemStack item) { return name+": "+neutralOfferResponse[0] + item.getDisplayName().getString() + neutralOfferResponse[1];}
}
