package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.ChatType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class GalasChatTypes {
    public static final ResourceKey<ChatType> CONTENT_ONLY_KEY =
            ResourceKey.create(Registries.CHAT_TYPE, new ResourceLocation(GalaxyKoisGods.MODID, "content_only"));

    public static void register() {}
}
