package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.setup.GalasBlocks;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class GalasBlockLootTablesProvider extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = null;
    public GalasBlockLootTablesProvider() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //createSingleItemTableWithSilkTouch(GalasBlocks.DEEPSLATE_SILVER_ORE.get(), GalasItems.RAW_SILVER.get());
        this.add(Blocks.IRON_ORE, (p_250898_) -> {
            return this.createOreDrop(p_250898_, Items.RAW_IRON);
        });
    }
}
