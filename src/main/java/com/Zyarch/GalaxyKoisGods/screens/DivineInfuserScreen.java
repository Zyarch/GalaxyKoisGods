package com.Zyarch.GalaxyKoisGods.screens;

import com.Zyarch.GalaxyKoisGods.GalaxyKoisGods;
import com.Zyarch.GalaxyKoisGods.gods.GGod;
import com.Zyarch.GalaxyKoisGods.gods.God;
import com.Zyarch.GalaxyKoisGods.network.PacketUpdateContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DivineInfuserScreen extends ContainerScreen<DivineInfuserContainer>
{
    public final ResourceLocation ALTAR_BACKGROUND = new ResourceLocation("galasgods:textures/gui/divine_infuser_screen.png");

    public DivineInfuserScreen(DivineInfuserContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        //container.god = God.Amara;
    }

    protected void init() {
        super.init();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.addButton(new Button(this.guiLeft + 78, this.guiTop + 58, 90, 20, new StringTextComponent("Infuse"), (button) -> {
            ItemStack itemStack = this.container.getSlot(0).getStack();
            PlayerEntity player = this.playerInventory.player;
            boolean isRemote = player.getEntityWorld().isRemote;

            if(!itemStack.isEmpty())
            {
                //send packet to server
                //GalaxyKoisGods.packetHandler.sendToServer(new PacketUpdateContainer((short)this.container.windowId, (short)1, container.god.getGodE().ordinal()));

                //figure out which god is being offered to, set it here.
                //GGod currentGod = container.god;
            }
        }));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(this.ALTAR_BACKGROUND);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        this.font.func_243248_b(matrixStack, this.title, (float)this.titleX + 74, (float)this.titleY, 4210752);
    }
}
