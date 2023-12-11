package com.zyarch.galaxykoisgods.item.armor;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;

public class CultistRobeItem extends ArmorItem implements IClientItemExtensions {
    public CultistRobeItem(ArmorMaterial armorMaterial, ArmorItem.Type armorType) {
        this(armorMaterial, armorType, CommonUtility.getStacksToOneProperty().defaultDurability(armorMaterial.getDurabilityForType(armorType)));
    }

    public CultistRobeItem(ArmorMaterial armorMaterial, ArmorItem.Type armorType, Item.Properties properties) {
        super(armorMaterial, armorType, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return GalaxyKoisGods.MODID + ":" + CommonUtility.getPathToArmorTexture("none.png");
    }
}
