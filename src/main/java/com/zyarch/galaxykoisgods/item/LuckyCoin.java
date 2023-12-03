package com.zyarch.galaxykoisgods.item;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LuckyCoin extends Item {

    public LuckyCoin() {
        super(new Properties().stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide)
        {
            player.addEffect(new MobEffectInstance(MobEffects.LUCK, 9600, 0));
            player.setItemInHand(hand, new ItemStack(GalasItems.OFFER_AMALGUM.get().asItem()));
        }
        return super.use(level, player, hand);
    }
}