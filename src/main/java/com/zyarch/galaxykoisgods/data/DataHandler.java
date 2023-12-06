package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.gods.God;
import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.fml.LogicalSide;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class DataHandler {
    public static HashMap<UUID, PlayerData> playerDataList = new HashMap<>();
    public static void load(UUID uuid, CompoundTag compound, PlayerData pData) throws Exception {
        pData.clearFavor();

        if(compound.contains("currentFavor"))
        {
            ListTag list = compound.getList("currentFavor", Tag.TAG_STRING);
            String[] data;

            if(GalasGods.getGodListSize() != list.size())
                throw new Exception("error while loading god favor data: some data is missing!");

            for(int i = 0; i < list.size(); i++)
            {
                data = list.getString(i).split(":");
                pData.add(data[0], Float.parseFloat(data[1]));
            }
        }
    }

    public static void store(UUID pUI, CompoundTag compound, PlayerData pData) throws Exception {
        ListTag favorList = new ListTag();
        God god;

        for(int i = 0; i < GalasGods.getGodListSize(); i++)
        {
            god = GalasGods.getGod(i);
            favorList.add(StringTag.valueOf(god.getName() + ":" + pData.getFavor(god)));
        }

        compound.put("currentFavor", favorList);

        File playerFile = new File(getPlayerDirectory(), pUI.toString() + ".GGods");
        NbtIo.writeCompressed(compound, playerFile);
    }

    public static void loadPlayerData(@Nullable Player player, LogicalSide side, PlayerData pData) throws Exception {
        if (side == LogicalSide.SERVER && player instanceof ServerPlayer) {
            getProgressServer((ServerPlayer) player, pData);
        }
    }

    private static void getProgressServer(ServerPlayer player, PlayerData pData) throws Exception {
        UUID ui = player.getUUID();
        File playerFile = getPlayerFile(ui, pData);
        load(ui, NbtIo.readCompressed(playerFile), pData);
    }

    private static File getPlayerFile(UUID pUI, PlayerData pData){
        File f = new File(getPlayerDirectory(), pUI.toString() + ".GGods");
        if (!f.exists()) {
            try {
                store(pUI, new CompoundTag(), pData);
            } catch (IOException ignored) {} //Will be created later anyway... just as fail-safe.
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f;
    }

    private static File getPlayerDirectory() {
        File pDir = new File(getGGDirectory(), "playerdata");

        if (!pDir.exists()) {
            pDir.mkdirs();
        }
        return pDir;
    }

    private static File getGGDirectory()
    {
        Optional<Level> optionalLevel = LogicalSidedProvider.CLIENTWORLD.get(LogicalSide.SERVER);

        if(optionalLevel.isEmpty()) {
            return null;
        }

        MinecraftServer server = optionalLevel.get().getServer();

        if (server == null) {
            return null;
        }

        File asDataDir = server.getFile(GalaxyKoisGods.MODID);

        if (!asDataDir.exists()) {
            if(!asDataDir.mkdirs()) {
                CommonUtility.LOGGER.error("Failed to create all directories!");
            }
        }
        return asDataDir;
    }
}
