package com.zyarch.galaxykoisgods.event;

import com.zyarch.galaxykoisgods.item.CharmOfSeaTreader;
import com.zyarch.galaxykoisgods.utility.CommonUtility;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventBusSubscriber {
    @SubscribeEvent
    public static void LivingEquipmentChangeEventHandler(final LivingEquipmentChangeEvent event) {
        LivingEntity livingEntity = event.getEntity();AttributeInstance attributeInstance =
                livingEntity.getAttributes().getInstance(ForgeMod.SWIM_SPEED.get());

        if(livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof CharmOfSeaTreader) {
            if(!attributeInstance.hasModifier(CharmOfSeaTreader.SPEED_MODIFIER_CHARM)) {
                attributeInstance.addTransientModifier(CharmOfSeaTreader.SPEED_MODIFIER_CHARM);
                CommonUtility.LOGGER.info("Applying boost");
            }
        } else {
            if(attributeInstance.hasModifier(CharmOfSeaTreader.SPEED_MODIFIER_CHARM)) {
                attributeInstance.removeModifier(CharmOfSeaTreader.SPEED_MODIFIER_CHARM);
                CommonUtility.LOGGER.info("Removed boost");
            }
        }
    }
 }
