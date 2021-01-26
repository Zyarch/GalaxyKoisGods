package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import java.util.function.Supplier;

public class ModContainers
{
    public static final RegistryObject<ContainerType<AltarContainer>> ALTAR_CONTAINER = register("altar_container",
            () -> IForgeContainerType.create(AltarContainer::new));

    static void register() { }

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String name, Supplier<ContainerType<T>> container) {
        return Registration.CONTAINERS.register(name, container);
    }
}
