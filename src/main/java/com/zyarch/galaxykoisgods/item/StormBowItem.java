package com.zyarch.galaxykoisgods.item;

import com.zyarch.galaxykoisgods.entity.projectiles.StormBowBolt;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.stats.Stats;
import org.jetbrains.annotations.NotNull;

public class StormBowItem extends BowItem {

    public StormBowItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        InteractionResultHolder<ItemStack> actionResult = ForgeEventFactory.onArrowNock(itemstack, level, playerIn, handIn, true);

        if (actionResult != null) {
            return actionResult;
        }

        playerIn.startUsingItem(handIn);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player playerEntity) {
            boolean flag = playerEntity.getAbilities().instabuild || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY_ARROWS, playerEntity) > 0;
            ItemStack itemstack = playerEntity.getProjectile(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, level, playerEntity, i, !itemstack.isEmpty() || flag);
            if (i < 0) {
                return;
            }

            if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    if (!level.isClientSide) {
                        StormBowBolt stormBowBolt = new StormBowBolt(level, playerEntity);
                        stormBowBolt.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, f * 3.0F, 1.0F);

                        if (f == 1.0F) {
                            stormBowBolt.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER_ARROWS, playerEntity);
                        if (j > 0) {
                            stormBowBolt.setBaseDamage(stormBowBolt.getBaseDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH_ARROWS, playerEntity);
                        if (k > 0) {
                            stormBowBolt.setKnockback(k);
                        }

                        stack.hurtAndBreak(1, playerEntity, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(playerEntity.getUsedItemHand());
                        });

                        level.addFreshEntity(stormBowBolt);
                    }

                    level.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    playerEntity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
}
