package com.Zyarch.GalaxyKoisGods.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.entity.projectiles.StormBowBoltEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StormBowBoltRenderer extends ArrowRenderer<StormBowBoltEntity> {
    public static final ResourceLocation RES_ARROW = new ResourceLocation(GalaxyKoisGods.MOD_ID, "textures/entity/projectiles/bolt.png");

    public StormBowBoltRenderer(EntityRendererManager manager) {
        super(manager);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getEntityTexture(StormBowBoltEntity entity) {
        return RES_ARROW;
    }
}
