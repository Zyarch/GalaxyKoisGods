package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.block.DivineInfuserTileEntity;
import com.Zyarch.GalaxyKoisGods.entity.projectiles.StormBowBoltEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModTileEntityTypes {


    public static final RegistryObject<TileEntityType<DivineInfuserTileEntity>> DIVINE_INFUSER_TILE = register(
            "divine_infuser", () -> TileEntityType.Builder.<DivineInfuserTileEntity>create(DivineInfuserTileEntity::new, ModBlocks.DIVINE_INFUSER.get()).build(null));

    static void register() { }

    private static <T extends TileEntityType<?>> RegistryObject<T> register(String name, Supplier<T> entityType) {
        return Registration.TILES.register(name, entityType);
    }
}
