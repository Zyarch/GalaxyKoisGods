package com.Zyarch.GalaxyKoisGods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Altar extends Block {
    public Altar ()
    {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3, 10)
                .sound(SoundType.STONE));
    }
}
