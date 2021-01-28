package com.Zyarch.GalaxyKoisGods.item;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;

public class StormBowItem extends BowItem {

    public StormBowItem() {
        super(new Item.Properties().maxDamage(480).group(GalaxyKoisGods.TAB));
    }
}
