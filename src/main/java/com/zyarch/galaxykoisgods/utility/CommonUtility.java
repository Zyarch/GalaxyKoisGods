package com.zyarch.galaxykoisgods.utility;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public final class CommonUtility {
    private static final ResourceLocation emptyResourceLocation = new ResourceLocation("","");
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation getResourceLocation(RegistryObject<Item> item) {
        LOGGER.error("getResourceLocation<RegistryObject<Item>> - " + getResourceLocation(item.get()));
        return getResourceLocation(item.get());
    }

    public static ResourceLocation getResourceLocation(Item item) {
        ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(item);

        if(resourceLocation == null) {
            LOGGER.error("getResourceLocation - Item not found for " + item);
            return emptyResourceLocation;
        }

        LOGGER.error("getResourceLocation<Item> - " + resourceLocation);
        return resourceLocation;
    }

    public static String getPathToArmorTexture(String armorTextureFile) {
        return "textures/model/armor/" + armorTextureFile;
    }

    public static Item.Properties getStacksToOneProperty() {
        return new Item.Properties().stacksTo(1);
    }
}
