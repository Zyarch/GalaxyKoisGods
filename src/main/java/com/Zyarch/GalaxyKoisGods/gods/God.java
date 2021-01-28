package com.Zyarch.GalaxyKoisGods.gods;

import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;

public class God {

    private static ArrayList<GGod> godList = new ArrayList<GGod>();
    //Major Gods aka Old Gods

    public static GGod Amara = new GGod("Amara")
            .setOfferItemList(new Item[]{Items.TOTEM_OF_UNDYING, Items.BONE_MEAL},
                    new Float[]{2f, .1f})
            .setBadItemList(new Item[]{Items.WITHER_ROSE},
                    new Float[]{-1f})
            .setGoodOfferResponse(new String[]{"", " is lovely!"})
            .setNeutralOfferResponse(new String[]{"I guess ", " is acceptable."})
            .setBadOfferResponse(new String[]{"How could you! I hate ", "!"});

    public static GGod KelDerash = new GGod("Kel-derash")
            .setOfferItemList(new Item[]{Items.TNT, Items.GUNPOWDER, Items.CACTUS, Items.DEAD_BUSH, Items.MELON, Items.MELON_SLICE},
                    new Float[]{1f, .2f, .2f, .1f, .01f, .01f})
            .setBadItemList(
                    new Item[]{Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS,
                            Items.WHEAT, Items.PUMPKIN,
                            Items.CORNFLOWER, Items.SUNFLOWER, Items.ROSE_BUSH, Items.LILY_OF_THE_VALLEY,
                            Items.DANDELION, Items.POPPY, Items.BLUE_ORCHID, Items.ALLIUM, Items.AZURE_BLUET,
                            Items.ORANGE_TULIP, Items.RED_TULIP, Items.PINK_TULIP, Items.WHITE_TULIP,
                            Items.OXEYE_DAISY, Items.LILAC, Items.PEONY},
                    new Float[]{-.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f,
                            -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f, -.5f})
            .setGoodOfferResponse(new String[]{"Hmmmm... this '", "' is acceptable."})
            .setNeutralOfferResponse(new String[]{"I care not for ", "."})
            .setBadOfferResponse(new String[]{"...... ", ". Unacceptable."});

    public static GGod Lithaga = new GGod("Lithaga")
            .setOfferItemList(new Item[]{Items.QUARTZ, Items.QUARTZ_BLOCK, Items.NETHER_BRICK, Items.NETHER_STAR, Items.BREWING_STAND,
                            Items.POTION, ModItems.RUBY.get(), ModBlocks.RUBY_BLOCK.get().asItem(), ModBlocks.RUBY_ORE.get().asItem()},
                    new Float[]{.1f, .4f, .05f, 7f, .5f, .3f, .5f, 4.5f, 1.5f})
            .setBadItemList(new Item[]{Items.WATER_BUCKET, Items.ICE, Items.BLUE_ICE, Items.PACKED_ICE},
                    new Float[]{-1f, -1f, -1f, -1f})
            .setGoodOfferResponse(new String[]{"", ". This pleases me."})
            .setNeutralOfferResponse(new String[]{"I suppose you won't mind if I burn", "?"})
            .setBadOfferResponse(new String[]{"", ". Mistake."});

    public static GGod Ygthravil = new GGod("Ygthravil")
            .setOfferItemList(new Item[]{ModItems.AMETHYST.get(), ModBlocks.AMETHYST_BLOCK.get().asItem(), ModBlocks.AMETHYST_ORE.get().asItem(),
                            Items.END_STONE, Items.PURPUR_BLOCK, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.CHORUS_FRUIT, Items.END_ROD,
                            Items.PURPLE_CONCRETE, Items.BLUE_CONCRETE},
                    new Float[]{.5f, 4.5f, 1.5f, .15f, .2f, .1f, .1f, .1f, .3f, .1f, .1f})
            .setBadItemList(new Item[]{Items.TNT, Items.ANVIL, Items.CHIPPED_ANVIL, Items.DAMAGED_ANVIL, Items.PISTON, Items.STICKY_PISTON},
                    new Float[]{-1f, -3f, -2f, -1f, -.5f, -.5f})
            .setGoodOfferResponse(new String[]{"", ". A worthy offering."})
            .setNeutralOfferResponse(new String[]{"", "? I suppose I could use it...."})
            .setBadOfferResponse(new String[]{"", ". You disappoint me."});

