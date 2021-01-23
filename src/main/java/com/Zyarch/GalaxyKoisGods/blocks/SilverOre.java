package com.Zyarch.GalaxyKoisGods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SilverOre extends Block {
    public SilverOre()
    {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3, 10)
                .harvestLevel(2)
                .sound(SoundType.STONE));
    }
}