package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class GalasBlockTagsProvider extends BlockTagsProvider {
    private static final Block[] RUBY_BLOCKS_ORES = {GalasBlocks.RUBY_ORE.get(), GalasBlocks.DEEPSLATE_RUBY_ORE.get()};
    private static final Block[] SAPPHIRE_BLOCKS_ORES = {GalasBlocks.SAPPHIRE_ORE.get(), GalasBlocks.DEEPSLATE_SAPPHIRE_ORE.get()};
    private static final Block[] SILVER_BLOCKS_ORES = {GalasBlocks.SILVER_ORE.get(), GalasBlocks.DEEPSLATE_SILVER_ORE.get()};
    private static final Block[] SELENIUM_ORES = {GalasBlocks.SELENIUM_ORE.get(), GalasBlocks.DEEPSLATE_SELENIUM_ORE.get()};
    private static final Block[] THUNDER_STONE_ORES = {GalasBlocks.THUNDER_STONE_ORE.get(), GalasBlocks.DEEPSLATE_THUNDER_STONE_ORE.get()};
    private static final Block[] RUBY_BLOCKS = Append(RUBY_BLOCKS_ORES, GalasBlocks.RUBY_BLOCK.get());
    private static final Block[] SAPPHIRE_BLOCKS = Append(SAPPHIRE_BLOCKS_ORES, GalasBlocks.SAPPHIRE_BLOCK.get());
    private static final Block[] SILVER_BLOCKS = Append(SILVER_BLOCKS_ORES, GalasBlocks.SILVER_BLOCK.get());
    private static final Block[] SELENIUM_BLOCKS = Append(SELENIUM_ORES, GalasBlocks.SELENIUM_BLOCK.get());
    private static final Block[] THUNDER_STONE_BLOCKS = Append(THUNDER_STONE_ORES, GalasBlocks.THUNDER_STONE_BLOCK.get());
    public GalasBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GalaxyKoisGods.MODID, existingFileHelper);
    }

    public static Block[] Append(Block[] srcList, Block... blocks) {
        int size = srcList.length + blocks.length;
        ArrayList<Block> result = new ArrayList<>(size);
        Collections.addAll(result, srcList);
        Collections.addAll(result, blocks);
        return result.toArray(new Block[size]);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
        //makes blocks require a tool level
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(RUBY_BLOCKS)
                .add(SAPPHIRE_BLOCKS)
                .add(SILVER_BLOCKS)
                .add(SELENIUM_BLOCKS)
                .add(THUNDER_STONE_BLOCKS);
        //makes blocks preferred tool pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RUBY_BLOCKS)
                .add(SAPPHIRE_BLOCKS)
                .add(SILVER_BLOCKS)
                .add(SELENIUM_BLOCKS)
                .add(THUNDER_STONE_BLOCKS)
                .add(GalasBlocks.ALTAR.get())
                .add(GalasBlocks.DIVINE_INFUSER.get());
        //adds the ore block tag to the ores
        tag(Tags.Blocks.ORES)
                .add(SILVER_BLOCKS_ORES)
                .add(SELENIUM_ORES)
                .add(RUBY_BLOCKS_ORES)
                .add(SAPPHIRE_BLOCKS_ORES)
                .add(THUNDER_STONE_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(GalasBlocks.SILVER_ORE.get())
                .add(GalasBlocks.RUBY_ORE.get())
                .add(GalasBlocks.SAPPHIRE_ORE.get())
                .add(GalasBlocks.THUNDER_STONE_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(GalasBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(GalasBlocks.DEEPSLATE_SELENIUM_ORE.get())
                .add(GalasBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(GalasBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(GalasBlocks.DEEPSLATE_THUNDER_STONE_ORE.get());
    }
}
