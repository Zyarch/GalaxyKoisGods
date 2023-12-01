package com.zyarch.galaxykoisgods.Data;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.SetUp.GalasBlocks;
import com.zyarch.galaxykoisgods.SetUp.GalasItems;
import com.zyarch.galaxykoisgods.SetUp.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
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
        //adds the ore block tag to the block
        tag(Tags.Blocks.ORES).add(GalasBlocks.SILVER_ORE.get());
    }
}
