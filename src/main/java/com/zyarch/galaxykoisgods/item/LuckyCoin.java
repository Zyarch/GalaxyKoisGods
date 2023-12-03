package com.zyarch.galaxykoisgods.item;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.setup.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LuckyCoin extends Item {

    public LuckyCoin() {
        super(new Properties().maxStackSize(1).isImmuneToFire().group(GalaxyKoisGods.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote)
        {
            playerIn.addPotionEffect(new EffectInstance(Effects.LUCK, 9600, 0));
            playerIn.setHeldItem(handIn, new ItemStack(ModItems.OFFER_AMALGUM.get().asItem()));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}