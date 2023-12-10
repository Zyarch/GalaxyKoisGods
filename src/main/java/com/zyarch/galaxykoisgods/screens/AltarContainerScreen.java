package com.zyarch.galaxykoisgods.screens;

import com.zyarch.galaxykoisgods.GalaxyKoisGods;
import com.zyarch.galaxykoisgods.screens.menus.AltarMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AltarContainerScreen extends AbstractContainerScreen<AltarMenu> {
    private static final ResourceLocation RES_LOC = new ResourceLocation(GalaxyKoisGods.MODID, "textures/gui/altar_screen.png");

    public AltarContainerScreen(AltarMenu menu, Inventory inventory, Component component)
    {
        super(menu, inventory, component);
    }

    @Override
    public void render(GuiGraphics p_283479_, int p_283661_, int p_281248_, float p_281886_) {
        this.renderBackground(p_283479_);
        super.render(p_283479_, p_283661_, p_281248_, p_281886_);
        this.renderTooltip(p_283479_, p_283661_, p_281248_);
    }

    @Override
    protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_283065_.blit(RES_LOC, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

}
