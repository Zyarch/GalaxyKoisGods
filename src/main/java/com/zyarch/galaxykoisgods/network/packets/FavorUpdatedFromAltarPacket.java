package com.zyarch.galaxykoisgods.network.packets;

import com.zyarch.galaxykoisgods.data.DataHandler;
import com.zyarch.galaxykoisgods.data.PlayerData;
import com.zyarch.galaxykoisgods.gods.GalasGods;
import com.zyarch.galaxykoisgods.gods.God;
import com.zyarch.galaxykoisgods.screens.menus.AltarMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FavorUpdatedFromAltarPacket
{
    protected final short property;
    protected final int godEnum;

    public FavorUpdatedFromAltarPacket(short property, int godEnum) {
        this.property = property;
        this.godEnum = godEnum;
    }

    public static void handle(FavorUpdatedFromAltarPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Work that needs to be threadsafe (most work)
            Player sender = ctx.get().getSender(); // the client that sent this packet
            if(sender != null && sender.containerMenu instanceof AltarMenu altarMenu) {
                God god = GalasGods.getGod(msg.godEnum);
                ItemStack item = altarMenu.getItems().get(0);
                PlayerData playerData = DataHandler.playerDataList.get(sender.getUUID());

                sender.sendSystemMessage(Component.literal(god.getName() + " Favor: " + god.getValue(item)));

                playerData.addFavor(god.getName(), god.getValue(item));

                altarMenu.getItems().get(0).shrink(msg.property);

                try {
                    DataHandler.store(sender.getUUID(), new CompoundTag(), playerData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ctx.get().setPacketHandled(true);
    }

    public static void encode(FavorUpdatedFromAltarPacket pkt, FriendlyByteBuf buffer) {
        buffer.writeShort(pkt.property);
        buffer.writeInt(pkt.godEnum);
    }

    public static FavorUpdatedFromAltarPacket decode(FriendlyByteBuf buffer) {
        short property = buffer.readShort();
        int godEnum = buffer.readInt();
        return new FavorUpdatedFromAltarPacket(property, godEnum);
    }
}