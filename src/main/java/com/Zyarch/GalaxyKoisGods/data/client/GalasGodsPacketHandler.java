package com.Zyarch.GalaxyKoisGods.data.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class GalasGodsPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(GalaxyKoisGods.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public GalasGodsPacketHandler()
    {
        INSTANCE.registerMessage(0, PacketUpdateContainer.class, PacketUpdateContainer::encode, PacketUpdateContainer::decode, PacketUpdateContainer::handle);
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
