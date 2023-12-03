package com.zyarch.galaxykoisgods.entity.projectiles;

import javax.annotation.Nullable;

import com.zyarch.galaxykoisgods.setup.GalasEntityTypes;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import com.zyarch.galaxykoisgods.event.TeleportingOrbEvent;

public class ThrownTeleportingOrb extends ThrowableItemProjectile {
    public ThrownTeleportingOrb(EntityType<ThrownTeleportingOrb> thrownTeleportingOrb, Level level) {
        super(thrownTeleportingOrb, level);
    }

    public ThrownTeleportingOrb(Level level, LivingEntity livingEntity) {
        super(GalasEntityTypes.TELEPORTING_ORB.get(), livingEntity, level);
    }

    protected Item getDefaultItem() {
        return GalasItems.TELEPORTING_ORB.get();
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        entityHitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        for(int i = 0; i < 32; ++i) {
            this.level().addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.level().isClientSide && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverplayer = (ServerPlayer)entity;
                if (serverplayer.connection.isAcceptingMessages() && serverplayer.level() == this.level() && !serverplayer.isSleeping()) {
                    TeleportingOrbEvent event = new TeleportingOrbEvent(serverplayer, this.getX(), this.getY(), this.getZ(), this);
                    if (!event.isCanceled()) { // Don't indent to lower patch size

                        if (entity.isPassenger()) {
                            serverplayer.dismountTo(this.getX(), this.getY(), this.getZ());
                        } else {
                            entity.teleportTo(this.getX(), this.getY(), this.getZ());
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.resetFallDistance();
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.resetFallDistance();
            }

            this.discard();
        }

    }

    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }

    @Nullable
    public Entity changeDimension(ServerLevel serverLevel, net.minecraftforge.common.util.ITeleporter teleporter) {
        Entity entity = this.getOwner();
        if (entity != null && entity.level().dimension() != serverLevel.dimension()) {
            this.setOwner((Entity)null);
        }

        return super.changeDimension(serverLevel, teleporter);
    }
}