    //Lesser Gods


    public static GGod Lovahn = new GGod("Lovahn")
            .setOfferItemList(new Item[] {ModItems.SELENIUM.get(), ModBlocks.SELENIUM_BLOCK.get().asItem(),
                ModBlocks.SELENIUM_ORE.get().asItem(), Items.NETHER_STAR, Items.STRING, Items.TRIPWIRE_HOOK, Items.PISTON,
                Items.STICKY_PISTON, Items.LEVER, Items.SMOOTH_STONE, Items.ACACIA_TRAPDOOR, Items.BIRCH_TRAPDOOR,
                Items.IRON_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.JUNGLE_TRAPDOOR,
                Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.WARPED_TRAPDOOR},
                    new Float[] {.5f, 4.5f, 1.5f, 7f, .04f, .08f, .1f, .1f, .01f, .02f, .05f, .05f, .15f, .05f, .05f, .05f,
                                .05f, .05f, .05f})
            .setBadItemList(new Item[] {Items.NETHERRACK, Items.EGG},
                new Float[] {-.1f, -.5f})
            .setGoodOfferResponse(new String[]{"A ","? I mean, I guess I'll take it...."})
            .setNeutralOfferResponse(new String[]{"A ","? Meh. I have many."})
            .setBadOfferResponse(new String[]{"A ","? Ye dare disrepect Ygthravil's daughter?"});

    public static GGod Eldus = new GGod("Eldus")
            .setOfferItemList(new Item[] {Items.LAPIS_LAZULI, Items.LAPIS_BLOCK, Items.PRISMARINE, Items.WATER_BUCKET, Items.NAUTILUS_SHELL,
                Items.TROPICAL_FISH, Items.PUFFERFISH, Items.SALMON, Items.COD, Items.DARK_PRISMARINE, Items.SEA_LANTERN,
                Items.BIRCH_BOAT, Items.ACACIA_BOAT, Items.OAK_BOAT, Items.DARK_OAK_BOAT, Items.JUNGLE_BOAT, Items.SPRUCE_BOAT},
                    new Float[] {.1f, .9f, .2f, .5f, 1f, .1f, .1f, .1f, .1f, .2f, .2f, .1f, .1f, .1f, .1f, .1f, .1f})
            .setBadItemList(new Item[] {Items.LAVA_BUCKET},
        new Float[] {-3f})
            .setGoodOfferResponse(new String[]{"","! Wonderful!"})
            .setNeutralOfferResponse(new String[]{"",". A trinket of little worth."})
            .setBadOfferResponse(new String[]{"A ","! Awful."});

    public static GGod Tyrin = new GGod("Tyrin")
            .setOfferItemList(new Item[] {ModItems.THUNDER_STONE.get(), ModBlocks.THUNDER_STONE_BLOCK.get().asItem(),
                            ModBlocks.THUNDER_STONE_ORE.get().asItem(), Items.CRACKED_STONE_BRICKS, Items.TRIDENT},
        new Float[] {.5f, 4.5f, 1.5f, .3f, .5f})
            .setBadItemList(new Item[] {Items.SPONGE, Items.WET_SPONGE},
        new Float[] {1f, 1f})
            .setGoodOfferResponse(new String[]{"Ah, perfect! A ","! My thanks."})
            .setNeutralOfferResponse(new String[]{"",". Of little value, but of value all the same."})
            .setBadOfferResponse(new String[]{"I have no use for ","! Begone!"});

