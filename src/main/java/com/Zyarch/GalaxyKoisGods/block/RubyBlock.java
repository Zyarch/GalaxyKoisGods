package com.Zyarch.GalaxyKoisGods.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RubyBlock extends Block {
    public RubyBlock()
    {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(20.0f, 5.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setLightLevel(value -> 4)
                .setRequiresTool()
        );
    }
}
