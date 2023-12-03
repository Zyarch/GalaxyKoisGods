package com.zyarch.galaxykoisgods.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.entity.projectiles.StormBowBolt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class StormBowBoltRenderer extends ArrowRenderer<StormBowBolt> {
    public static final ResourceLocation RES_ARROW = new ResourceLocation(GalaxyKoisGods.MODID, "textures/entity/projectiles/bolt.png");

    public StormBowBoltRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(StormBowBolt entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, 15728880);
    }

    @Override
    @NotNull
    public ResourceLocation getTextureLocation(StormBowBolt entity) {
        return RES_ARROW;
    }
}
