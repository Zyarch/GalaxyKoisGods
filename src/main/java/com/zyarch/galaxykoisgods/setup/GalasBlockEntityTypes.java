package com.zyarch.galaxykoisgods.setup;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.blocks.AltarBlockEntity;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class GalasBlockEntityTypes {
    public static final RegistryObject<BlockEntityType<AltarBlockEntity>> ALTAR =
            register("altar", AltarBlockEntity::new, GalasBlocks.ALTAR);
    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(
            String name, BlockEntityType.BlockEntitySupplier<T> supplier, RegistryObject<Block> block) {

        return Registration.BLOCK_ENTITY_TYPES.register(name, () -> BlockEntityType.Builder.of(supplier, block.get()).build(
                Util.fetchChoiceType(References.BLOCK_ENTITY, GalaxyKoisGods.MODID + ":" + name)
        ));
    }
    public static void register() { }
}
