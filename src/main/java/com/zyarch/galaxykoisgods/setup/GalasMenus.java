package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.screens.menus.AltarMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

public class GalasMenus {
    public static final RegistryObject<MenuType<AltarMenu>> ALTAR =
            Registration.MENUS.register("altar", () -> IForgeMenuType.create(AltarMenu::new));

    public static void register() {}
}
