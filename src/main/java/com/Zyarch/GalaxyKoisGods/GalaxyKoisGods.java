package com.Zyarch.GalaxyKoisGods;

import com.Zyarch.GalaxyKoisGods.data.GGod;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GalaxyKoisGods.MOD_ID)
public class GalaxyKoisGods
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "galasgods";
    public static GGod godAmara;

    public GalaxyKoisGods() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Registration.register();

        MinecraftForge.EVENT_BUS.register(this);

        godAmara = new GGod("Amara").
                    setOfferItemList(Items.TOTEM_OF_UNDYING, Items.BONE_MEAL).
                    setBadItemList(Items.WITHER_ROSE);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("galaxykoisgodstab") {
        @Override
        public ItemStack createIcon() {
            return null;
        }
    };
}