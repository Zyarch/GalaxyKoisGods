package com.Zyarch.GalaxyKoisGods.events;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onDamageSpeakAmara(AttackEntityEvent event)
    {
        if (event.getTarget().isAlive()) {
            PlayerEntity player = event.getPlayer();

            if (!event.getPlayer().getEntityWorld().isRemote)
            {
                String msg = GalaxyKoisGods.godAmara.getName();
                player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
            }
        }
    }
    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickBlock event)
    {
        /*
        ItemEntity item = event.getEntityItem();
        String itemName = item.getName().getString();
        GGod _amara = GalaxyKoisGods.godAmara;
        PlayerEntity player = event.getPlayer();
        boolean isRemote = !event.getPlayer().getEntityWorld().isRemote;

        if (_amara.isInOfferList(item.getItem()))
        {
            if (isRemote)
            {
                String msg = itemName + " is lovely!";
                player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
            }
        }
        if (_amara.isInBadList(item.getItem()))
        {
            if (isRemote)
            {
                String msg = itemName + " is terrible!";
                player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
            }
        }*/
    }
}
