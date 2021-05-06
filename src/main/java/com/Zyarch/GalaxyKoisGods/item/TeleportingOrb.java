package com.Zyarch.GalaxyKoisGods.item;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.entity.projectiles.TeleportingOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class TeleportingOrb extends Item {

    public TeleportingOrb() {
        super(new Properties().maxStackSize(1).group(GalaxyKoisGods.TAB));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker().setCooldown(this, 1); //normally 100 ticks
        if (!worldIn.isRemote) {
            TeleportingOrbEntity teleportingorbentity = new TeleportingOrbEntity(worldIn, playerIn);
            teleportingorbentity.setItem(itemstack);
            teleportingorbentity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(teleportingorbentity);
        }

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}
