package com.Zyarch.GalaxyKoisGods.gods;

import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;

public class God {

    //Major Gods aka Old Gods

    public static GGod Amara = new GGod("Amara")
            .setOfferItemList(Items.TOTEM_OF_UNDYING, Items.BONE_MEAL)
            .setBadItemList(Items.WITHER_ROSE)
            .setGoodOfferResponse(new String[]{""," is lovely!"})
            .setNeutralOfferResponse(new String[]{"I guess "," is acceptable."})
            .setBadOfferResponse(new String[]{"How could you! I hate ","!"});

    public static GGod KelDerash = new GGod("Kel-derash")
            .setOfferItemList(Items.TNT, Items.GUNPOWDER, Items.CACTUS, Items.DEAD_BUSH, Items.MELON, Items.MELON_SLICE)
            .setBadItemList(Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS,
                            Items.WHEAT, Items.PUMPKIN,
                            Items.CORNFLOWER, Items.SUNFLOWER, Items.ROSE_BUSH, Items.LILY_OF_THE_VALLEY,
                            Items.DANDELION, Items.POPPY, Items.BLUE_ORCHID, Items.ALLIUM, Items.AZURE_BLUET,
                            Items.ORANGE_TULIP, Items.RED_TULIP, Items.PINK_TULIP, Items.WHITE_TULIP,
                            Items.OXEYE_DAISY, Items.LILAC, Items.PEONY)
            .setGoodOfferResponse(new String[]{"Hmmmm... this '","' is acceptable."})
            .setNeutralOfferResponse(new String[]{"I care not for ","."})
            .setBadOfferResponse(new String[]{"...... ",". Unacceptable."});

    public static GGod Lithaga = new GGod("Lithaga")
            .setOfferItemList(Items.QUARTZ, Items.QUARTZ_BLOCK, Items.NETHER_BRICK, Items.NETHER_STAR, Items.BREWING_STAND,
                Items.POTION, ModItems.RUBY.get(), ModBlocks.RUBY_BLOCK.get(), ModBlocks.RUBY_ORE.get())
            .setBadItemList(Items.WATER_BUCKET, Items.ICE, Items.BLUE_ICE, Items.PACKED_ICE)
            .setGoodOfferResponse(new String[]{"",". This pleases me."})
            .setNeutralOfferResponse(new String[]{"I suppose you won't mind if I burn","?"})
            .setBadOfferResponse(new String[]{"",". Mistake."});

    public static GGod Ygthravil = new GGod("Ygthravil")
            .setOfferItemList(ModItems.AMETHYST.get(), ModBlocks.AMETHYST_BLOCK.get(), ModBlocks.AMETHYST_ORE.get(),
                Items.END_STONE, Items.PURPUR_BLOCK, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.CHORUS_FRUIT, Items.END_ROD,
                Items.PURPLE_CONCRETE, Items.BLUE_CONCRETE)
            .setBadItemList(Items.TNT, Items.ANVIL, Items.CHIPPED_ANVIL, Items.DAMAGED_ANVIL, Items.PISTON, Items.STICKY_PISTON)
            .setGoodOfferResponse(new String[]{"",". A worthy offering."})
            .setNeutralOfferResponse(new String[]{"","? I suppose I could use it...."})
            .setBadOfferResponse(new String[]{"",". You disappoint me."});


    //Lesser Gods


    public static GGod Lovahn = new GGod("Lovahn")
            .setOfferItemList(ModItems.SELENIUM.get(), ModBlocks.SELENIUM_BLOCK.get(), ModBlocks.SELENIUM_ORE.get(),
                Items.NETHER_STAR, Items.STRING, Items.TRIPWIRE_HOOK, Items.PISTON, Items.STICKY_PISTON, Items.LEVER,
                Items.SMOOTH_STONE, Items.ACACIA_TRAPDOOR, Items.BIRCH_TRAPDOOR, Items.IRON_TRAPDOOR, Items.CRIMSON_TRAPDOOR,
                Items.DARK_OAK_TRAPDOOR, Items.JUNGLE_TRAPDOOR, Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.WARPED_TRAPDOOR)
            .setBadItemList(Items.NETHERRACK, Items.EGG)
            .setGoodOfferResponse(new String[]{"A ","? I mean, I guess I'll take it...."})
            .setNeutralOfferResponse(new String[]{"A ","? Meh. I have many."})
            .setBadOfferResponse(new String[]{"A ","? Ye dare disrepect Ygthravil's daughter?"});

