package com.zyarch.galaxykoisgods.mixins;

import com.zyarch.galaxykoisgods.item.CharmOfSeaTreader;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel, HeadedModel {
    @Inject(method = "setupAnim", at = @At("TAIL"))
    public void setupAnim(T p_102866_, float p_102867_, float p_102868_, float p_102869_, float p_102870_, float p_102871_, CallbackInfo callbackInfo) {
        if(p_102866_.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof CharmOfSeaTreader && p_102866_.isVisuallySwimming() && p_102866_.isInWater()) {
            Iterator<ModelPart> iterator = this.bodyParts().iterator();

            iterator.next();
            iterator.next();
            iterator.next();
            iterator.next().visible = false;
            iterator.next().visible = false;
        }
    }
}