package com.Zyarch.GalaxyKoisGods.util;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.client.StormBowBoltRenderer;
import com.Zyarch.GalaxyKoisGods.gods.God;
import com.Zyarch.GalaxyKoisGods.screens.AltarScreen;
import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import com.Zyarch.GalaxyKoisGods.setup.ModEntityTypes;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void onClientSetUp(FMLClientSetupEvent event)
    {
        //register the Altar Container with the Altar Screen
        ScreenManager.registerFactory(ModContainers.ALTAR_CONTAINER.get(), AltarScreen::new);

        //Populate God list
        God.populateGodList();

        //Register item properties for Storm Bow animation
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

        //register the Storm Bow Bolt Entity Type with the Storm Bow Renderer
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STORM_BOW_BOLT.get(), StormBowBoltRenderer::new);
    }

    //@SubscribeEvent
    //public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
    //{
    //    ModSpawnEggItem.initSpawnEggs();
    //}
}