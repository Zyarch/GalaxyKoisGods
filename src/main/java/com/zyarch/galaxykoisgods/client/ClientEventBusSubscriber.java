package com.zyarch.galaxykoisgods.client;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.gods.OfferEntries;
import com.zyarch.galaxykoisgods.setup.GalasEntityTypes;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void onClientSetUp(FMLClientSetupEvent event)
    {
        //register the Altar Container with the Altar Screen
//        ScreenManager.registerFactory(ModContainers.ALTAR_CONTAINER.get(), AltarScreen::new);
//        ScreenManager.registerFactory(ModContainers.DIVINE_INFUSER_CONTAINER.get(), DivineInfuserScreen::new);
//
        //Populate God list
        OfferEntries.initialize();
        GalasGods.populateGodList();

        //Register item properties for Storm Bow animation
        event.enqueueWork(() -> {
            ItemProperties.register(GalasItems.STORM_BOW.get(), new ResourceLocation("pull"), (stack, level, living, id) -> {
                if (living == null) {
                    return 0.0F;
                } else {
                    return living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(GalasItems.STORM_BOW.get(), new ResourceLocation("pulling"),
                    (stack, level, living, id) -> living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);
        });
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //register the Storm Bow Bolt Entity Type with the Storm Bow Renderer
        event.registerEntityRenderer(GalasEntityTypes.STORM_BOW_BOLT.get(), StormBowBoltRenderer::new);

        //register the Teleporting Orb Entity Type with the Teleporting Orb Renderer
        event.registerEntityRenderer(GalasEntityTypes.TELEPORTING_ORB.get(), TeleportingOrbRenderer::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CultistRobeModel.LAYER_LOCATION, CultistRobeModel::createBodyLayer);
    }
}