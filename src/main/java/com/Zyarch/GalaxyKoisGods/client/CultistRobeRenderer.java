package com.Zyarch.GalaxyKoisGods.client;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class CultistRobeRenderer extends BipedModel<LivingEntity> {
    public ModelRenderer Head;
    public ModelRenderer cube_r1;
    public ModelRenderer cube_r2;
    public ModelRenderer cube_r3;
    public ModelRenderer Body;
    public ModelRenderer RigthFlap_r1;
    public ModelRenderer LeftFlap_r1;
    public ModelRenderer BackFlap_r1;
    public ModelRenderer FrontFlap_r1;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;

    public CultistRobeRenderer(float modelSize) {
        super(modelSize - 0.25f);
        modelSize -= 0.25f;
        textureWidth = 64;
        textureHeight = 64;

        this.Head = new ModelRenderer(this);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, modelSize);

        this.cube_r1 = new ModelRenderer(this);
        this.cube_r1.setRotationPoint(0.0F, -1.0F, 5.0F);
        this.Head.addChild(this.cube_r1);
        setRotationAngle(this.cube_r1, -0.3491F, 0.0F, 0.0F);
        this.cube_r1.setTextureOffset(48, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, modelSize);

        this.cube_r2 = new ModelRenderer(this);
        this.cube_r2.setRotationPoint(0.0F, -1.0F, 4.0F);
        this.Head.addChild(this.cube_r2);
        setRotationAngle(this.cube_r2, -0.2618F, 0.0F, 0.0F);
        this.cube_r2.setTextureOffset(32, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 2.0F, modelSize);

        this.cube_r3 = new ModelRenderer(this);
        this.cube_r3.setRotationPoint(0.0F, -3.0F, 3.0F);
        this.Head.addChild(this.cube_r3);
        setRotationAngle(this.cube_r3, -0.1745F, 0.0F, 0.0F);
        this.cube_r3.setTextureOffset(32, 7).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 6.0F, 3.0F, modelSize);

        this.Body = new ModelRenderer(this);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.setTextureOffset(4, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize);

        this.RigthFlap_r1 = new ModelRenderer(this);
        this.RigthFlap_r1.setRotationPoint(-3.0F, 11.0F, 0.0F);
        this.Body.addChild(this.RigthFlap_r1);
        setRotationAngle(this.RigthFlap_r1, 0.0F, 0.0F, 0.1745F);
        this.RigthFlap_r1.setTextureOffset(24, 32).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, modelSize);

        this.LeftFlap_r1 = new ModelRenderer(this);
        this.LeftFlap_r1.setRotationPoint(4.0F, 11.0F, 0.0F);
        this.Body.addChild(this.LeftFlap_r1);
        setRotationAngle(this.LeftFlap_r1, 0.0F, 0.0F, -0.1745F);
        this.LeftFlap_r1.setTextureOffset(0, 32).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 7.0F, 4.0F, modelSize);

        this.BackFlap_r1 = new ModelRenderer(this);
        this.BackFlap_r1.setRotationPoint(0.0F, 11.0F, 2.0F);
        this.Body.addChild(this.BackFlap_r1);
        setRotationAngle(this.BackFlap_r1, 0.3491F, 0.0F, 0.0F);
        this.BackFlap_r1.setTextureOffset(34, 35).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 7.0F, 1.0F, modelSize);

        this.FrontFlap_r1 = new ModelRenderer(this);
        this.FrontFlap_r1.setRotationPoint(0.0F, 11.0F, -2.0F);
        this.Body.addChild(this.FrontFlap_r1);
        setRotationAngle(this.FrontFlap_r1, -0.3491F, 0.0F, 0.0F);
        this.FrontFlap_r1.setTextureOffset(10, 35).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 1.0F, modelSize);

        this.RightArm = new ModelRenderer(this);
        this.RightArm.setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.RightArm.setTextureOffset(48, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);

        this.LeftArm = new ModelRenderer(this);
        this.LeftArm.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.LeftArm.setTextureOffset(32, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
    }
    //@Override
    //protected Iterable<ModelRenderer> getHeadParts() {
    //    return ImmutableList.of(this.Head);
    //}
//
    //@Override
    //protected Iterable<ModelRenderer> getBodyParts() {
    //    return ImmutableList.of(this.Body, this.RightArm, this.LeftArm);
    //}

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        float leftLegRotationX = this.bipedLeftLeg.rotateAngleX;
        float rightLegRotationX = this.bipedRightLeg.rotateAngleX;

        this.Head.copyModelAngles(this.bipedHead);
        this.Body.copyModelAngles(this.bipedBody);
        this.RightArm.copyModelAngles(this.bipedRightArm);
        this.LeftArm.copyModelAngles(this.bipedLeftArm);

        this.BackFlap_r1.rotateAngleX = Math.max(Math.max(0.3491F, leftLegRotationX + 0.3491F), rightLegRotationX + 0.3491F);
        this.FrontFlap_r1.rotateAngleX = Math.min(Math.min(-0.3491F, leftLegRotationX - 0.3491F), rightLegRotationX - 0.3491F);

        this.bipedHead = this.Head;
        this.bipedBody = this.Body;
        this.bipedLeftArm = this.LeftArm;
        this.bipedRightArm = this.RightArm;

        this.bipedHeadwear.showModel = false;

        super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        //this.Head.render(matrixStack, buffer, packedLight, packedOverlay);
        //Body.render(matrixStack, buffer, packedLight, packedOverlay);
        //RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        //LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
    }


    public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        //this.Head.copyModelAngles(this.bipedHead);
        //this.Body.copyModelAngles(this.bipedBody);
        //this.RightArm.copyModelAngles(this.bipedRightArm);
        //this.LeftArm.copyModelAngles(this.bipedLeftArm);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}