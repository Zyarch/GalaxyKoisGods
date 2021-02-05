package com.Zyarch.GalaxyKoisGods.block;

import com.Zyarch.GalaxyKoisGods.crafting.recipe.DivineInfuserRecipe;
import com.Zyarch.GalaxyKoisGods.setup.ModTileEntityTypes;
import com.Zyarch.GalaxyKoisGods.setup.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.*;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class DivineInfuserTileEntity extends TileEntity implements IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {
    private static final IRecipeType<DivineInfuserRecipe> DIVINE_INFUSER_RECIPE_TYPE = Registration.DIVINE_INFUSER_RECIPE_TYPE;
    private IRecipe<?> result;
    private ItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
    private int counter = 20 * 7;

    public DivineInfuserTileEntity() {
        super(ModTileEntityTypes.DIVINE_INFUSER_TILE.get());
    }

    public void onSlotsChanged()
    {
        List<DivineInfuserRecipe> recipies;
        RecipeWrapper rw = new RecipeWrapper(itemHandler);
        Ingredient ingredients;

        assert this.world != null;
        recipies = this.world.getRecipeManager().getRecipesForType(DIVINE_INFUSER_RECIPE_TYPE);

        System.out.println("Change detected! Number of recipies to look up: " + recipies.size());

        for(int i = 0; i < recipies.size(); i++)
        {
            ingredients = recipies.get(i).getIngredients().get(0);
            System.out.println(recipies.get(i).getRecipeOutput().getItem().getName().getString());

            for(int j = 0; j < ingredients.getMatchingStacks().length; j++) {
                System.out.println(ingredients.getMatchingStacks()[j].getItem().getName().getString());
            }
        }

        for(final IRecipe<?> irecipe : recipies)
        {
            System.out.println("Looking...");

            DivineInfuserRecipe possibleResult = (DivineInfuserRecipe) irecipe;

            if (possibleResult.matches(rw, world)){
                System.out.println("Item check passed!");
                this.result = irecipe;
                break;
            }
        }
    }

    @Override
    public void tick() {
        assert this.world != null;
        if(this.world.isRemote)
            return;

        if(this.canCraft(this.result))
        {
            if (this.counter <= 0) {
                craft(this.result);
                this.result = null;
                this.counter = 20 * 7;
                markDirty();
            }
            else {
                this.counter--;
                System.out.println("Counting: " + this.counter);
                markDirty();
            }
        }
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        counter = nbt.getInt("counter");

        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        compound.putInt("counter", counter);

        return super.write(compound);
    }

    private ItemStackHandler createHandler()
    {
        return new ItemStackHandler(6){
            @Override
            protected void onContentsChanged(int slot)
            {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return super.isItemValid(slot, stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side)
    {
        if(cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    private boolean canCraft(@Nullable IRecipe<?> recipeIn){
        boolean areNoneEmpty = true;

        for(int i = 0; i < 6; i ++)
        {
            areNoneEmpty &= !this.itemHandler.getStackInSlot(i).isEmpty();
        }

        if (areNoneEmpty && recipeIn != null) {
            ItemStack itemstack = recipeIn.getRecipeOutput();
            return !itemstack.isEmpty();
        } else
            return false;
    }

    private void craft(@Nullable IRecipe<?> recipe) {
        if (recipe != null && this.canCraft(recipe))
        {
            this.itemHandler.extractItem(0, 1, false);
            this.itemHandler.extractItem(1, 1, false);
            this.itemHandler.extractItem(2, 1, false);
            this.itemHandler.extractItem(3, 1, false);
            this.itemHandler.extractItem(4, 1, false);

            ItemStack result = recipe.getRecipeOutput();

            this.itemHandler.setStackInSlot(5, result.copy());

            if (!this.world.isRemote) {
                this.setRecipeUsed(recipe);
            }
        }
    }

    @Override
    public void fillStackedContents(RecipeItemHelper helper) {

    }

    @Override
    public void setRecipeUsed(@Nullable IRecipe<?> recipe) {

    }

    @Nullable
    @Override
    public IRecipe<?> getRecipeUsed() {
        return null;
    }
}
