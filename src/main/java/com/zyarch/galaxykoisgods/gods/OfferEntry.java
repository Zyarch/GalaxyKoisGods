package com.zyarch.galaxykoisgods.gods;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class OfferEntry {
    private Item offer = null;
    private float value = 0;

    public OfferEntry(Item offer, float value) {
        this.offer = offer;
        this.value = value;
    }

    public OfferEntry(RegistryObject<Item> offer, float value) {
        this(offer.get(), value);
    }

    public Item getOffer() {
        return this.offer;
    }

    public float getValue() {
        return this.value;
    }
}
