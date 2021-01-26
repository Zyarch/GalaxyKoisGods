package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, GalaxyKoisGods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(ModTags.Blocks.ORES_SILVER).add(ModBlocks.SILVER_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(ModBlocks.SILVER_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);

        getOrCreateBuilder(ModTags.Blocks.ORES_THUNDER_STONE).add(ModBlocks.THUNDER_STONE_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_THUNDER_STONE);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_THUNDER_STONE).add(ModBlocks.THUNDER_STONE_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_THUNDER_STONE);

        getOrCreateBuilder(ModTags.Blocks.ORES_AMETHYST).add(ModBlocks.AMETHYST_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_AMETHYST);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_AMETHYST).add(ModBlocks.AMETHYST_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_AMETHYST);

        getOrCreateBuilder(ModTags.Blocks.ORES_SELENIUM).add(ModBlocks.SELENIUM_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SELENIUM);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_SELENIUM).add(ModBlocks.SELENIUM_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SELENIUM);

        getOrCreateBuilder(ModTags.Blocks.ORES_RUBY).add(ModBlocks.RUBY_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_RUBY);

        getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_RUBY).add(ModBlocks.RUBY_BLOCK.get());
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_RUBY);
    }
}

