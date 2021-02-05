package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.screens.AltarContainer;
import com.Zyarch.GalaxyKoisGods.screens.DivineInfuserContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import java.util.function.Supplier;

public class ModContainers
{
    public static final RegistryObject<ContainerType<AltarContainer>> ALTAR_CONTAINER = register("altar_container",
            () -> IForgeContainerType.create(AltarContainer::new));
    public static final RegistryObject<ContainerType<DivineInfuserContainer>> DIVINE_INFUSER_CONTAINER = register("divine_infuser",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new DivineInfuserContainer(windowId, world, pos, inv, inv.player);
            }));

    static void register() { }

    private static <T extends Container> RegistryObject<ContainerType<T>> register(String name, Supplier<ContainerType<T>> container) {
        return Registration.CONTAINERS.register(name, container);
    }
}
