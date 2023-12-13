package com.zyarch.galaxykoisgods.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CultistRobeLayer <T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {
    private final CultistRobeModel<T> model;

    public CultistRobeLayer(RenderLayerParent<T, M> p_174493_, EntityModelSet p_174494_) {
        super(p_174493_);
        this.model = new CultistRobeModel<>(p_174494_.bakeLayer(CultistRobeModel.LAYER_LOCATION));
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int p_117351_, T entity,
                       float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.setupAnim(entity, p_117353_, p_117354_, p_117356_, p_117357_, p_117358_);

        this.model.backFlap.xRot = (entity.walkDist - entity.walkDistO) * 12.0F * 32.0F * Mth.DEG_TO_RAD;
        this.model.rightFlap.xRot = (entity.walkDist - entity.walkDistO) * 9.0F * 32.0F * Mth.DEG_TO_RAD;
        this.model.leftFlap.xRot = (entity.walkDist - entity.walkDistO) * 9.0F * 32.0F * Mth.DEG_TO_RAD;

        renderArmorPiece(poseStack, multiBufferSource, entity, EquipmentSlot.HEAD, p_117351_);
        renderArmorPiece(poseStack, multiBufferSource, entity, EquipmentSlot.CHEST, p_117351_);
        renderArmorPiece(poseStack, multiBufferSource, entity, EquipmentSlot.LEGS, p_117351_);
        renderArmorPiece(poseStack, multiBufferSource, entity, EquipmentSlot.FEET, p_117351_);
    }
    protected void setPartVisibility(CultistRobeModel model, EquipmentSlot p_117127_) {
        model.setAllVisible(false);
        switch (p_117127_) {
            case HEAD:
                model.head.visible = true;
                model.hat.visible = true;
                break;
            case CHEST:
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
                break;
            case LEGS:
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
                break;
            case FEET:
                model.right_foot.visible = true;
                model.left_foot.visible = true;
                break;
        }
    }

    private void renderArmorPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, T p_117121_, EquipmentSlot equipmentSlot, int p_117123_) {
        ItemStack itemstack = p_117121_.getItemBySlot(equipmentSlot);
        Item item = itemstack.getItem();
        if (item instanceof ArmorItem armoritem) {
            if (armoritem.getEquipmentSlot() == equipmentSlot) {
                setPartVisibility(this.model, equipmentSlot);
                VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(multiBufferSource, RenderType.armorCutoutNoCull(getArmorTexture()), false, false);
                this.model.renderToBuffer(poseStack, vertexconsumer, p_117123_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    private ResourceLocation getArmorTexture() {
        return new ResourceLocation(GalaxyKoisGods.MODID, CommonUtility.getPathToArmorTexture(
                "cult_robe_layer0.png"));
    }
}
