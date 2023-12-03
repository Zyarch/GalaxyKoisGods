package com.zyarch.galaxykoisgods.event;

import com.zyarch.galaxykoisgods.entity.Projectiles.ThrownTeleportingOrb;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import org.jetbrains.annotations.ApiStatus;

@Cancelable
public class TeleportingOrbEvent extends EntityTeleportEvent
{
    private final ServerPlayer player;
    private final ThrownTeleportingOrb thrownTeleportingOrbEntity;

    @ApiStatus.Internal
    public TeleportingOrbEvent(ServerPlayer entity, double targetX, double targetY, double targetZ, ThrownTeleportingOrb thrownTeleportingOrbEntity)
    {
        super(entity, targetX, targetY, targetZ);
        this.thrownTeleportingOrbEntity = thrownTeleportingOrbEntity;
        this.player = entity;
    }

    public ThrownTeleportingOrb getTeleportingOrbEntity()
    {
        return thrownTeleportingOrbEntity;
    }

    public ServerPlayer getPlayer()
    {
        return player;
    }
}
