package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.gods.God;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;

import java.io.File;

public class FavorSavedData extends SavedData {
    private static final String uuidTag = "id";
    private static final String favorTag = "currentFavor";
    private ListTag listTag = new ListTag();
    private String puuid;
    public void setPlayerData(Player player, PlayerData pData) {
        God god;

        this.puuid = player.getUUID().toString();
        for(int i = 0; i < GalasGods.getGodListSize(); i++)
        {
            god = GalasGods.getGod(i);
            this.listTag.add(StringTag.valueOf(god.getName() + ":" + pData.getFavor(god)));
        }

        this.setDirty();
    }

    public static FavorSavedData create() {
        return new FavorSavedData();
    }

    public static FavorSavedData load(CompoundTag tag) {
        FavorSavedData data = create();
        data.puuid = tag.getString(uuidTag);
        data.listTag = tag.getList(favorTag, Tag.TAG_STRING);
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        compoundTag.put(uuidTag, StringTag.valueOf(this.puuid));
        compoundTag.put(favorTag, this.listTag);
        return compoundTag;
    }

    @Override
    public void save(File file) {
        super.save(file);
        CommonUtility.LOGGER.debug("FavorSavedData - Save attempted");
    }

    public static void load(MinecraftServer server, String uuid) {
        //server.getLevel().
        server.overworld().getDataStorage().computeIfAbsent(FavorSavedData::load, FavorSavedData::create, uuid + ".GGods");
        server.overworld().getDataStorage().save();
    }
}
