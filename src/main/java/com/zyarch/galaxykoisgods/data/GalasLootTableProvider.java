package com.zyarch.galaxykoisgods.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import com.zyarch.galaxykoisgods.data.loot.GalasBlockLootTables;

import java.util.List;
import java.util.Set;

public class GalasLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(GalasBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
