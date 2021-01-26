package com.Zyarch.GalaxyKoisGods.data;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import com.Zyarch.GalaxyKoisGods.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
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
        copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.INGOTS_SILVER).add(ModItems.SILVER_INGOT.get());
        getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);

        //Thunder Stone
        copy(ModTags.Blocks.ORES_THUNDER_STONE, ModTags.Items.ORES_THUNDER_STONE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_THUNDER_STONE, ModTags.Items.STORAGE_BLOCKS_THUNDER_STONE);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.GEMS_THUNDER_STONE).add(ModItems.THUNDER_STONE.get());
        getOrCreateBuilder(Tags.Items.GEMS).addTag(ModTags.Items.GEMS_THUNDER_STONE);

        //Amethyst
        copy(ModTags.Blocks.ORES_AMETHYST, ModTags.Items.ORES_AMETHYST);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_AMETHYST, ModTags.Items.STORAGE_BLOCKS_AMETHYST);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.GEMS_AMETHYST).add(ModItems.AMETHYST.get());
        getOrCreateBuilder(Tags.Items.GEMS).addTag(ModTags.Items.GEMS_AMETHYST);

        //Selenium
        copy(ModTags.Blocks.ORES_SELENIUM, ModTags.Items.ORES_SELENIUM);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_SELENIUM, ModTags.Items.STORAGE_BLOCKS_SELENIUM);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.GEMS_SELENIUM).add(ModItems.SELENIUM.get());
        getOrCreateBuilder(Tags.Items.GEMS).addTag(ModTags.Items.GEMS_SELENIUM);

        //Ruby
        copy(ModTags.Blocks.ORES_RUBY, ModTags.Items.ORES_RUBY);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_RUBY, ModTags.Items.STORAGE_BLOCKS_RUBY);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        getOrCreateBuilder(ModTags.Items.GEMS_RUBY).add(ModItems.RUBY.get());
        getOrCreateBuilder(Tags.Items.GEMS).addTag(ModTags.Items.GEMS_RUBY);
    }
}
