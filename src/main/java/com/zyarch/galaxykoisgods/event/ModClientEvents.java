package com.zyarch.galaxykoisgods.event;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.data.DataHandler;
import com.zyarch.galaxykoisgods.data.FavorSavedData;
import com.zyarch.galaxykoisgods.data.PlayerData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        System.out.println("Player joined: " + player.getDisplayName().getString());

        //Server will save references to player data for later
        if(!level.isClientSide) {
            PlayerData playerData = new PlayerData();
            DataHandler.playerDataList.put(player.getUUID(), playerData);
            FavorSavedData loadedData = FavorSavedData.load(player.getServer(), player.getUUID().toString());
            DataHandler.favorDataList.put(player.getUUID(), loadedData);

            loadedData.loadToPlayerData(playerData);
        }
    }
}
