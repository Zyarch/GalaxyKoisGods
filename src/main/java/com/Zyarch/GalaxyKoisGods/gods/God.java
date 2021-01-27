package com.Zyarch.GalaxyKoisGods.gods;

import net.minecraft.item.Items;

public class God {

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