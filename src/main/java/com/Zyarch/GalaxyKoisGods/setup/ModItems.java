package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.item.CultistRobeItem;
import com.Zyarch.GalaxyKoisGods.item.StormBowItem;
import com.Zyarch.GalaxyKoisGods.item.StormCaller;
import com.Zyarch.GalaxyKoisGods.item.VoidDaggerItem;
import com.Zyarch.GalaxyKoisGods.item.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

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

    public static final RegistryObject<Item> HEALING_TOKEN = Registration.ITEMS.register("healing_token", HealingToken::new);

    public static final RegistryObject<Item> TELEPORTING_ORB = Registration.ITEMS.register("teleporting_orb", TeleportingOrb::new);

    public static final RegistryObject<Item> LUCKY_COIN = Registration.ITEMS.register("lucky_coin", LuckyCoin::new);

    public static final RegistryObject<Item> STORM_BOW = Registration.ITEMS.register("storm_bow", StormBowItem::new);

    public static final RegistryObject<Item> STORM_CALLER = Registration.ITEMS.register("storm_caller", StormCaller::new);

    public static final RegistryObject<Item> VOID_DAGGER = Registration.ITEMS.register("void_dagger", VoidDaggerItem::new);

    //public static final RegistryObject<Item> PORTABLE_CRAFTING_TABLE = Registration.ITEMS.register("portable_crafting_table", PortableCraftingTable::new);

    //Armor
    public static final RegistryObject<Item> CULT_ROBE = Registration.ITEMS.register("cult_robe", () ->
            new CultistRobeItem(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).isImmuneToFire().group(GalaxyKoisGods.TAB)));

    static void register() { }
}
