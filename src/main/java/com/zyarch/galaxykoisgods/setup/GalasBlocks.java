package com.zyarch.galaxykoisgods.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class GalasBlocks {
    private static Item.Properties commonProperties = new Item.Properties();

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)), commonProperties);

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
