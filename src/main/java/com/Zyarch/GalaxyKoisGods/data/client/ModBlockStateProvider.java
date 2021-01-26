package com.Zyarch.GalaxyKoisGods.data.client;


import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider  extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, GalaxyKoisGods.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());

        simpleBlock(ModBlocks.THUNDER_STONE_BLOCK.get());
        simpleBlock(ModBlocks.THUNDER_STONE_ORE.get());

        simpleBlock(ModBlocks.AMETHYST_BLOCK.get());
        simpleBlock(ModBlocks.AMETHYST_ORE.get());

        simpleBlock(ModBlocks.SELENIUM_BLOCK.get());
        simpleBlock(ModBlocks.SELENIUM_ORE.get());
    }
}
