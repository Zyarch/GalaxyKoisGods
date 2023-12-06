package com.zyarch.galaxykoisgods.data;

import com.zyarch.galaxykoisgods.data.client.GalasBlockStateProvider;
import com.zyarch.galaxykoisgods.data.client.GalasItemModelProvider;
import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GalaxyKoisGods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        boolean run = true;

        gen.addProvider(run, new GalasBlockStateProvider(output, existingFileHelper));
        gen.addProvider(run, new GalasItemModelProvider(output, existingFileHelper));

        gen.addProvider(event.includeServer(), GalasLootTableProvider.create(output));

        GalasBlockTagsProvider blockTagProvider = new GalasBlockTagsProvider(output, lookupProvider, existingFileHelper);
        gen.addProvider(run, blockTagProvider);
        gen.addProvider(run, new GalasItemTagsProvider(output, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));

        //gen.addProvider(run, new GalasBlockLootTablesProvider());
    }
}
