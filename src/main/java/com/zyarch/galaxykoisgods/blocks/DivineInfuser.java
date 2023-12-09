package com.zyarch.galaxykoisgods.blocks;

import com.zyarch.galaxykoisgods.screens.menus.DivineInfuserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class DivineInfuser extends BaseHorizontalBlock{
    public static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);
    private static final Component CONTAINER_NAME = Component.translatable("container.galasgods.divine_infuser");

    public DivineInfuser(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if(!level.isClientSide) {
            NetworkHooks.openScreen((ServerPlayer) player, blockState.getMenuProvider(level, blockPos));
            return InteractionResult.CONSUME;
        }

        return InteractionResult.SUCCESS;
    }

    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i1, inventory, player) -> new DivineInfuserMenu(i1, inventory, ContainerLevelAccess.create(level, blockPos)), CONTAINER_NAME);
    }
}