package com.zyarch.galaxykoisgods.Item;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.setup.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class StormCaller extends Item {

    public StormCaller() {
        super(new Item.Properties().maxStackSize(1).isImmuneToFire());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        int _stormTime = 6000;
        if(!worldIn.isRemote)
        {
            if(worldIn.getDimensionKey() == World.OVERWORLD) {
                worldIn.getServer().getWorld(worldIn.getDimensionKey()).func_241113_a_(0, _stormTime, true, true);
                playerIn.setHeldItem(handIn, new ItemStack(ModItems.OFFER_AMALGUM.get().asItem()));
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
