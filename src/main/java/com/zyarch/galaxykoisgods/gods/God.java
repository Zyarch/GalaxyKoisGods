package com.zyarch.galaxykoisgods.gods;

import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class God
{
    private String name;
    private GalaGods godE;
    private String goodOfferResponse;
    private String neutralOfferResponse;
    private String badOfferResponse;
    private final Map<String, OfferEntry> goodOfferMap = new HashMap<>();
    private final Map<String, OfferEntry> badOfferMap = new HashMap<>();

    public God(String _name)
    {
        name = _name;
    }

    public God setOfferItemList(Item... items) {
        //throws the items into a map so that you can easily get the associated value
        for (Item item : items) {
            OfferEntry offer = OfferEntries.get(item);
            try {
                goodOfferMap.put(offer.getOffer().toString(), offer);
            } catch(NullPointerException ex) {
                throw new NullPointerException("Offer is null for item: " + item);
            }
        }
        return this;
    }

    public God setBadItemList(Item... items)
    {
        //throws the items into a map so that you can easily get the associated value
        for (Item item : items) {
            OfferEntry offer = OfferEntries.get(item);
            badOfferMap.put(offer.getOffer().toString(), offer);
        }

        return this;
    }

    public God setGoodOfferResponse(String goodOfferResponse) {
        this.goodOfferResponse = goodOfferResponse;
        return this;
    }

    public God setNeutralOfferResponse(String neutralOfferResponse) {
        this.neutralOfferResponse = neutralOfferResponse;
        return this;
    }

    public God setBadOfferResponse(String badOfferResponse) {
        this.badOfferResponse = badOfferResponse;
        return this;
    }

    public Boolean isInOfferList(ItemStack item) { return goodOfferMap.containsKey(item.getItem()); }

    public Boolean isInBadList(ItemStack item) { return badOfferMap.containsKey(item.getItem()); }

    //returns the favor value for the item
    public float getValue(ItemStack item) {
        float ret = 0f;
        String key = item.getItem().toString();
        if(isInOfferList(item)) {
            return goodOfferMap.get(key).getValue();
        }
        else if(isInBadList(item)) {
            return -badOfferMap.get(key).getValue();
        }
        return ret;
    }

    public String getName() { return name; }

    public String getGoodOfferResponse() { return goodOfferResponse; }

    public String getNeutralOfferResponse() { return neutralOfferResponse; }

    public String getBadOfferResponse() { return badOfferResponse; }

    public String goodOffer (ItemStack item) { return MessageFormat.format("<{1}> " + goodOfferResponse, item.getDisplayName().getString(), name); }

    public String badOffer (ItemStack item) { return MessageFormat.format("<{1}> " + badOfferResponse, item.getDisplayName().getString(), name);}

    public String neutralOffer (ItemStack item) { return MessageFormat.format("<{1}> " + neutralOfferResponse, item.getDisplayName().getString(), name);}

    public God setGodE(GalaGods gEnum) {
        godE = gEnum;
        return this;
    }

    public GalaGods getGodE() { return godE; }
}
