package com.zyarch.galaxykoisgods.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.client.models.CultistModel;
import com.zyarch.galaxykoisgods.client.models.CultistRobeLayer;
import com.zyarch.galaxykoisgods.entity.monster.Cultist;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CultistRenderer extends HumanoidMobRenderer<Cultist, CultistModel<Cultist>> {
    private static final ResourceLocation RES_LOCATION = new ResourceLocation(GalaxyKoisGods.MODID, "textures/entity/cultist.png");

    public CultistRenderer(EntityRendererProvider.Context renderContext) {
        this(renderContext,
                new CultistModel<>(renderContext.bakeLayer(ModelLayers.PLAYER)),
                new CultistModel<>(renderContext.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new CultistModel<>(renderContext.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)));
    }

    public <T extends CultistModel<Cultist>> CultistRenderer(EntityRendererProvider.Context renderContext, T model, T innerArmorModel, T outerArmorModel) {
        super(renderContext, model, 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this, innerArmorModel, outerArmorModel, renderContext.getModelManager()));
        this.addLayer(new CultistRobeLayer<>(this, renderContext.getModelSet()));
    }
    @Override
    @NotNull
    public ResourceLocation getTextureLocation(@NotNull Cultist p_113771_) {
        return RES_LOCATION;
    }

    protected void scale(Cultist p_117798_, PoseStack p_117799_, float p_117800_) {
        float f = 0.9375F;
        p_117799_.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
