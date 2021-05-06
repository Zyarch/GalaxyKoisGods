package com.Zyarch.GalaxyKoisGods.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.entity.projectiles.TeleportingOrbEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeleportingOrbRenderer extends EntityRenderer<TeleportingOrbEntity> {
    public static final ResourceLocation RES_ORB = new ResourceLocation(GalaxyKoisGods.MOD_ID, "textures/entity/projectiles/teleporting_orb.png");

    public TeleportingOrbRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public void render(TeleportingOrbEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, 15728880);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(TeleportingOrbEntity entity) {
        return RES_ORB;
    }
}
