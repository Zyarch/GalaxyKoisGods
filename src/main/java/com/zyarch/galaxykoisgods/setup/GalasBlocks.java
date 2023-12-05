package com.zyarch.galaxykoisgods.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GalasBlocks {
    private static Item.Properties commonProperties = new Item.Properties();

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE).strength(3.0f, 3.0f)), commonProperties);
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = register("deepslate_silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.DEEPSLATE).strength(4.0f, 4.0f)), commonProperties);
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties tab) {
        RegistryObject<T> newBlock = Registration.BLOCKS.register(name, block);
        registerBlockItem(name, newBlock, tab);
        return newBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties) {
        return Registration.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }
    public static void register() {}
}
