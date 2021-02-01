package com.Zyarch.GalaxyKoisGods.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.entity.projectiles.StormBowBoltEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StormBowBoltRenderer extends ArrowRenderer<StormBowBoltEntity> {
    public static final ResourceLocation RES_ARROW = new ResourceLocation(GalaxyKoisGods.MOD_ID, "textures/entity/projectiles/bolt.png");

    public StormBowBoltRenderer(EntityRendererManager manager) {
        super(manager);
    }

    public void render(StormBowBoltEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, 15728880);
    }

    /*protected int getBlockLight(StormBowBoltRenderer entityIn, BlockPos partialTicks) {
        return 15;
    }*/
    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(StormBowBoltEntity entity) {
        return RES_ARROW;
    }
}
