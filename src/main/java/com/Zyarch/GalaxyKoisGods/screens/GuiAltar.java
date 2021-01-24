package com.Zyarch.GalaxyKoisGods.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class GuiAltar extends Screen
{
    private static final ResourceLocation background = new ResourceLocation("");
    private Button offerButton;

    protected GuiAltar(ITextComponent titleIn)
    {
        super(titleIn);
    }

    @Override
    public void init()
    {
        int width = 150;
        addButton(offerButton = new Button(width / 2 + 2, 200, 98, 20, new StringTextComponent("Offer"), b -> {}));
    }
}
