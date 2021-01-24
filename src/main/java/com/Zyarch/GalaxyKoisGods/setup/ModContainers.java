package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;//<? super net.minecraft.inventory.container.Container>
import java.util.function.Supplier;

public class ModContainers
{
    public static final ContainerType<AltarContainer> ALTAR = register("altar_container", AltarContainer::new);
    public static final RegistryObject<ContainerType<?>> ALTAR_CONTAINER = register("altar_container", () -> ALTAR);

    private static <T extends ContainerType<?>> RegistryObject<T> register(String name, Supplier<T> container) {
        return Registration.CONTAINERS.register(name, container);
    }

    private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
        return Registry.register(Registry.MENU, key, new ContainerType<>(factory));
    }
}
