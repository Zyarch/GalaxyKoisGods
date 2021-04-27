package com.Zyarch.GalaxyKoisGods.item;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.screens.PortableCraftingTableContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class PortableCraftingTable extends Item {
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.crafting");

    public PortableCraftingTable() {
        super(new Properties().maxStackSize(1).isImmuneToFire().group(GalaxyKoisGods.TAB));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if(!worldIn.isRemote){
            playerIn.openContainer(this.getContainer());
            playerIn.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
        }

        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }

    public INamedContainerProvider getContainer() {
        return new SimpleNamedContainerProvider((id, inventory, player) -> new PortableCraftingTableContainer(inventory, id), CONTAINER_NAME);
    }
}