package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.screens.menus.AltarMenu;
import com.zyarch.galaxykoisgods.screens.menus.DivineInfuserMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

public class GalasMenus {
    public static final RegistryObject<MenuType<AltarMenu>> ALTAR =
            Registration.MENUS.register("altar", () -> IForgeMenuType.create(AltarMenu::new));

    public static final RegistryObject<MenuType<DivineInfuserMenu>> DIVINE_INFUSER_MENU =
            Registration.MENUS.register("divine_infuser", () -> IForgeMenuType.create(DivineInfuserMenu::new));

    public static void register() {}
}
