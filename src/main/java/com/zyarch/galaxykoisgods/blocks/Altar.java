package com.zyarch.galaxykoisgods.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Altar extends BaseHorizontalBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 14, 14, 14);
    private static final Component CONTAINER_NAME = Component.translatable("container.galasgods.altar");

    public Altar(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;//SHAPES.get(state.getValue(HORIZONTAL_FACING));
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, Player player, Hand handIn, BlockRayTraceResult hit) {
//        System.out.println(worldIn);
//    if(!worldIn.isRemote) {
//            INamedContainerProvider containerProvider = new INamedContainerProvider() {
//                @Override
//                public ITextComponent getDisplayName() {
//                    return CONTAINER_NAME;
//                }
//
//                @Override
//                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
//                    System.out.println("FFFFFF");
//                    return ModContainers.ALTAR_CONTAINER.get().create(i, playerInventory);// new AltarContainer(i, playerInventory);
//                }
//            };
//            NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider);
//        }
//
//        return ActionResultType.SUCCESS;
//    }
}