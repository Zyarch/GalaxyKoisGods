package com.zyarch.galaxykoisgods.network;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.network.packets.FavorUpdatedFromAltarPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class GalasGodsPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GalaxyKoisGods.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public GalasGodsPacketHandler()
    {
        INSTANCE.registerMessage(0, FavorUpdatedFromAltarPacket.class, FavorUpdatedFromAltarPacket::encode, FavorUpdatedFromAltarPacket::decode, FavorUpdatedFromAltarPacket::handle);
    }

    /**
     * Send this message to the server.
     *
     * @param message - the message to send
     */
    public <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}
