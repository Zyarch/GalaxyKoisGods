package com.zyarch.galaxykoisgods.item.armor;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.client.CultistRobeModel;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

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
        return GalaxyKoisGods.MODID + ":" + CommonUtility.getPathToArmorTexture(
                "cult_robe_layer" + (slot != EquipmentSlot.LEGS ? 0 : 1) + ".png");
    }

    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new ModelSupplier());
    }

    static class ModelSupplier implements IClientItemExtensions {
        CultistRobeModel INSTANCE;
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
            if (INSTANCE == null) {
                INSTANCE = new CultistRobeModel(Minecraft.getInstance().getEntityModels().bakeLayer(CultistRobeModel.LAYER_LOCATION));
            }
            return INSTANCE;
        }
    }
}
