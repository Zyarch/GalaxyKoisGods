package com.zyarch.galaxykoisgods.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.UUID;

public class CharmOfSeaTreader extends Item implements Equipable {
    private static final UUID SPEED_MODIFIER_CHARM_UUID = UUID.fromString("06e7a3c4-353c-4bbf-8177-79b447bb13ab");
    public static final AttributeModifier SPEED_MODIFIER_CHARM = new AttributeModifier(SPEED_MODIFIER_CHARM_UUID, "Charm swim speed boost", 1.45F, AttributeModifier.Operation.MULTIPLY_TOTAL);
    public CharmOfSeaTreader(Item.Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public InteractionResultHolder<ItemStack> use(Level p_41137_, Player p_41138_, InteractionHand p_41139_) {
        return this.swapWithEquipmentSlot(this, p_41137_, p_41138_, p_41139_);
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.AMETHYST_BLOCK_RESONATE;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.LEGS;
    }
}
