package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.block.Altar;
import com.Zyarch.GalaxyKoisGods.block.RubyBlock;
import com.Zyarch.GalaxyKoisGods.block.RubyOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

    public static final RegistryObject<Block> THUNDER_STONE_ORE = register("thunder_stone_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> THUNDER_STONE_BLOCK = register("thunder_stone_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

    public static final RegistryObject<Block> AMETHYST_ORE = register("amethyst_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> AMETHYST_BLOCK = register("amethyst_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

    public static final RegistryObject<Block> SELENIUM_ORE = register("selenium_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SELENIUM_BLOCK = register("selenium_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 10).setRequiresTool().harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RUBY_BLOCK = register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> RUBY_ORE = register("ruby_ore", RubyOre::new);

    public static final RegistryObject<Altar> ALTAR = registerStack1("altar", () -> new Altar());

    static void register() { }

    private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().group(GalaxyKoisGods.TAB)));
        return ret;
    }

    private static <T extends Block> RegistryObject<T> registerStack1(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()
                .group(GalaxyKoisGods.TAB)
                .maxStackSize(1)));
        return ret;
    }
}
