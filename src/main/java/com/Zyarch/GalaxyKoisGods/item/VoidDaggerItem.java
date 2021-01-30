package com.Zyarch.GalaxyKoisGods.item;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class VoidDaggerItem extends SwordItem {

    public VoidDaggerItem() {
        super(ItemTier.NETHERITE, 1, -2f, new Item.Properties().maxDamage(50).setNoRepair()
                .isImmuneToFire().group(GalaxyKoisGods.TAB));
    }

     @Override
     public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.WITHER, 80, 1));
        stack.damageItem(1, attacker, (entity) -> {
             entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
         });
         return true;
     }

}
