package com.zyarch.galaxykoisgods.data.client;

import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;

public class GalasBlockStateProvider extends BlockStateProvider {

    public GalasBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GalaxyKoisGods.MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(GalasBlocks.SILVER_ORE.get());
        simpleBlock(GalasBlocks.DEEPSLATE_SILVER_ORE.get());
    }
}
