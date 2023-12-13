// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class CultistRobeRenderer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "cultistroberenderer"), "main");
	private final ModelPart fish_tail;

	public CultistRobeRenderer(ModelPart root) {
		this.fish_tail = root.getChild("fish_tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fish_tail = partdefinition.addOrReplaceChild("fish_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition b1 = fish_tail.addOrReplaceChild("b1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition b2 = b1.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, 5.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition b3 = b2.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(22, 17).addBox(-3.0F, 11.0F, -2.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition b4 = b3.addOrReplaceChild("b4", CubeListBuilder.create().texOffs(24, 10).addBox(-2.0F, 15.0F, -2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flipper = b4.addOrReplaceChild("flipper", CubeListBuilder.create().texOffs(1, 21).addBox(-5.0F, 18.0F, -1.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fish_tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}