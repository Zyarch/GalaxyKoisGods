package com.zyarch.galaxykoisgods.gods;

import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class OfferEntries {
    private static boolean initialized = false;

    private static final Map<String, OfferEntry> offerMap = new HashMap<>();

    public static void add(float value, Item... items)
    {
        OfferEntry offer;
        for(Item item : items) {
            offer = new OfferEntry(item, value);
            offerMap.put(offer.getOffer().toString(), offer);
        }
    }

    public static OfferEntry get(@NotNull Item offer)
    {
        return offerMap.get(offer.toString());
    }

    public static void initialize() {
        if(initialized) {
            return;
        }

        add(0.01f,
                Items.MELON_SLICE, Items.LEVER, Items.WHEAT_SEEDS,
                Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS);
        add(0.03f, Items.REDSTONE, Items.WHEAT, Items.SMOOTH_STONE);
        add(0.05f, Items.NETHER_BRICK, Items.GOLD_NUGGET, Items.TRIPWIRE_HOOK,
                Items.ACACIA_TRAPDOOR, Items.BIRCH_TRAPDOOR,
                Items.CRIMSON_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.JUNGLE_TRAPDOOR,
                Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.WARPED_TRAPDOOR,
                Items.CORNFLOWER, Items.SUNFLOWER, Items.ROSE_BUSH,
                Items.LILY_OF_THE_VALLEY, Items.DANDELION, Items.POPPY,
                Items.BLUE_ORCHID, Items.ALLIUM, Items.AZURE_BLUET,
                Items.ORANGE_TULIP, Items.RED_TULIP, Items.PINK_TULIP, Items.WHITE_TULIP,
                Items.OXEYE_DAISY, Items.LILAC, Items.PEONY);
        add(0.1f,
                Items.BONE_MEAL, Items.DEAD_BUSH, Items.MELON, Items.QUARTZ,
                Items.CARROT, Items.POTATO, Items.BAKED_POTATO, Items.BREAD, Items.BEETROOT,
                Items.END_STONE, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.CHORUS_FRUIT,
                Items.PURPLE_CONCRETE, Items.BLUE_CONCRETE, Items.STONE_BRICKS, Items.LAPIS_LAZULI,
                Items.TROPICAL_FISH,  Items.PUFFERFISH, Items.SALMON, Items.COD,
                Items.ACACIA_BOAT, Items.BIRCH_BOAT, Items.DARK_OAK_BOAT,
                Items.JUNGLE_BOAT, Items.OAK_BOAT, Items.SPRUCE_BOAT, Items.PISTON, Items.STICKY_PISTON,
                Items.PUMPKIN);
        add(0.12f, Items.REDSTONE_ORE);
        add(0.15f, Items.IRON_TRAPDOOR);
        add(0.2f,
                Items.GUNPOWDER, Items.PURPUR_BLOCK, Items.PRISMARINE, Items.DARK_PRISMARINE,
                Items.SEA_LANTERN, Items.FLINT_AND_STEEL, Items.BONE);
        add(0.25f, Items.ROTTEN_FLESH);
        add(0.27f, Items.REDSTONE_BLOCK);
        add(0.3f,
                Items.POTION, Items.END_ROD, Items.COAL, Items.MOSSY_STONE_BRICKS,
                Items.CRACKED_STONE_BRICKS);
        add(0.4f, Items.QUARTZ_BLOCK, Items.OBSIDIAN, Items.STRING);
        add(0.5f,
                Items.EMERALD, Items.GOLD_INGOT, Items.BREWING_STAND, Items.NAUTILUS_SHELL, Items.TRIDENT,
                Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_PICKAXE, Items.GOLDEN_CARROT, Items.EGG,
                Items.SAND,
                GalasItems.SILVER_INGOT.get(), GalasItems.RUBY.get(), GalasItems.AMETHYST.get(),
                GalasItems.THUNDER_STONE.get(), GalasItems.SELENIUM.get());
        add(0.6f, Items.BONE_BLOCK, Items.BEETROOT_SOUP);
        add(0.8f, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_PICKAXE);
        add(0.9f, Items.COAL_ORE, Items.LAPIS_BLOCK);
        add(1,
                Items.TNT, Items.CACTUS, Items.GOLDEN_APPLE, Items.WITHER_ROSE,
                Items.SPONGE, Items.WET_SPONGE, Items.WATER_BUCKET, Items.ICE, Items.DAMAGED_ANVIL,
                Items.PACKED_ICE, Items.BLUE_ICE, Items.POISONOUS_POTATO, Items.MILK_BUCKET);
        add(1.5f,
                Items.EMERALD_ORE, Items.GOLD_ORE, Items.NETHERRACK,
                GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_ORE),
                GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_ORE),
                GalasBlocks.getBlockAsItem(GalasBlocks.AMETHYST_ORE),
                GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_ORE),
                GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_ORE));
        add(2, Items.TOTEM_OF_UNDYING, Items.CHIPPED_ANVIL);
        add(3, Items.LAVA_BUCKET, Items.ANVIL);
        add(2.7f, Items.COAL_BLOCK);
        add(4.5f,
                Items.EMERALD_BLOCK, Items.GOLD_BLOCK,
                GalasBlocks.getBlockAsItem(GalasBlocks.SILVER_BLOCK),
                GalasBlocks.getBlockAsItem(GalasBlocks.RUBY_BLOCK),
                GalasBlocks.getBlockAsItem(GalasBlocks.AMETHYST_BLOCK),
                GalasBlocks.getBlockAsItem(GalasBlocks.THUNDER_STONE_BLOCK),
                GalasBlocks.getBlockAsItem(GalasBlocks.SELENIUM_BLOCK));
        add(7, Items.NETHER_STAR);

        initialized = true;
    }
}
