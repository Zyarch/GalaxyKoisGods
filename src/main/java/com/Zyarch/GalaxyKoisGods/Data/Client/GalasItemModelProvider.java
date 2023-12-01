package com.zyarch.galaxykoisgods.Data.Client;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GalasItemModelProvider extends ItemModelProvider {

    public GalasItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GalaxyKoisGods.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //creating item models for block items
        withExistingParent("silver_ore", modLoc("block/silver_ore"));
    }
}
