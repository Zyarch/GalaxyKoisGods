package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.block.DivineInfuserTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntityTypes {


    public static final RegistryObject<TileEntityType<DivineInfuserTileEntity>> DIVINE_INFUSER_TILE = register(
            "divine_infuser", () -> TileEntityType.Builder.create(DivineInfuserTileEntity::new, ModBlocks.DIVINE_INFUSER.get()).build(null));

    static void register() { }

    private static <T extends TileEntityType<?>> RegistryObject<T> register(String name, Supplier<T> entityType) {
        return Registration.TILES.register(name, entityType);
    }
}
