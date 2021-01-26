package com.Zyarch.GalaxyKoisGods.data.client;

import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

import java.util.function.Supplier;

public class PacketUpdateContainer
{
    //Note: windowId gets transferred over the network as an unsigned byte
    protected final short windowId;
    protected final short property;

    public PacketUpdateContainer(short windowId, short property) {
        this.windowId = windowId;
        this.property = property;
    }

    public static void handle(PacketUpdateContainer msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Work that needs to be threadsafe (most work)
            PlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
            if(sender != null && sender.openContainer instanceof AltarContainer)
                ((AltarContainer) sender.openContainer).shrinkInventory(1);
        });

        ctx.get().setPacketHandled(true);
    }

    public static void encode(PacketUpdateContainer pkt, PacketBuffer buffer) {
        buffer.writeByte(pkt.windowId);
        buffer.writeShort(pkt.property);
    }

    public static PacketUpdateContainer decode(PacketBuffer buffer) {
        short windowId = buffer.readUnsignedByte();
        short property = buffer.readShort();
        return new PacketUpdateContainer(windowId, property);
    }
}
