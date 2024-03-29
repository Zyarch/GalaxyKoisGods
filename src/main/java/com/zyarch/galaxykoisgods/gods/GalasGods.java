package com.zyarch.galaxykoisgods.gods;

import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.world.item.Items;

import java.util.ArrayList;

public class GalasGods {
    private static final ArrayList<God> godList = new ArrayList<>();

    //<editor-fold desc="Major Gods">
    public static God Amara = new God("Amara")
            .setOfferItemList(
                    Items.TOTEM_OF_UNDYING,
                    Items.BONE_MEAL,
                    Items.EMERALD,
                    Items.EMERALD_BLOCK,
                    Items.EMERALD_ORE)
            .setBadItemList(Items.WITHER_ROSE)
            .setOfferResponses("amara")
            .setGodE(GalaGods.Amara);

    public static God KelDerash = new God("Kel-derash")
            .setOfferItemList(
                    Items.TNT,
                    Items.GUNPOWDER,
                    Items.CACTUS,
                    Items.DEAD_BUSH,
                    Items.MELON,
                    Items.MELON_SLICE,
                    GalasItems.SILVER_INGOT.get(),
                    GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_BLOCK),
                    GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_ORE))
            .setBadItemList(
                    Items.WHEAT_SEEDS,
                    Items.PUMPKIN_SEEDS,
                    Items.BEETROOT_SEEDS,
                    Items.MELON_SEEDS,
                    Items.WHEAT,
                    Items.PUMPKIN,
                    Items.CORNFLOWER,
                    Items.SUNFLOWER,
                    Items.ROSE_BUSH,
                    Items.LILY_OF_THE_VALLEY,
                    Items.DANDELION,
                    Items.POPPY,
                    Items.BLUE_ORCHID,
                    Items.ALLIUM,
                    Items.AZURE_BLUET,
                    Items.ORANGE_TULIP,
                    Items.RED_TULIP,
                    Items.PINK_TULIP,
                    Items.WHITE_TULIP,
                    Items.OXEYE_DAISY,
                    Items.LILAC,
                    Items.PEONY)
            .setOfferResponses("kel_derash")
            .setGodE(GalaGods.KelDerash);

    public static God Lithaga = new God("Lithaga")
            .setOfferItemList(
                    Items.QUARTZ,
                    Items.QUARTZ_BLOCK,
                    Items.NETHER_BRICK,
                    Items.NETHER_STAR,
                    Items.BREWING_STAND,
                    Items.POTION,
                    GalasItems.RUBY.get(),
                    GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_BLOCK),
                    GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_ORE))
            .setBadItemList(
                    Items.WATER_BUCKET,
                    Items.ICE,
                    Items.BLUE_ICE,
                    Items.PACKED_ICE)
            .setOfferResponses("lithaga")
            .setGodE(GalaGods.Lithaga);

    public static God Ygthravil = new God("Ygthravil")
            .setOfferItemList(
                    Items.END_STONE,
                    Items.PURPUR_BLOCK,
                    Items.PURPLE_WOOL,
                    Items.BLUE_WOOL,
                    Items.CHORUS_FRUIT,
                    Items.END_ROD,
                    Items.PURPLE_CONCRETE,
                    Items.BLUE_CONCRETE)
            .setBadItemList(
                    Items.TNT,
                    Items.ANVIL,
                    Items.CHIPPED_ANVIL,
                    Items.DAMAGED_ANVIL,
                    Items.PISTON,
                    Items.STICKY_PISTON)
            .setOfferResponses("ygthravil")
            .setGodE(GalaGods.Ygthravil);
    //</editor-fold>

    //<editor-fold desc="Lesser Gods">
    public static God Lovahn = new God("Lovahn")
            .setOfferItemList(
                    GalasItems.SELENIUM.get(),
                    GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_BLOCK),
                    GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_ORE),
                    Items.NETHER_STAR,
                    Items.STRING,
                    Items.TRIPWIRE_HOOK,
                    Items.PISTON,
                    Items.STICKY_PISTON,
                    Items.LEVER,
                    Items.SMOOTH_STONE,
                    Items.ACACIA_TRAPDOOR,
                    Items.BIRCH_TRAPDOOR,
                    Items.IRON_TRAPDOOR,
                    Items.CRIMSON_TRAPDOOR,
                    Items.DARK_OAK_TRAPDOOR,
                    Items.JUNGLE_TRAPDOOR,
                    Items.OAK_TRAPDOOR,
                    Items.SPRUCE_TRAPDOOR,
                    Items.WARPED_TRAPDOOR)
            .setBadItemList(Items.NETHERRACK, Items.EGG)
            .setOfferResponses("lovahn")
            .setGodE(GalaGods.Lovahn);

    public static God Eldus = new God("Eldus")
            .setOfferItemList(
                    Items.LAPIS_LAZULI,
                    Items.LAPIS_BLOCK,
                    Items.PRISMARINE,
                    Items.NAUTILUS_SHELL,
                    Items.TROPICAL_FISH,
                    Items.PUFFERFISH,
                    Items.SALMON,
                    Items.COD,
                    Items.DARK_PRISMARINE,
                    Items.SEA_LANTERN,
                    Items.BIRCH_BOAT,
                    Items.ACACIA_BOAT,
                    Items.OAK_BOAT,
                    Items.DARK_OAK_BOAT,
                    Items.JUNGLE_BOAT,
                    Items.SPRUCE_BOAT)
            .setBadItemList(Items.LAVA_BUCKET)
            .setOfferResponses("eldus")
            .setGodE(GalaGods.Eldus);

    public static God Tyrin = new God("Tyrin")
            .setOfferItemList(
                    GalasItems.THUNDER_STONE.get(),
                    GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_BLOCK),
                    GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_ORE),
                    Items.CRACKED_STONE_BRICKS,
                    Items.TRIDENT)
            .setBadItemList(Items.SPONGE, Items.WET_SPONGE)
            .setOfferResponses("tyrin")
            .setGodE(GalaGods.Tyrin);

    public static God Xyrthas = new God("Xyarthas")
            .setOfferItemList(
                    Items.REDSTONE,
                    Items.REDSTONE_BLOCK,
                    Items.REDSTONE_ORE,
                    Items.IRON_AXE,
                    Items.IRON_SHOVEL,
                    Items.IRON_PICKAXE,
                    Items.GOLDEN_AXE,
                    Items.GOLDEN_SHOVEL,
                    Items.GOLDEN_PICKAXE,
                    Items.FLINT_AND_STEEL,
                    Items.STONE_BRICKS)
            .setBadItemList(Items.TNT, Items.SAND)
            .setOfferResponses("xyarthas")
            .setGodE(GalaGods.Xyrthas);

    public static God Reptak = new God("Reptak")
            .setOfferItemList(
                    Items.COAL,
                    Items.COAL_BLOCK,
                    Items.COAL_ORE,
                    Items.OBSIDIAN,
                    Items.ROTTEN_FLESH,
                    Items.BONE,
                    Items.BONE_BLOCK)
            .setBadItemList(
                    Items.WATER_BUCKET,
                    Items.ICE,
                    Items.PACKED_ICE,
                    Items.BLUE_ICE)
            .setOfferResponses("reptak")
            .setGodE(GalaGods.Reptak);

    public static God Jaspren = new God("Jaspren")
            .setOfferItemList(
                    Items.MOSSY_STONE_BRICKS,
                    Items.GOLD_BLOCK,
                    Items.GOLD_INGOT,
                    Items.GOLD_NUGGET,
                    Items.GOLD_ORE,
                    Items.CARROT,
                    Items.GOLDEN_CARROT,
                    Items.GOLDEN_APPLE,
                    Items.POTATO,
                    Items.BAKED_POTATO,
                    Items.BREAD,
                    Items.WHEAT,
                    Items.BEETROOT,
                    Items.BEETROOT_SOUP)
            .setBadItemList(
                    Items.POISONOUS_POTATO,
                    Items.WITHER_ROSE,
                    Items.TNT,
                    Items.FLINT_AND_STEEL,
                    Items.GUNPOWDER,
                    Items.MILK_BUCKET)
            .setOfferResponses("jaspren")
            .setGodE(GalaGods.Jaspren);
    //</editor-fold>

    public static void populateGodList() {
        godList.add(Amara);
        godList.add(KelDerash);
        godList.add(Lithaga);
        godList.add(Ygthravil);
        godList.add(Lovahn);
        godList.add(Eldus);
        godList.add(Tyrin);
        godList.add(Xyrthas);
        godList.add(Reptak);
        godList.add(Jaspren);
    }

    public static God getGod(int index)
    {
        return godList.get(index);
    }

    public static int getGodListSize() {
        return godList.size();
    }

    public static God cycleGod(God god) {
        int _index = godList.indexOf(god) + 1;
        if(_index >= godList.size())
            _index = 0;
        return godList.get(_index);
    }

    public static GalaGods getGodEnum(God god) { return god.getGodE(); }
}

//God Template
/*
public static GalaGod  = new GalaGod("")
            .setOfferItemList(new Item[] {},
                new Float[] {})
            .setBadItemList(new Item[] {},
                new Float[] {})
            .setGoodOfferResponse(new String[]{"",""})
            .setNeutralOfferResponse(new String[]{"",""})
            .setBadOfferResponse(new String[]{"",""});
 */
