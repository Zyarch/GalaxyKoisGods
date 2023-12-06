package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.item.armor.CultistRobeItem;
import com.zyarch.galaxykoisgods.item.armor.GalasArmorMaterials;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.RegistryObject;
import com.zyarch.galaxykoisgods.item.*;

import java.util.function.Supplier;

public class GalasItems {
    //common item property declarations
    private static final Item.Properties commonProperties = new Item.Properties();
    private static final Item.Properties stormBowProperties = new Item.Properties().durability(10);
    private static final Item.Properties stacksTo1Property = CommonUtility.getStacksToOneProperty();
    //default item declarations
    public static final RegistryObject<Item> RAW_SILVER = Registration.ITEMS.register("raw_silver", () -> new Item(commonProperties));
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () -> new Item(commonProperties));
    public static final RegistryObject<Item> THUNDER_STONE = Registration.ITEMS.register("thunder_stone", () -> new Item(commonProperties));
    public static final RegistryObject<Item> SELENIUM = Registration.ITEMS.register("selenium", () -> new Item(commonProperties));
    public static final RegistryObject<Item> RUBY = Registration.ITEMS.register("ruby", () -> new Item(commonProperties));
    public static final RegistryObject<Item> SAPPHIRE = Registration.ITEMS.register("sapphire", () -> new Item(commonProperties));
    public static final RegistryObject<Item> AMETHYST = Registration.ITEMS.register("amethyst", () -> new Item(commonProperties));
    public static final RegistryObject<Item> OFFER_AMALGUM = Registration.ITEMS.register("offer_amalgum", () -> new Item(commonProperties));
    //effect item declarations
    public static final RegistryObject<Item> STORM_CALLER = Registration.ITEMS.register("storm_caller", StormCaller::new);
    public static final RegistryObject<Item> HEALING_TOKEN = Registration.ITEMS.register("healing_token", HealingToken::new);
    public static final RegistryObject<Item> LUCKY_COIN = Registration.ITEMS.register("lucky_coin", LuckyCoin::new);
    public static final RegistryObject<Item> TELEPORTING_ORB = Registration.ITEMS.register("teleporting_orb", TeleportingOrb::new);
    //tool declarations
    public static final RegistryObject<Item> SILVER_DAGGER = Registration.ITEMS.register("silver_dagger", () -> new SwordItem(Tiers.IRON, 2, -2.4F, commonProperties));
    public static final RegistryObject<Item> VOID_DAGGER = Registration.ITEMS.register("void_dagger", VoidDaggerItem::new);
    public static final RegistryObject<Item> STORM_BOW = registerItem("storm_bow", () -> new StormBowItem(stormBowProperties));

    //<editor-fold desc="armor declarations">
    public static final RegistryObject<Item> CULT_ROBE_HOOD =
            registerItem("cult_hood", () -> new CultistRobeItem(GalasArmorMaterials.CULT_ROBES, ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> CULT_ROBE_CHEST =
            registerItem("cult_chest", () -> new CultistRobeItem(GalasArmorMaterials.CULT_ROBES, ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> CULT_ROBE_LEGGINGS =
            registerItem("cult_leggings", () -> new CultistRobeItem(GalasArmorMaterials.CULT_ROBES, ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> CULT_ROBE_BOOTS =
            registerItem("cult_boots", () -> new CultistRobeItem(GalasArmorMaterials.CULT_ROBES, ArmorItem.Type.BOOTS));
    //</editor-fold>

    private static <T extends Item> RegistryObject<Item> registerItem(String name, Supplier<T> supplier) {
        return Registration.ITEMS.register(name, supplier);
    }

    public static void register() { }
}
