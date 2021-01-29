package com.Zyarch.GalaxyKoisGods;

import com.Zyarch.GalaxyKoisGods.network.GalasGodsPacketHandler;
import com.Zyarch.GalaxyKoisGods.gods.God;
import com.Zyarch.GalaxyKoisGods.screens.AltarScreen;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import com.Zyarch.GalaxyKoisGods.world.gen.ModOreGen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.item.ItemModelsProperties.registerProperty;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GalaxyKoisGods.MOD_ID)
public class GalaxyKoisGods
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "galasgods";
    public static GalasGodsPacketHandler packetHandler;

    public GalaxyKoisGods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);

        packetHandler = new GalasGodsPacketHandler();
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModOreGen.registerOre();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainers.ALTAR_CONTAINER.get(), AltarScreen::new);
        God.populateGodList();

        ItemModelsProperties.registerProperty(ModItems.STORM_BOW.get(), new ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> {
            if (p_239429_2_ == null) {
                return 0.0F;
            } else {
                return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
            }
        });
        ItemModelsProperties.registerProperty(ModItems.STORM_BOW.get(), new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
            return p_239428_2_ != null && p_239428_2_.isHandActive() && p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
        });
    }

    public static final ItemGroup TAB = new ItemGroup("galaxykoisgodstab") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModBlocks.ALTAR.get()); }
    };
}