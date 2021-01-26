package com.Zyarch.GalaxyKoisGods.block;

import com.Zyarch.GalaxyKoisGods.setup.ModContainers;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.stream.Stream;

public class Altar extends BaseHorizontalBlock{
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.galasgods.altar");
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

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        System.out.println(worldIn);
    if(!worldIn.isRemote) {
            INamedContainerProvider containerProvider = new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return CONTAINER_NAME;
                }

                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    System.out.println("FFFFFF");
                    return ModContainers.ALTAR_CONTAINER.get().create(i, playerInventory);// new AltarContainer(i, playerInventory);
                }
            };
            NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider);
        }

        return ActionResultType.SUCCESS;
    }
}