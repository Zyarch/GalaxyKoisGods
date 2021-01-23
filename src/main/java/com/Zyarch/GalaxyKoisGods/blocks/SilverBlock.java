package com.Zyarch.GalaxyKoisGods.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class SilverBlock extends Block{
    public SilverBlock () {
            super(Properties.create(Material.IRON)
                    .hardnessAndResistance(3, 10)
                    .harvestLevel(2)
                    .sound(SoundType.METAL));
    }
}
