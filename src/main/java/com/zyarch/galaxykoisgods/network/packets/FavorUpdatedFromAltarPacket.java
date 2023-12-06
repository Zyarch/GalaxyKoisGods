package com.zyarch.galaxykoisgods.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FavorUpdatedFromAltarPacket
{
    //Note: windowId gets transferred over the network as an unsigned byte
    //protected final short windowId;
    protected final short property;
    protected final int godEnum;

    public FavorUpdatedFromAltarPacket(short windowId, short property, int godEnum) {
        //this.windowId = windowId;
        this.property = property;
        this.godEnum = godEnum;
    }

    public static void handle(FavorUpdatedFromAltarPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // Work that needs to be threadsafe (most work)
//            Player sender = ctx.get().getSender(); // the client that sent this packet
//            if(sender != null && sender.openContainer instanceof AltarContainer) {
//                AltarContainer altarContainer = (AltarContainer) sender.openContainer;
//                God god = GalasGods.getGod(msg.godEnum);
//                ItemStack item = altarContainer.getInventory().get(0);
//                PlayerData playerData = DataHandler.playerDataList.get(sender.getUniqueID());
//
//                sender.sendSystemMessage(Component.literal(god.getName() + " Favor: " + god.getValue(item)));
//
//                playerData.addFavor(god.getName(), god.getValue(item));
//
//                altarContainer.shrinkInventory(msg.property);
//
//                try {
//                    DataHandler.store(sender.getUUID(), new CompoundTag(), playerData);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        });

        ctx.get().setPacketHandled(true);
    }

    public static void encode(FavorUpdatedFromAltarPacket pkt, FriendlyByteBuf buffer) {
        //buffer.writeByte(pkt.windowId);
        buffer.writeShort(pkt.property);
        buffer.writeInt(pkt.godEnum);
    }

    public static FavorUpdatedFromAltarPacket decode(FriendlyByteBuf buffer) {
        //short windowId = buffer.readUnsignedByte();
        short property = buffer.readShort();
        int godEnum = buffer.readInt();
        return new FavorUpdatedFromAltarPacket((short)0, property, godEnum);
    }
}