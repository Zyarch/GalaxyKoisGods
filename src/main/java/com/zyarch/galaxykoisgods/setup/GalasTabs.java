package com.zyarch.galaxykoisgods.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import static com.zyarch.galaxykoisgods.setup.GalasBlocks.SILVER_ORE;
import static com.zyarch.galaxykoisgods.setup.Registration.CREATIVE_MODE_TABS;
import static com.zyarch.galaxykoisgods.setup.Registration.ITEMS;

public class GalasTabs {
    public static final RegistryObject<CreativeModeTab> GALA_TAB = CREATIVE_MODE_TABS.register("galas_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.galaxykoisgodstab"))
            .icon(() -> new ItemStack(SILVER_ORE.get()))
            .displayItems((parameters, output) -> {
                for (RegistryObject<Item> item : ITEMS.getEntries()) {
                    output.accept(item.get());
                }
            }).build());

    public static void register() {}
}
