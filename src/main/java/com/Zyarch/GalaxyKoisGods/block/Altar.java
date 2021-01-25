package com.Zyarch.GalaxyKoisGods.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Altar extends  BaseHorizontalBlock{

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(4, 14, 3, 5, 16, 4),
            Block.makeCuboidShape(11, 14, 3, 12, 16, 4),
            Block.makeCuboidShape(4, 14, 12, 5, 16, 13),
            Block.makeCuboidShape(11, 14, 12, 12, 16, 13),
            Block.makeCuboidShape(3, 14, 11, 4, 16, 12),
            Block.makeCuboidShape(12, 14, 11, 13, 16, 12),
            Block.makeCuboidShape(3, 14, 4, 4, 16, 5),
            Block.makeCuboidShape(12, 14, 4, 13, 16, 5),
            Block.makeCuboidShape(4, 11, 12, 12, 14, 13),
            Block.makeCuboidShape(4, 10, 4, 12, 11, 12),
            Block.makeCuboidShape(12, 11, 4, 13, 14, 12),
            Block.makeCuboidShape(3, 11, 4, 4, 14, 12),
            Block.makeCuboidShape(4, 11, 3, 12, 14, 4),
            Block.makeCuboidShape(6, 2, 6, 10, 10, 10),
            Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
            Block.makeCuboidShape(4, 1, 4, 12, 2, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Altar() {
        super(AbstractBlock.Properties.create(Material.ROCK)
                            .hardnessAndResistance(3, 100)
                            .sound(SoundType.STONE));
        runCalculation(SHAPE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(HORIZONTAL_FACING));
    }
}