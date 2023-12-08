package com.zyarch.galaxykoisgods.utility;

import com.zyarch.galaxykoisgods.blocks.AltarBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;

public interface TickableBlockEntity {
    void tick();

    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper(Level level) {
        return level.isClientSide() ? null : (level0, pos, state, blockEntityType) -> ((AltarBlockEntity)blockEntityType).tick();
    }
}
