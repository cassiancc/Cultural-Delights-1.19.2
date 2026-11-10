package com.baisylia.culturaldelights.screens;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class OvenScreen extends AbstractContainerScreen<OvenMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "textures/gui/oven_gui.png");

    public OvenScreen(OvenMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float a) {
        super.extractBackground(guiGraphics, mouseX, mouseY, a);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        if (menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 90, y + 35, 176, 14, menu.getScaledProgress(), 17, 256, 256);
        }

        if (menu.isFueled()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 93, y + 55, 176, 32, 17, 15, 256, 256);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics, mouseX, mouseY);
        super.extractRenderState(guiGraphics, mouseX, mouseY, delta);
        this.extractTooltip(guiGraphics, mouseX, mouseY);
        if (this.isHovering(93, 55, 17, 15, mouseX, mouseY)) {
            String key = "container.culturaldelights.oven." + (this.menu.isFueled() ? "heated" : "not_heated");
            guiGraphics.setTooltipForNextFrame(this.font, Component.translatable(key), mouseX, mouseY);
        }
    }

    protected void renderBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, (width - imageWidth) / 2, (height - imageHeight) / 2, 0, 0, imageWidth, imageHeight, 256, 256);

        if (menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, (width - imageWidth) / 2 + 90, (height - imageHeight) / 2 + 35, 176, 14, menu.getScaledProgress(), 17, imageWidth, imageHeight, 256, 256);
        }

        if (menu.isFueled()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, (width - imageWidth) / 2 + 93, (height - imageHeight) / 2 + 55, 176, 32, 17, 15, imageWidth, imageHeight, 256, 256);
        }
    }
}
