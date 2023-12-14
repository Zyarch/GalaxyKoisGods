package com.zyarch.galaxykoisgods.client.models;

// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class MermaidBottomModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(GalaxyKoisGods.MODID, "cultistroberenderer"), "main");
    public final ModelPart fish_tail;
    public final ModelPart[] bones;

    public MermaidBottomModel(ModelPart root) {
        super(root);
        this.fish_tail = root.getChild("fish_tail");
        bones = new ModelPart[5];
        bones[0] = this.fish_tail.getChild("b1");
        bones[1] = bones[0].getChild("b2");
        bones[2] = bones[1].getChild("b3");
        bones[3] = bones[2].getChild("b4");
        bones[4] = bones[3].getChild("flipper");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

        PartDefinition fish_tail = partdefinition.addOrReplaceChild("fish_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition b1 = fish_tail.addOrReplaceChild("b1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition b2 = b1.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -1.0F));

        PartDefinition b3 = b2.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(22, 17).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition b4 = b3.addOrReplaceChild("b4", CubeListBuilder.create().texOffs(24, 10).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition flipper = b4.addOrReplaceChild("flipper", CubeListBuilder.create().texOffs(1, 21).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        this.fish_tail.copyFrom(this.body);
        for(ModelPart part : this.bones) {
            part.xRot = this.body.xRot;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.fish_tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setAllVisible(boolean p_102880_) {
        super.setAllVisible(p_102880_);
        for(ModelPart part : this.bones) {
            part.visible = p_102880_;
        }
    }
}
