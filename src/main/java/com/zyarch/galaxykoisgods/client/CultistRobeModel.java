package com.zyarch.galaxykoisgods.client;

// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class CultistRobeModel<T extends LivingEntity> extends HumanoidModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("minecraft:player"), "cult_robe");
    public ModelPart backFlap;
    public ModelPart rightFlap;
    public ModelPart leftFlap;
    public ModelPart right_foot;
    public ModelPart left_foot;

    public CultistRobeModel(ModelPart root) {
        super(root);
        this.backFlap = root.getChild("body").getChild("BackFlap_r1");
        this.rightFlap = root.getChild("body").getChild("RightFlap_r1");
        this.leftFlap = root.getChild("body").getChild("LeftFlap_r1");
        this.right_foot = root.getChild("right_foot");
        this.left_foot = root.getChild("left_foot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        float scale = 0.25F;

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(scale)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 5.0F));

        cube_r1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -27.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(scale)), PartPose.offsetAndRotation(0.0F, 25.0F, -5.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 4.0F));

        cube_r2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -29.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(scale)), PartPose.offsetAndRotation(0.0F, 25.0F, -4.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 3.0F));

        cube_r3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 7).addBox(-3.0F, -30.0F, 1.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(scale)), PartPose.offsetAndRotation(0.0F, 27.0F, -3.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(4, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(scale)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition RigthFlap_r1 = body.addOrReplaceChild("RightFlap_r1", CubeListBuilder.create(), PartPose.offset(-3.0F, 11.0F, 0.0F));

        RigthFlap_r1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(10, 42).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(scale + 0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition LeftFlap_r1 = body.addOrReplaceChild("LeftFlap_r1", CubeListBuilder.create(), PartPose.offset(4.0F, 11.0F, 0.0F));

        LeftFlap_r1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, 1.0F, -2.0F, 1.0F, 9.0F, 4.0F, new CubeDeformation(scale + 0.25F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition BackFlap_r1 = body.addOrReplaceChild("BackFlap_r1", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 2.0F));

        BackFlap_r1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, 1.0F, 1.0F, 6.0F, 9.0F, 1.0F, new CubeDeformation(scale + 0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.3054F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(scale)), PartPose.offset(-6.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(scale)), PartPose.offset(6.0F, 2.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(scale)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(scale + 0.25F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(scale)), PartPose.offset(2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(scale + 0.25F)), PartPose.offset(2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        this.right_foot.copyFrom(this.rightLeg);
        this.left_foot.copyFrom(this.leftLeg);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setAllVisible(boolean p_102880_) {
        super.setAllVisible(p_102880_);
        this.right_foot.visible = p_102880_;
        this.left_foot.visible = p_102880_;
    }
}