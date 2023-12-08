package com.zyarch.galaxykoisgods.data.client;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.setup.Registration;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class GalasItemModelProvider extends ItemModelProvider {
    private static final ArrayList<String> blackList = new ArrayList<>() {
        {
            add("storm_bow");
        }
    };

    public GalasItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GalaxyKoisGods.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        String key;
        for(RegistryObject<Item> item : Registration.ITEMS.getEntries()) {
            key = item.get().toString();

            if(blackList.contains(key)) {
                continue;
            }

            CommonUtility.LOGGER.debug("registerModels - " + key);
            try
            {
                withExistingParent(key, "item/generated").texture("layer0", "item/" + key);
            }
            catch (IllegalArgumentException exception)
            {
                CommonUtility.LOGGER.debug("registerModels - Failed to register model, probably is a block. [" + key + "]");
            }
        }

        //creating item models for block items
        withExistingParent("silver_ore", modLoc("block/silver_ore"));
        withExistingParent("deepslate_silver_ore", modLoc("block/deepslate_silver_ore"));
        withExistingParent("selenium_ore", modLoc("block/selenium_ore"));
        withExistingParent("thunder_stone_ore", modLoc("block/thunder_stone_ore"));
        withExistingParent("ruby_ore", modLoc("block/ruby_ore"));
        withExistingParent("silver_block", modLoc("block/silver_block"));
        withExistingParent("selenium_block", modLoc("block/selenium_block"));
        withExistingParent("thunder_stone_block", modLoc("block/thunder_stone_block"));
        withExistingParent("ruby_block", modLoc("block/ruby_block"));
        withExistingParent("altar", modLoc("block/altar"));
        withExistingParent("divine_infuser", modLoc("block/divine_infuser"));
    }
}
