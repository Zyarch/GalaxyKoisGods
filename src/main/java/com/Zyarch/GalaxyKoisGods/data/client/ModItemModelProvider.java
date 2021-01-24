package com.Zyarch.GalaxyKoisGods.data.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GalaxyKoisGods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("silver_block", modLoc("block/silver_block"));
        withExistingParent("silver_ore", modLoc("block/silver_ore"));
        withExistingParent("altar", modLoc("block/altar"));

        ModelFile itemGeneratrated = getExistingFile(mcLoc("item/generated"));

        builder(itemGeneratrated, "silver_ingot");
    }

    private void builder(ModelFile itemGeneratrated, String name) {
        getBuilder(name).parent(itemGeneratrated).texture("layer0","item/" + name);
    }
}
