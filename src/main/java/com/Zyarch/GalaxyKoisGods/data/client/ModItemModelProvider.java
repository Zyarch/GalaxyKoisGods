package com.Zyarch.GalaxyKoisGods.data.client;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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
        withExistingParent("thunder_stone_block", modLoc("block/thunder_stone_block"));
        withExistingParent("thunder_stone_ore", modLoc("block/thunder_stone_ore"));
        withExistingParent("amethyst_block", modLoc("block/amethyst_block"));
        withExistingParent("amethyst_ore", modLoc("block/amethyst_ore"));
        withExistingParent("selenium_block", modLoc("block/selenium_block"));
        withExistingParent("selenium_ore", modLoc("block/selenium_ore"));
        withExistingParent("ruby_block", modLoc("block/ruby_block"));
        withExistingParent("ruby_ore", modLoc("block/ruby_ore"));
        withExistingParent("sapphire_block", modLoc("block/sapphire_block"));
        withExistingParent("sapphire_ore", modLoc("block/sapphire_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "silver_ingot");
        builder(itemGenerated, "thunder_stone");
        builder(itemGenerated, "amethyst");
        builder(itemGenerated, "selenium");
        builder(itemGenerated, "ruby");
        builder(itemGenerated, "sapphire");
        builder(itemGenerated, "silver_dagger");
        builder(itemGenerated, "void_dagger");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0","item/" + name);
    }
}