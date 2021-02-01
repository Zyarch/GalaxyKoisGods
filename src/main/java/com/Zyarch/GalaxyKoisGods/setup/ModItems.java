package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.item.StormBowItem;
import com.Zyarch.GalaxyKoisGods.item.StormCaller;
import com.Zyarch.GalaxyKoisGods.item.VoidDaggerItem;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.ItemModelsProperties.registerProperty;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> THUNDER_STONE = Registration.ITEMS.register("thunder_stone", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> AMETHYST = Registration.ITEMS.register("amethyst", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> SELENIUM = Registration.ITEMS.register("selenium", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> RUBY = Registration.ITEMS.register("ruby", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> SAPPHIRE = Registration.ITEMS.register("sapphire", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> SILVER_DAGGER = Registration.ITEMS.register("silver_dagger", () ->
            new SwordItem(ItemTier.IRON, 3, -2f, new Item.Properties().maxDamage(251)
                    .group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> OFFER_AMALGUM = Registration.ITEMS.register("offer_amalgum", () ->
            new Item(new Item.Properties().group(GalaxyKoisGods.TAB)));

    public static final RegistryObject<Item> STORM_BOW = Registration.ITEMS.register("storm_bow", StormBowItem::new);

    public static final RegistryObject<Item> STORM_CALLER = Registration.ITEMS.register("storm_caller", StormCaller::new);

    public static final RegistryObject<Item> VOID_DAGGER = Registration.ITEMS.register("void_dagger", VoidDaggerItem::new);

    static void register() { }
}
