package com.Zyarch.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

import java.util.Collection;

public class StormBowBolt extends ArrowEntity {
    public StormBowBolt(EntityType<? extends ArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public StormBowBolt(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public StormBowBolt(World worldIn, LivingEntity shooter) {
        super(worldIn, shooter);
    }

    @Override
    public void setPotionEffect(ItemStack stack) {
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);

        if(!this.world.isRemote) {
            LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.world);
            bolt.setEffectOnly(false);
            bolt.setPosition(living.getPosX(), living.getPosY(), living.getPosZ());
            this.world.addEntity(bolt);
        }
    }
}
