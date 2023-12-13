package com.zyarch.galaxykoisgods.client;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.client.models.CultistRobeLayer;
import com.zyarch.galaxykoisgods.client.models.CultistRobeModel;
import com.zyarch.galaxykoisgods.client.models.MermaidBottomLayer;
import com.zyarch.galaxykoisgods.client.models.MermaidBottomModel;
import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.gods.OfferEntries;
import com.zyarch.galaxykoisgods.screens.AltarContainerScreen;
import com.zyarch.galaxykoisgods.screens.DivineInfuserScreen;
import com.zyarch.galaxykoisgods.setup.GalasEntityTypes;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import com.zyarch.galaxykoisgods.setup.GalasMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
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
        //register the menus with screens
        MenuScreens.register(GalasMenus.ALTAR.get(), AltarContainerScreen::new);
        MenuScreens.register(GalasMenus.DIVINE_INFUSER_MENU.get(), DivineInfuserScreen::new);

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
        event.registerLayerDefinition(MermaidBottomModel.LAYER_LOCATION, MermaidBottomModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.AddLayers event) {
        EntityModelSet set = event.getEntityModels();

        //To Player
        LivingEntityRenderer renderer = event.getRenderer(EntityType.PLAYER);
        if (renderer != null) renderer.addLayer(new CultistRobeLayer<>(renderer, set));
        renderer = event.getSkin("default");
        if (renderer != null) renderer.addLayer(new CultistRobeLayer<>(renderer, set));
        renderer = event.getSkin("slim");
        if (renderer != null) renderer.addLayer(new CultistRobeLayer<>(renderer, set));

        renderer = event.getRenderer(EntityType.PLAYER);
        if (renderer != null) renderer.addLayer(new MermaidBottomLayer<>(renderer, set));
        renderer = event.getSkin("default");
        if (renderer != null) renderer.addLayer(new MermaidBottomLayer<>(renderer, set));
        renderer = event.getSkin("slim");
        if (renderer != null) renderer.addLayer(new MermaidBottomLayer<>(renderer, set));
    }
}