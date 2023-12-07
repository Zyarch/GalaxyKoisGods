package com.zyarch.galaxykoisgods.data.loot;

import com.zyarch.galaxykoisgods.setup.Registration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;

import java.util.Set;

public class GalasBlockLootTables extends BlockLootSubProvider {
    public GalasBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //ores loot tables
        this.add(GalasBlocks.SILVER_ORE.get(),
                block -> createOreDrop(GalasBlocks.SILVER_ORE.get(), GalasItems.RAW_SILVER.get()));
        this.add(GalasBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(GalasBlocks.DEEPSLATE_SILVER_ORE.get(), GalasItems.RAW_SILVER.get()));
        this.add(GalasBlocks.SELENIUM_ORE.get(),
                block -> createOreDrop(GalasBlocks.SELENIUM_ORE.get(), GalasItems.SELENIUM.get()));
        this.add(GalasBlocks.RUBY_ORE.get(),
                block -> createOreDrop(GalasBlocks.RUBY_ORE.get(), GalasItems.RUBY.get()));
        this.add(GalasBlocks.THUNDER_STONE_ORE.get(),
                block -> createOreDrop(GalasBlocks.THUNDER_STONE_ORE.get(), GalasItems.THUNDER_STONE.get()));

        this.dropSelf(GalasBlocks.SILVER_BLOCK.get());
        this.dropSelf(GalasBlocks.SELENIUM_BLOCK.get());
        this.dropSelf(GalasBlocks.RUBY_BLOCK.get());
        this.dropSelf(GalasBlocks.THUNDER_STONE_BLOCK.get());
        this.dropSelf(GalasBlocks.ALTAR.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
