package com.zyarch.galaxykoisgods.entity.monster;

import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class Cultist extends Pillager {
    public Cultist(EntityType<? extends Pillager> p_33262_, Level p_33263_) {
        super(p_33262_, p_33263_);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_33306_) {
        return SoundEvents.EMPTY;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GalasItems.SILVER_DAGGER.get()));
        this.equipItemIfPossible(new ItemStack(GalasItems.CULT_ROBE_HOOD.get()));
        this.equipItemIfPossible(new ItemStack(GalasItems.CULT_ROBE_CHEST.get()));
        this.equipItemIfPossible(new ItemStack(GalasItems.CULT_ROBE_LEGGINGS.get()));
        this.equipItemIfPossible(new ItemStack(GalasItems.CULT_ROBE_BOOTS.get()));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.MAX_HEALTH, 24.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public static boolean canSpawn(EntityType<Cultist> entityType, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
        return Monster.checkAnyLightMonsterSpawnRules(entityType, level, mobSpawnType, blockPos, randomSource);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new Raider.HoldGroundAttackGoal(this, 10.0F));
        this.goalSelector.addGoal(3, new RangedCrossbowAttackGoal<>(this, 1.0D, 8.0F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(3, new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 15.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 15.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
