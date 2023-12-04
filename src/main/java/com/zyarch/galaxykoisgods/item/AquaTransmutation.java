package com.zyarch.galaxykoisgods.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class AquaTransmutation extends ArmorItem {
    public AquaTransmutation(ArmorMaterial materialIn, ArmorItem.Type slot, Item.Properties builderIn) {
        super(materialIn, slot, builderIn);
    }
//
//    @Nullable
//    @Override
//    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
//        return (A) new CultistRobeRenderer(1.0f);
//    }
//
//    @Nullable
//    @Override
//    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
//        return GalaxyKoisGods.MOD_ID + ":textures/model/armor/cult_robe.png";
//    }
}
