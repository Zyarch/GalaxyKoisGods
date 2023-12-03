package com.zyarch.galaxykoisgods.entity.projectiles;

package com.Zyarch.GalaxyKoisGods.entity.projectiles;

import com.zyarch.galaxykoisgods.setup.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
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

    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);

        if (!this.world.isRemote) {
            LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.world);
            bolt.setEffectOnly(false);
            bolt.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
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
