package com.Zyarch.GalaxyKoisGods;

import com.Zyarch.GalaxyKoisGods.data.GGod;
import com.Zyarch.GalaxyKoisGods.data.client.GalasGodsPacketHandler;
import com.Zyarch.GalaxyKoisGods.screens.AltarScreen;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GalaxyKoisGods.MOD_ID)
public class GalaxyKoisGods
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "galasgods";
    public static GGod godAmara;
    public static GGod godKelDerash;
    public static GalasGodsPacketHandler packetHandler;

    public GalaxyKoisGods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);

        packetHandler = new GalasGodsPacketHandler();

        godAmara = new GGod("Amara").
                    setOfferItemList(Items.TOTEM_OF_UNDYING, Items.BONE_MEAL).
                    setBadItemList(Items.WITHER_ROSE);
        godKelDerash = new GGod("Kel-derash").
                    setOfferItemList(Items.TNT, Items.GUNPOWDER, Items.CACTUS, Items.DEAD_BUSH, Items.MELON, Items.MELON_SLICE).
                    setBadItemList(Items.WHEAT_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS,
                                    Items.WHEAT, Items.PUMPKIN,
                                    Items.CORNFLOWER, Items.SUNFLOWER, Items.ROSE_BUSH, Items.LILY_OF_THE_VALLEY,
                                    Items.DANDELION, Items.POPPY, Items.BLUE_ORCHID, Items.ALLIUM, Items.AZURE_BLUET,
                                    Items.ORANGE_TULIP, Items.RED_TULIP, Items.PINK_TULIP, Items.WHITE_TULIP,
                                    Items.OXEYE_DAISY, Items.LILAC, Items.PEONY);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainers.ALTAR_CONTAINER.get(), AltarScreen::new);
    }

    public static final ItemGroup TAB = new ItemGroup("galaxykoisgodstab") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModBlocks.ALTAR.get()); }
    };
}