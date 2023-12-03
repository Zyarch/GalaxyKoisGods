package com.zyarch.galaxykoisgods.item;


import com.zyarch.galaxykoisgods.setup.GalasItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StormCaller extends Item {

    private static int STORM_TIME = 6000;

    public StormCaller() {
        super(new Item.Properties().stacksTo(1).fireResistant());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide)
        {
            if(level.dimensionTypeRegistration() == Level.OVERWORLD) {
                //level.dimensionTypeRegistration().func_241113_a_(0, STORM_TIME, true, true);
                level.setRainLevel(1);
                level.setThunderLevel(1);
                player.setItemInHand(hand, new ItemStack(GalasItems.OFFER_AMALGUM.get().asItem()));
            }
        }
        return super.use(level, player, hand);
    }
}
