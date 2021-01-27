package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, GalaxyKoisGods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        registerOre(ModTags.Blocks.ORES_SILVER, ModBlocks.SILVER_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModBlocks.SILVER_BLOCK.get());

        registerOre(ModTags.Blocks.ORES_THUNDER_STONE, ModBlocks.THUNDER_STONE_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_THUNDER_STONE, ModBlocks.THUNDER_STONE_BLOCK.get());

        registerOre(ModTags.Blocks.ORES_AMETHYST, ModBlocks.AMETHYST_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_AMETHYST, ModBlocks.AMETHYST_BLOCK.get());

        registerOre(ModTags.Blocks.ORES_SELENIUM, ModBlocks.SELENIUM_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SELENIUM, ModBlocks.SELENIUM_BLOCK.get());

        registerOre(ModTags.Blocks.ORES_RUBY, ModBlocks.RUBY_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_RUBY, ModBlocks.RUBY_BLOCK.get());

        registerOre(ModTags.Blocks.ORES_SAPPHIRE, ModBlocks.SAPPHIRE_ORE.get());
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SAPPHIRE, ModBlocks.SAPPHIRE_BLOCK.get());
    }

    private void registerOre(ITag.INamedTag<Block> tagBlock, Block block)
    {
        getOrCreateBuilder(tagBlock).add(block);
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(tagBlock);
    }

    private void registerStorageBlock(ITag.INamedTag<Block> tagBlock, Block block)
    {
        getOrCreateBuilder(tagBlock).add(block);
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(tagBlock);
    }
}

