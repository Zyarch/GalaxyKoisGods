package com.zyarch.galaxykoisgods.gods;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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

    public God setOfferResponses(String name) {
        String keyPart1 = "god." + name + ".";
        this.goodOfferResponse = keyPart1 + "good_response";
        this.neutralOfferResponse = keyPart1 + "neutral_response";
        this.badOfferResponse = keyPart1 + "bad_response";
        return this;
    }

    public Boolean isInOfferList(ItemStack item) { return goodOfferMap.containsKey(item.getItem().toString()); }

    public Boolean isInBadList(ItemStack item) { return badOfferMap.containsKey(item.getItem().toString()); }

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

    public Component goodOffer (ItemStack item) {
        return Component.literal("<" + name + "> ").append(
                        Component.translatable(goodOfferResponse, getItemName(item)));
    }

    public Component badOffer (ItemStack item) {
        return Component.literal("<" + name + "> ").append(
                Component.translatable(badOfferResponse, getItemName(item)));
    }

    public Component neutralOffer (ItemStack item) {
        return Component.literal("<" + name + "> ").append(
                Component.translatable(neutralOfferResponse, getItemName(item)));
    }

    private String getItemName(ItemStack itemStack) {
        return itemStack.getHoverName().getString();
    }

    public God setGodE(GalaGods gEnum) {
        godE = gEnum;
        return this;
    }

    public GalaGods getGodE() { return godE; }
}
