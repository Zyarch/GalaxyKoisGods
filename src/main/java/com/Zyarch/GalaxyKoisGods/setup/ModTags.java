package com.Zyarch.GalaxyKoisGods.setup;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");

        public static final ITag.INamedTag<Block> ORES_THUNDER_STONE = forge("ores/thunder_stone");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_THUNDER_STONE = forge("storage_blocks/thunder_stone");

        public static final ITag.INamedTag<Block> ORES_AMETHYST = forge("ores/amethyst");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_AMETHYST = forge("storage_blocks/amethyst");

        public static final ITag.INamedTag<Block> ORES_SELENIUM = forge("ores/selenium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SELENIUM = forge("storage_blocks/selenium");

        public static final ITag.INamedTag<Block> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_RUBY = forge("storage_blocks/ruby");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation(GalaxyKoisGods.MOD_ID, path).toString());
        }
    }

    public static final class Items {
        public static final ITag.INamedTag<Item> ORES_SILVER = forge("ores/silver");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SILVER = forge("storage_blocks/silver");
        public static final ITag.INamedTag<Item> INGOTS_SILVER = forge("ingots/silver");

        public static final ITag.INamedTag<Item> ORES_THUNDER_STONE = forge("ores/thunder_stone");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_THUNDER_STONE = forge("storage_blocks/thunder_stone");
        public static final ITag.INamedTag<Item> GEMS_THUNDER_STONE = forge("gems/thunder_stone");

        public static final ITag.INamedTag<Item> ORES_AMETHYST = forge("ores/amethyst");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_AMETHYST = forge("storage_blocks/amethyst");
        public static final ITag.INamedTag<Item> GEMS_AMETHYST = forge("gems/amethyst");

        public static final ITag.INamedTag<Item> ORES_SELENIUM = forge("ores/selenium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SELENIUM = forge("storage_blocks/selenium");
        public static final ITag.INamedTag<Item> GEMS_SELENIUM = forge("gems/selenium");

        public static final ITag.INamedTag<Item> ORES_RUBY = forge("ores/ruby");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_RUBY = forge("storage_blocks/ruby");
        public static final ITag.INamedTag<Item> GEMS_RUBY = forge("gems/ruby");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation(GalaxyKoisGods.MOD_ID, path).toString());
        }
    }
}