package com.Zyarch.GalaxyKoisGods.util;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.blocks.Altar;
import com.Zyarch.GalaxyKoisGods.blocks.SilverBlock;
import com.Zyarch.GalaxyKoisGods.blocks.SilverOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GalaxyKoisGods.MOD_ID);

    public static void register() { BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    //Blocks
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOre::new);
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", SilverBlock::new);
    public static final RegistryObject<Block> ALTAR = BLOCKS.register("altar", Altar::new);
}
