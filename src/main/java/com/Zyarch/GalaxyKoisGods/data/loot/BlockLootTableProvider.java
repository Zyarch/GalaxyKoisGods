package com.Zyarch.GalaxyKoisGods.data.loot;

import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockLootTableProvider extends BlockLootTables {

    @Override
    protected void addTables()
    {
        this.registerDropSelfLootTable(ModBlocks.SILVER_BLOCK.get());
        this.registerDropSelfLootTable(ModBlocks.SILVER_ORE.get());
        this.registerDropSelfLootTable(ModBlocks.AMETHYST_BLOCK.get());
        this.registerDropSelfLootTable(ModBlocks.THUNDER_STONE_BLOCK.get());
        this.registerDropSelfLootTable(ModBlocks.SELENIUM_BLOCK.get());
        this.registerDropSelfLootTable(ModBlocks.ALTAR.get());
    }
}
