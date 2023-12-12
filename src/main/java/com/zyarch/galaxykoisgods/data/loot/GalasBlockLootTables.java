package com.zyarch.galaxykoisgods.data.loot;

import com.zyarch.galaxykoisgods.setup.Registration;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
        this.basicOreLoot(GalasBlocks.SILVER_ORE.get(), GalasItems.RAW_SILVER.get());
        this.basicOreLoot(GalasBlocks.SELENIUM_ORE.get(), GalasItems.SELENIUM.get());
        this.basicOreLoot(GalasBlocks.RUBY_ORE.get(), GalasItems.RUBY.get());
        this.basicOreLoot(GalasBlocks.SAPPHIRE_ORE.get(), GalasItems.SAPPHIRE.get());
        this.basicOreLoot(GalasBlocks.THUNDER_STONE_ORE.get(), GalasItems.THUNDER_STONE.get());
        this.basicOreLoot(GalasBlocks.DEEPSLATE_SILVER_ORE.get(), GalasItems.RAW_SILVER.get());
        this.basicOreLoot(GalasBlocks.DEEPSLATE_SELENIUM_ORE.get(), GalasItems.SELENIUM.get());
        this.basicOreLoot(GalasBlocks.DEEPSLATE_RUBY_ORE.get(), GalasItems.RUBY.get());
        this.basicOreLoot(GalasBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), GalasItems.SAPPHIRE.get());
        this.basicOreLoot(GalasBlocks.DEEPSLATE_THUNDER_STONE_ORE.get(), GalasItems.THUNDER_STONE.get());

        //drop self
        this.dropSelf(GalasBlocks.SILVER_BLOCK.get());
        this.dropSelf(GalasBlocks.SELENIUM_BLOCK.get());
        this.dropSelf(GalasBlocks.RUBY_BLOCK.get());
        this.dropSelf(GalasBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(GalasBlocks.THUNDER_STONE_BLOCK.get());
        this.dropSelf(GalasBlocks.ALTAR.get());
        this.dropSelf(GalasBlocks.DIVINE_INFUSER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    private void basicOreLoot(Block ore, Item drop) {
        this.add(ore, block -> createOreDrop(ore, drop));
    }
}
