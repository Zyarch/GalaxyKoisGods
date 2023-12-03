package com.zyarch.galaxykoisgods.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.entity.projectiles.ThrownTeleportingOrb;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeleportingOrbRenderer extends EntityRenderer<ThrownTeleportingOrb> {
    public static final ResourceLocation RES_ORB = new ResourceLocation(GalaxyKoisGods.MODID, "textures/entity/projectiles/teleporting_orb.png");

    public TeleportingOrbRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(ThrownTeleportingOrb entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, 15728880);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(ThrownTeleportingOrb entity) {
        return RES_ORB;
    }
}