    public static GGod Xyrthas = new GGod("Xyarthas")
            .setOfferItemList(new Item[] {Items.REDSTONE, Items.REDSTONE_BLOCK, Items.REDSTONE_ORE, Items.IRON_AXE,
                Items.IRON_SHOVEL, Items.IRON_PICKAXE, Items.GOLDEN_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_PICKAXE,
                Items.FLINT_AND_STEEL, Items.STONE_BRICKS},
        new Float[] {.03f, .27f, .12f, .5f, .5f, .5f, .8f, .8f, .8f, .2f, .1f})
            .setBadItemList(new Item[] {Items.TNT, Items.SAND},
        new Float[] {-1f, -.5f})
            .setGoodOfferResponse(new String[]{"","? A fine addition to my collection!"})
            .setNeutralOfferResponse(new String[]{"?"," Just throw it on the pile, I guess."})
            .setBadOfferResponse(new String[]{"","! Terrible. Leave me!"});

    public static GGod Reptak = new GGod("Reptak")
            .setOfferItemList(new Item[] {Items.COAL, Items.COAL_BLOCK, Items.COAL_ORE, Items.OBSIDIAN, Items.ROTTEN_FLESH,
                            Items.BONE, Items.BONE_BLOCK},
        new Float[] {.3f, 2.7f, .9f, .4f, .25f, .2f, .6f})
            .setBadItemList(new Item[] {Items.WATER_BUCKET, Items.ICE, Items.PACKED_ICE, Items.BLUE_ICE},
        new Float[] {-1f, -1f, -1f, -1f})
            .setGoodOfferResponse(new String[]{"Good. ",". The flames accept your offering"})
            .setNeutralOfferResponse(new String[]{"",".... as long as it burns."})
            .setBadOfferResponse(new String[]{"Gah! "," Trying to douse the flames?"});

    public static GGod Jaspren = new GGod("Jaspren")
            .setOfferItemList(new Item[] {Items.MOSSY_STONE_BRICKS, Items.GOLD_BLOCK, Items.GOLD_INGOT, Items.GOLD_NUGGET,
                Items.GOLD_ORE, Items.CARROT, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.POTATO, Items.BAKED_POTATO,
                Items.BREAD, Items.WHEAT, Items.BEETROOT, Items.BEETROOT_SOUP, Items.LAPIS_LAZULI, ModItems.AMETHYST.get(),
                ModItems.RUBY.get(), ModItems.SELENIUM.get(), ModItems.THUNDER_STONE.get(), ModItems.SILVER_INGOT.get()},
        new Float[] {.3f, 4.5f, .5f, .05f, 1.5f, .1f, .5f, 1f, .1f, .1f, .1f, .03f, .1f, .6f, .3f, .3f, .3f, .3f, .3f, .3f})
            .setBadItemList(new Item[] {Items.POISONOUS_POTATO, Items.WITHER_ROSE, Items.TNT, Items.FLINT_AND_STEEL, Items.GUNPOWDER,
                Items.MILK_BUCKET},
        new Float[] {-1f, -2f, -1f, -1f, -.2f, -1f})
            .setGoodOfferResponse(new String[]{"Haha! Thanks for the ","!"})
            .setNeutralOfferResponse(new String[]{"","? Maybe something shiny or tasty next time?"})
            .setBadOfferResponse(new String[]{"How dare you! Giving me "," is just rude!"});

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

    public static GGod getGod(int index)
    {
        return godList.get(index);
    }

    public static int getGodListSize() {
        return godList.size();
    }
}

//God Template
/*
public static GGod  = new GGod("")
            .setOfferItemList(new Item[] {},
                new Float[] {})
            .setBadItemList(new Item[] {},
                new Float[] {})
            .setGoodOfferResponse(new String[]{"",""})
            .setNeutralOfferResponse(new String[]{"",""})
            .setBadOfferResponse(new String[]{"",""});
 */