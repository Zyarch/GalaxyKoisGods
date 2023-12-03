package com.zyarch.galaxykoisgods.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.entity.LivingEntity;

public class VoidDaggerItem extends SwordItem {

    public VoidDaggerItem() {
        super(Tiers.NETHERITE, 2, -2f, new Item.Properties().setNoRepair().fireResistant());
    }

     @Override
     public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, 200));
         stack.hurtAndBreak(1, attacker, (event) -> {
             event.broadcastBreakEvent(EquipmentSlot.MAINHAND);
         });
         return true;
     }

}
