package com.Zyarch.GalaxyKoisGods.network;

import com.Zyarch.GalaxyKoisGods.data.DataHandler;
import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

import java.util.UUID;
import java.util.function.Supplier;

public class PacketUpdateFavor
{
    protected final String name;
    protected final short value;

    public PacketUpdateFavor(String name, short value) {
        this.name = name;
        this.value = value;
    }

    public static void handle(PacketUpdateFavor msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Work that needs to be threadsafe (most work)
            PlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
            if(sender != null && sender.openContainer instanceof AltarContainer)
                DataHandler.playerDataList.get(sender.getUniqueID()).addFavor(msg.name, msg.value);
        });

        ctx.get().setPacketHandled(true);
    }

    public static void encode(PacketUpdateFavor pkt, PacketBuffer buffer) {
        buffer.writeShort(pkt.value);
    }

    public static PacketUpdateFavor decode(PacketBuffer buffer) {
        String name = buffer.readString();
        short value = buffer.readShort();
        return new PacketUpdateFavor(name, value);
    }
}
