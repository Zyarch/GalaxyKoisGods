package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GalasBlockTagsProvider extends BlockTagsProvider {
    public GalasBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GalaxyKoisGods.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        //makes blocks require a tool level
        tag(BlockTags.NEEDS_IRON_TOOL).add(GalasBlocks.SILVER_ORE.get())
                .add(GalasBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(GalasBlocks.SELENIUM_ORE.get())
                .add(GalasBlocks.RUBY_ORE.get())
                .add(GalasBlocks.THUNDER_STONE_ORE.get())
                .add(GalasBlocks.SILVER_BLOCK.get())
                .add(GalasBlocks.SELENIUM_BLOCK.get())
                .add(GalasBlocks.RUBY_BLOCK.get())
                .add(GalasBlocks.THUNDER_STONE_BLOCK.get());
        //makes blocks preferred tool pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(GalasBlocks.SILVER_ORE.get())
                .add(GalasBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(GalasBlocks.SELENIUM_ORE.get())
                .add(GalasBlocks.RUBY_ORE.get())
                .add(GalasBlocks.THUNDER_STONE_ORE.get())
                .add(GalasBlocks.SILVER_BLOCK.get())
                .add(GalasBlocks.SELENIUM_BLOCK.get())
                .add(GalasBlocks.RUBY_BLOCK.get())
                .add(GalasBlocks.THUNDER_STONE_BLOCK.get())
                .add(GalasBlocks.ALTAR.get())
                .add(GalasBlocks.DIVINE_INFUSER.get());
        //adds the ore block tag to the ores
        tag(Tags.Blocks.ORES).add(GalasBlocks.SILVER_ORE.get())
                .add(GalasBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(GalasBlocks.SELENIUM_ORE.get())
                .add(GalasBlocks.RUBY_ORE.get())
                .add(GalasBlocks.THUNDER_STONE_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(GalasBlocks.SILVER_ORE.get())
                .add(GalasBlocks.RUBY_ORE.get())
                .add(GalasBlocks.THUNDER_STONE_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(GalasBlocks.DEEPSLATE_SILVER_ORE.get());
    }
}
