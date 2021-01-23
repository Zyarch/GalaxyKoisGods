package com.Zyarch.GalaxyKoisGods.util;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.items.Altar;
import com.Zyarch.GalaxyKoisGods.items.SilverBlock;
import com.Zyarch.GalaxyKoisGods.items.SilverIngot;
import com.Zyarch.GalaxyKoisGods.items.SilverOre;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GalaxyKoisGods.MOD_ID);

    public static void register() { ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    //Items
    public static final RegistryObject<SilverIngot> SILVER_INGOT = ITEMS.register("silver_ingot", SilverIngot::new);

    //Block Items
    public static final RegistryObject<Altar> ALTAR = ITEMS.register("altar", Altar::new);
    public static final RegistryObject<SilverOre> SILVER_ORE = ITEMS.register("silver_ore", SilverOre::new);
    public static final RegistryObject<SilverBlock> SILVER_BLOCK = ITEMS.register("silver_block", SilverBlock::new);
}
