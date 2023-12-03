package com.zyarch.galaxykoisgods.entity.projectiles;

import com.zyarch.galaxykoisgods.setup.GalasEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class StormBowBolt extends AbstractArrow {
    public StormBowBolt(EntityType<? extends StormBowBolt> type, Level worldIn) {
        super(type, worldIn);
    }

    public StormBowBolt(Level worldIn, double x, double y, double z) {
        super(GalasEntityTypes.STORM_BOW_BOLT.get(), x, y, z, worldIn);
    }

    public StormBowBolt(Level worldIn, LivingEntity shooter) {
        super(GalasEntityTypes.STORM_BOW_BOLT.get(), shooter, worldIn);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);

        if(result.getType() == HitResult.Type.MISS) {
            return;
        }

        Level level = this.level();

        if (!level.isClientSide) {
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt.setVisualOnly(false);
            bolt.setPos(this.getX(), this.getY(), this.getZ());
            level.addFreshEntity(bolt);
        }
    }

    @Override
    @NotNull
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}
