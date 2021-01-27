package com.Zyarch.GalaxyKoisGods.world.gen;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ModOreGen
{
    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();
    //FOR BIOME SPECIFIC ORE!!!! MAKE A NEW LIST FOR THAT BIOME AND ADD THEM TO IT
    private static final BlockMatchRuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

    public static void registerOre(){
        addGenericOverWorldOreGen("silver_ore"          , ModBlocks.SILVER_ORE.get()        , 6, 70, 16);
        addGenericOverWorldOreGen("thunder_stone_ore"   , ModBlocks.THUNDER_STONE_ORE.get() , 6, 70, 16);
        addGenericOverWorldOreGen("ruby_ore"            , ModBlocks.RUBY_ORE.get()          , 6, 70, 16);
        addGenericEndOreGen("amethyst_ore"        , ModBlocks.AMETHYST_ORE.get()      , 6, 70, 16);
        addGenericEndOreGen("selenium_ore"        , ModBlocks.SELENIUM_ORE.get()      , 6, 70, 16);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)) {
            for (ConfiguredFeature<?, ?> ore : endOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        //Check for biome here
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    //int spawnHeight: spawn start height
    //int frequency: the rarity of the ore
    private static void addGenericOverWorldOreGen(String blockKey, Block block, int size, int spawnHeight, int frequency)
    {
        overworldOres.add(register(blockKey, Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, block.getDefaultState(), size))
                .range(spawnHeight).square()   //square is the shape of the generation
                .func_242731_b(frequency)));
    }

    //int spawnHeight: spawn start height
    //int frequency: the rarity of the ore
    private static void addGenericNetherOreGen(String blockKey, Block block, int size, int spawnHeight, int frequency)
    {
        netherOres.add(register(blockKey, Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.NETHERRACK, block.getDefaultState(), size))
                .range(spawnHeight).square()   //square is the shape of the generation
                .func_242731_b(frequency)));
    }

    //int spawnHeight: spawn start height
    //int frequency: the rarity of the ore
    private static void addGenericEndOreGen(String blockKey, Block block, int size, int spawnHeight, int frequency)
    {
        endOres.add(register(blockKey, Feature.ORE.withConfiguration(new OreFeatureConfig(
                END_STONE, block.getDefaultState(), size))
                .range(spawnHeight).square()   //square is the shape of the generation
                .func_242731_b(frequency)));
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature){
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, GalaxyKoisGods.MOD_ID + ":" + name, configuredFeature);
    }
}