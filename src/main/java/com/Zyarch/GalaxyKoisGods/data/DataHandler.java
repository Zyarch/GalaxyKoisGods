package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.FolderName;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class DataHandler {
    public static HashMap<UUID, PlayerData> playerDataList = new HashMap<UUID, PlayerData>();
    public static void load(UUID pUI, CompoundNBT compound, PlayerData pData) throws Exception {
        pData.clearFavor();

        if(compound.contains("currentFavor"))
        {
            ListNBT list = compound.getList("currentFavor", Constants.NBT.TAG_STRING);
            String[] data;

            if(God.getGodListSize() != list.size())
                throw new Exception("error while loading god favor data: some sata is missing!");

            for(int i = 0; i < list.size(); i++)
            {
                data = list.getString(i).split(":");
                pData.add(data[0], Integer.parseInt(data[1]));
            }
        }
    }

    public static void store(UUID pUI, CompoundNBT compound, PlayerData pData) throws Exception {
        ListNBT favorList = new ListNBT();
        GGod god;

        for(int i = 0; i < God.getGodListSize(); i++)
        {
            god = God.getGod(i);
            favorList.add(StringNBT.valueOf(god.getName() + ":" + pData.getFavor(god)));
        }

        compound.put("currentFavor", favorList);

        File playerFile = new File(getPlayerDirectory(), pUI.toString() + ".GGods");;
        CompressedStreamTools.write(compound, playerFile);
    }

    @Nonnull
    public static void loadPlayerData(@Nullable PlayerEntity player, LogicalSide side, PlayerData pData) throws Exception {
        if (side == LogicalSide.SERVER && player instanceof ServerPlayerEntity) {
            getProgressServer((ServerPlayerEntity) player, pData);
        }
    }

    @Nonnull
    private static void getProgressServer(ServerPlayerEntity player, PlayerData pData) throws Exception {
        UUID ui = player.getUniqueID();
        File playerFile = getPlayerFile(ui, pData);
        load(ui, CompressedStreamTools.read(playerFile), pData);
    }

    private static File getPlayerFile(UUID pUI, PlayerData pData){
        File f = new File(getPlayerDirectory(), pUI.toString() + ".GGods");
        if (!f.exists()) {
            try {
                store(pUI, new CompoundNBT(), pData);
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
        MinecraftServer server = LogicalSidedProvider.INSTANCE.get(LogicalSide.SERVER);

        if (server == null) {
            return null;
        }

        File asDataDir = server.func_240776_a_(new FolderName(GalaxyKoisGods.MOD_ID)).toFile();

        if (!asDataDir.exists()) {
            asDataDir.mkdirs();
        }
        return asDataDir;
    }
}
