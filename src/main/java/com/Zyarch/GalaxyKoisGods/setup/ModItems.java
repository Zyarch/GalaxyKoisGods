package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> THUNDER_STONE = Registration.ITEMS.register("thunder_stone", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> AMETHYST = Registration.ITEMS.register("amethyst", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> SELENIUM = Registration.ITEMS.register("selenium", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    static void register() { }
}
