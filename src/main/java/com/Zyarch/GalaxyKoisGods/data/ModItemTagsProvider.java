package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import com.Zyarch.GalaxyKoisGods.setup.ModTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, GalaxyKoisGods.MOD_ID, existingFileHelper);
    }

    protected void registerTags() {
        //Silver
        registerOre(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        registerGem(ModTags.Items.INGOTS_SILVER, ModItems.SILVER_INGOT.get());

        //Thunder Stone
        registerOre(ModTags.Blocks.ORES_THUNDER_STONE, ModTags.Items.ORES_THUNDER_STONE);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_THUNDER_STONE, ModTags.Items.STORAGE_BLOCKS_THUNDER_STONE);
        registerGem(ModTags.Items.GEMS_THUNDER_STONE, ModItems.THUNDER_STONE.get());

        //Amethyst
        registerOre(ModTags.Blocks.ORES_AMETHYST, ModTags.Items.ORES_AMETHYST);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_AMETHYST, ModTags.Items.STORAGE_BLOCKS_AMETHYST);
        registerGem(ModTags.Items.GEMS_AMETHYST, ModItems.AMETHYST.get());

        //Selenium
        registerOre(ModTags.Blocks.ORES_SELENIUM, ModTags.Items.ORES_SELENIUM);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SELENIUM, ModTags.Items.STORAGE_BLOCKS_SELENIUM);
        registerGem(ModTags.Items.GEMS_SELENIUM, ModItems.SELENIUM.get());

        //Ruby
        registerOre(ModTags.Blocks.ORES_RUBY, ModTags.Items.ORES_RUBY);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_RUBY, ModTags.Items.STORAGE_BLOCKS_RUBY);
        registerGem(ModTags.Items.GEMS_RUBY, ModItems.RUBY.get());

        //Sapphire
        registerOre(ModTags.Blocks.ORES_SAPPHIRE, ModTags.Items.ORES_SAPPHIRE);
        registerStorageBlock(ModTags.Blocks.STORAGE_BLOCKS_SAPPHIRE, ModTags.Items.STORAGE_BLOCKS_SAPPHIRE);
        registerGem(ModTags.Items.GEMS_SAPPHIRE, ModItems.SAPPHIRE.get());
    }

    private void registerOre(ITag.INamedTag<Block> tagBlock, ITag.INamedTag<Item> tagItem)
    {
        copy(tagBlock, tagItem);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
    }

    private void registerStorageBlock(ITag.INamedTag<Block> tagBlock, ITag.INamedTag<Item> tagItem)
    {
        copy(tagBlock, tagItem);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
    }

    private void registerGem(ITag.INamedTag<Item> tag, Item block)
    {
        getOrCreateBuilder(tag).add(block);
        getOrCreateBuilder(Tags.Items.GEMS).addTag(tag);
    }
}
