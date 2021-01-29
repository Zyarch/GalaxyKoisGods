package com.Zyarch.GalaxyKoisGods;

import com.Zyarch.GalaxyKoisGods.network.GalasGodsPacketHandler;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import com.Zyarch.GalaxyKoisGods.world.gen.ModOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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

    }

    public static final ItemGroup TAB = new ItemGroup("galaxykoisgodstab") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModBlocks.ALTAR.get()); }
    };
}