package com.zyarch.galaxykoisgods.SetUp;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.RegistryObject;
import com.zyarch.galaxykoisgods.Item.*;

public class GalasItems {
    //common item property declarations
    private static final Item.Properties commonProperties = new Item.Properties();
    private static final Item.Properties stacksTo1Property = new Item.Properties().stacksTo(1);
    //default item declarations
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () -> new Item(commonProperties));
    public static final RegistryObject<Item> THUNDER_STONE = Registration.ITEMS.register("thunder_stone", () -> new Item(commonProperties));
    public static final RegistryObject<Item> SELENIUM = Registration.ITEMS.register("selenium", () -> new Item(commonProperties));
    public static final RegistryObject<Item> RUBY = Registration.ITEMS.register("ruby", () -> new Item(commonProperties));
    public static final RegistryObject<Item> SAPPHIRE = Registration.ITEMS.register("sapphire", () -> new Item(commonProperties));
    public static final RegistryObject<Item> OFFER_AMALGUM = Registration.ITEMS.register("offer_amalgum", () -> new Item(commonProperties));
    //effect item declarations
    public static final RegistryObject<Item> STORM_CALLER = Registration.ITEMS.register("storm_caller", StormCaller::new);
    public static final RegistryObject<Item> HEALING_TOKEN = Registration.ITEMS.register("healing_token", HealingToken::new);
    public static final RegistryObject<Item> LUCKY_COIN = Registration.ITEMS.register("lucky_coin", LuckyCoin::new);
    public static final RegistryObject<Item> TELEPORTING_ORB = Registration.ITEMS.register("teleporting_orb", TeleportingOrb::new);
    //tool declarations
    public static final RegistryObject<Item> SILVER_DAGGER = Registration.ITEMS.register("silver_dagger", () -> new SwordItem(Tiers.IRON, 2, -2.4F, commonProperties));
    public static final RegistryObject<Item> VOID_DAGGER = Registration.ITEMS.register("void_dagger", VoidDaggerItem::new);
    public static final RegistryObject<Item> STORM_BOW = Registration.ITEMS.register("storm_bow", StormBowItem::new);
    //armor declarations
    public static void register() {}
}
