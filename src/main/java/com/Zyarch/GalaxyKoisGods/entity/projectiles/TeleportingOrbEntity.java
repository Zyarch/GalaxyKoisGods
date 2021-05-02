package com.Zyarch.GalaxyKoisGods.entity.projectiles;

import com.Zyarch.GalaxyKoisGods.setup.ModEntityTypes;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import com.Zyarch.GalaxyKoisGods.events.TeleportingOrbEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

//An ender peral entity but it does not deal damage on use, and cannot spawn ender mites.
public class TeleportingOrbEntity extends ProjectileItemEntity {

   public TeleportingOrbEntity(EntityType<? extends TeleportingOrbEntity> p_i50153_1_, World world) {
        super(p_i50153_1_, world);
    }

   public TeleportingOrbEntity(World worldIn, LivingEntity throwerIn) {
        super(ModEntityTypes.TELEPORTING_ORB.get(), throwerIn, worldIn);
    }

   @OnlyIn(Dist.CLIENT)
   public TeleportingOrbEntity(World worldIn, double x, double y, double z) {
        super(ModEntityTypes.TELEPORTING_ORB.get(), x, y, z, worldIn);
    }

        protected Item getDefaultItem() {
        return ModItems.TELEPORTING_ORB.get().asItem();
    }

    protected void onImpact(RayTraceResult result) {
            super.onImpact(result);
            Entity entity = this.func_234616_v_();

            for(int i = 0; i < 32; ++i) {
                this.world.addParticle(ParticleTypes.PORTAL, this.getPosX(), this.getPosY() + this.rand.nextDouble() * 2.0D, this.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
            }

            if (!this.world.isRemote && !this.removed) {
                if (entity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entity;
                    if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
                        TeleportingOrbEvent event = new TeleportingOrbEvent(serverplayerentity, this.getPosX(), this.getPosY(), this.getPosZ());
                        if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size

                            if (entity.isPassenger()) {
                                entity.stopRiding();
                            }

                            entity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                            entity.fallDistance = 0.0F;
                        } //Forge: End
                    }
                } else if (entity != null) {
                    entity.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
                    entity.fallDistance = 0.0F;
                }

                this.remove();
            }

        }

        /**
         * Called to update the entity's position/logic.
         */
        public void tick() {
        Entity entity = this.func_234616_v_();
        if (entity instanceof PlayerEntity && !entity.isAlive()) {
            this.remove();
        } else {
            super.tick();
        }

    }

        @Nullable
        public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        Entity entity = this.func_234616_v_();
        if (entity != null && entity.world.getDimensionKey() != server.getDimensionKey()) {
            this.setShooter((Entity)null);
        }

        return super.changeDimension(server, teleporter);
    }
}