    public static GGod Eldus = new GGod("Eldus")
            .setOfferItemList(Items.LAPIS_LAZULI, Items.LAPIS_BLOCK, Items.PRISMARINE, Items.WATER_BUCKET, Items.NAUTILUS_SHELL,
                Items.TROPICAL_FISH, Items.PUFFERFISH, Items.SALMON, Items.COD, Items.DARK_PRISMARINE, Items.SEA_LANTERN,
                Items.BIRCH_BOAT, Items.ACACIA_BOAT, Items.OAK_BOAT, Items.DARK_OAK_BOAT, Items.JUNGLE_BOAT, Items.SPRUCE_BOAT)
            .setBadItemList(Items.LAVA_BUCKET)
            .setGoodOfferResponse(new String[]{"","! Wonderful!"})
            .setNeutralOfferResponse(new String[]{"",". A trinket of little worth."})
            .setBadOfferResponse(new String[]{"A ","! Awful."});

    public static GGod Tyrin = new GGod("Tyrin")
            .setOfferItemList(ModItems.THUNDER_STONE.get(), Items.CRACKED_STONE_BRICKS, Items.TRIDENT)
            .setBadItemList(Items.SPONGE, Items.WET_SPONGE)
            .setGoodOfferResponse(new String[]{"Ah, perfect! A ","! My thanks."})
            .setNeutralOfferResponse(new String[]{"",". Of little value, but of value all the same."})
            .setBadOfferResponse(new String[]{"I have no use for ","! Begone!"});

    public static GGod Xyrthas = new GGod("Xyarthas")
            .setOfferItemList(Items.REDSTONE, Items.REDSTONE_BLOCK, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_PICKAXE,
                Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_PICKAXE, Items.FLINT_AND_STEEL, Items.STONE_BRICKS)
            .setBadItemList(Items.TNT, Items.SAND)
            .setGoodOfferResponse(new String[]{"","? A fine addition to my collection!"})
            .setNeutralOfferResponse(new String[]{"?"," Just throw it on the pile, I guess."})
            .setBadOfferResponse(new String[]{"","! Terrible. Leave me!"});

    public static GGod Reptak = new GGod("Reptak")
            .setOfferItemList(Items.COAL, Items.OBSIDIAN, Items.ROTTEN_FLESH, Items.BONE, Items.BONE_BLOCK)
            .setBadItemList(Items.WATER_BUCKET, Items.ICE, Items.PACKED_ICE, Items.BLUE_ICE)
            .setGoodOfferResponse(new String[]{"Good. ",". The flames accept your offering"})
            .setNeutralOfferResponse(new String[]{"",".... as long as it burns."})
            .setBadOfferResponse(new String[]{"Gah! "," Trying to douse the flames?"});

    public static GGod Jaspren = new GGod("Jaspren")
            .setOfferItemList(Items.MOSSY_STONE_BRICKS, Items.GOLD_BLOCK, Items.GOLD_INGOT, Items.GOLD_NUGGET,
                Items.GOLD_ORE, Items.CARROT, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.POTATO, Items.BAKED_POTATO,
                Items.BREAD, Items.WHEAT, Items.BEETROOT, Items.BEETROOT_SOUP, Items.LAPIS_LAZULI, ModItems.AMETHYST.get(),
                ModItems.RUBY.get(), ModItems.SELENIUM.get(), ModItems.THUNDER_STONE.get(), ModItems.SILVER_INGOT.get())
            .setBadItemList(Items.POISONOUS_POTATO, Items.WITHER_ROSE, Items.TNT, Items.FLINT_AND_STEEL, Items.GUNPOWDER,
                Items.MILK_BUCKET)
            .setGoodOfferResponse(new String[]{"Haha! Thanks for the ","!"})
            .setNeutralOfferResponse(new String[]{"","? Maybe something shiny or tasty next time?"})
            .setBadOfferResponse(new String[]{"How dare you! Giving me "," is just rude!"});
}

//God Template
/*
public static GGod  = new GGod("")
            .setOfferItemList()
            .setBadItemList()
            .setGoodOfferResponse(new String[]{"",""})
            .setNeutralOfferResponse(new String[]{"",""})
            .setBadOfferResponse(new String[]{"",""});
 */