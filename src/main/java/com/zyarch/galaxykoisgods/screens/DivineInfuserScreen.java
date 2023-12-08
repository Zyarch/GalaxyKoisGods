package com.zyarch.galaxykoisgods.screens;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.screens.menus.DivineInfuserMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DivineInfuserScreen extends AbstractContainerScreen<DivineInfuserMenu> {
    private static final ResourceLocation RES_LOC = new ResourceLocation(GalaxyKoisGods.MODID, "textures/gui/divine_infuser_screen.png");

    public DivineInfuserScreen(DivineInfuserMenu menu, Inventory inventory, Component component)
    {
        super(menu, inventory, component);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i1, int i2, float f1) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, i1, i2, f1);
        this.renderTooltip(guiGraphics, i1, i2);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f1, int i1, int i2) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RES_LOC, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
