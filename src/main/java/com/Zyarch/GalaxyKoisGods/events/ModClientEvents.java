package com.Zyarch.GalaxyKoisGods.events;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.data.DataHandler;
import com.Zyarch.GalaxyKoisGods.data.PlayerData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) throws Exception {
        PlayerEntity player = event.getPlayer();
        World world = player.world;
        PlayerData pd = new PlayerData();

        System.out.println("Player joined: " + player.getDisplayName().getString());

        DataHandler.loadPlayerData(event.getPlayer(), LogicalSide.SERVER, pd);

        //Server will save references to player data for later
        if(!world.isRemote) {
            System.out.println("This is the server side");
            DataHandler.playerDataList.put(player.getUniqueID(), pd);
        }
        else
            System.out.println("This is the client side");
    }
}
