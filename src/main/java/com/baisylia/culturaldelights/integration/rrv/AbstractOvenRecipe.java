package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.client.util.GuiWidgetAccess;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public abstract class AbstractOvenRecipe implements ReliableClientRecipe {
    public final static Identifier TEXTURE = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "textures/gui/oven_gui_jei.png");
    final List<SlotContent> ingredients;
    final int cookTime;
    final SlotContent result;
    final Identifier id;

    public AbstractOvenRecipe(Identifier id, List<SlotContent> ingredients, ItemStack resultItem, int cookTime) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = SlotContent.of(resultItem);
        this.cookTime = cookTime;
    }

    @Override
    public @Nullable Identifier getId() {
        return this.id;
    }

    @Override
    public List<SlotContent> getIngredients() {
        return ingredients;
    }

    @Override
    public List<SlotContent> getResults() {
        return List.of(result);
    }

    protected static void drawCookTime(int cookTime, GuiWidgetAccess builder, int y, int width) {
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("emi.cooking.time", cookTimeSeconds);
            builder.addFillingArrow(63, 20, cookTime * 100).tooltipText(Collections.singletonList(timeString));
        }
    }
}
