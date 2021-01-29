package com.Zyarch.GalaxyKoisGods.network;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.data.DataHandler;
import com.Zyarch.GalaxyKoisGods.data.PlayerData;
import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent.Context;

import java.util.function.Supplier;

public class PacketUpdateContainer
{
    //Note: windowId gets transferred over the network as an unsigned byte
    //protected final short windowId;
    protected final short property;

    public PacketUpdateContainer(short windowId, short property) {
        //this.windowId = windowId;
        this.property = property;
    }

    public static void handle(PacketUpdateContainer msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Work that needs to be threadsafe (most work)
            PlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
            if(sender != null && sender.openContainer instanceof AltarContainer) {
                GGod god = God.Amara;
                AltarContainer altarContainer = (AltarContainer) sender.openContainer;
                ItemStack item = altarContainer.getInventory().get(0);
                PlayerData playerData = DataHandler.playerDataList.get(sender.getUniqueID());

                altarContainer.shrinkInventory(msg.property);

                playerData.addFavor(god.getName(), god.getValue(item));

                try {
                    DataHandler.store(sender.getUniqueID(), new CompoundNBT(), playerData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ctx.get().setPacketHandled(true);
    }

    public static void encode(PacketUpdateContainer pkt, PacketBuffer buffer) {
        //buffer.writeByte(pkt.windowId);
        buffer.writeShort(pkt.property);
    }

    public static PacketUpdateContainer decode(PacketBuffer buffer) {
        //short windowId = buffer.readUnsignedByte();
        short property = buffer.readShort();
        return new PacketUpdateContainer((short)0, property);
    }
}
