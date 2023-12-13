package com.zyarch.galaxykoisgods.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.item.CharmOfSeaTreader;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;

@OnlyIn(Dist.CLIENT)
public class MermaidBottomLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {
    private final MermaidBottomModel<T> model;
    private float animationStep = 0;

    public MermaidBottomLayer(RenderLayerParent<T, M> p_174493_, EntityModelSet p_174494_) {
        super(p_174493_);
        this.model = new MermaidBottomModel<>(p_174494_.bakeLayer(MermaidBottomModel.LAYER_LOCATION));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, T entity,
                       float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        EquipmentSlot equipmentSlot = EquipmentSlot.LEGS;
        ItemStack itemstack = entity.getItemBySlot(equipmentSlot);
        Item item = itemstack.getItem();
        M parentModel = this.getParentModel();

        parentModel.copyPropertiesTo(this.model);
        this.model.setupAnim(entity, p_117353_, p_117354_, p_117356_, p_117357_, p_117358_);

        animationStep += (float) (entity.getDeltaMovement().length() * 0.28f);
        for(ModelPart part : this.model.bones) {
            part.xRot += Mth.sin(animationStep) * 12.0F * Mth.DEG_TO_RAD;
        }

        if (item instanceof CharmOfSeaTreader charm) {
            if (charm.getEquipmentSlot() == equipmentSlot && entity.isInWater() && entity.isSwimming()) {
                VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(multiBufferSource, RenderType.armorCutoutNoCull(getArmorTexture()), false, false);
                this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    private ResourceLocation getArmorTexture() {
        return new ResourceLocation(GalaxyKoisGods.MODID, CommonUtility.getPathToArmorTexture(
                "mermaid_bottom.png"));
    }
}
