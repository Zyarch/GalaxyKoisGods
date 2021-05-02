package com.Zyarch.GalaxyKoisGods.events;
/*
 * Minecraft Forge
 * Copyright (c) 2016-2020.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraft.entity.LivingEntity;

/**
 * Event for when an Enderman/Shulker teleports or an ender pearl is used.  Can be used to either modify the target position, or cancel the teleport outright.
 * @author Mithion
 *
 * Stolen from Mithion, used for when an orb teleports a player. Removes the damage taken.
 */
@Cancelable
public class TeleportingOrbEvent extends LivingEvent
{

    private double targetX;
    private double targetY;
    private double targetZ;
    private float attackDamage;

    public TeleportingOrbEvent(LivingEntity entity, double targetX, double targetY, double targetZ)
    {
        super(entity);
        this.setTargetX(targetX);
        this.setTargetY(targetY);
        this.setTargetZ(targetZ);
        this.setAttackDamage(0f);
    }

    public double getTargetX() { return targetX; }
    public void setTargetX(double targetX) { this.targetX = targetX; }
    public double getTargetY() { return targetY; }
    public void setTargetY(double targetY) { this.targetY = targetY; }
    public double getTargetZ() { return targetZ; }
    public void setTargetZ(double targetZ) { this.targetZ = targetZ; }
    public float getAttackDamage() { return attackDamage; }
    public void setAttackDamage(float attackDamage) { this.attackDamage = attackDamage; }
}

