package com.Zyarch.entity.projectiles;

import com.Zyarch.GalaxyKoisGods.setup.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;


public class StormBowBoltEntity extends AbstractArrowEntity {
    public StormBowBoltEntity(EntityType<? extends StormBowBoltEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public StormBowBoltEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.STORM_BOW_BOLT.get(), x, y, z, worldIn);
    }

    public StormBowBoltEntity(World worldIn, LivingEntity shooter) {
        super(ModEntityTypes.STORM_BOW_BOLT.get(), shooter, worldIn);
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

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected ItemStack getArrowStack() {
        return ItemStack.EMPTY;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        super.handleStatusUpdate(id);
    }
}
