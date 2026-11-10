package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.client.util.GuiWidgetAccess;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.util.VatTemperature;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractVatClientRecipe implements ReliableClientRecipe {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "textures/gui/vat_gui_jei.png");
    final List<SlotContent> ingredients;
    final int cookTime;
    final SlotContent result;
    final Identifier id;
    final SlotContent container;
    final VatTemperature temperature;

    public AbstractVatClientRecipe(Identifier id, List<SlotContent> ingredients, SlotContent container, ItemStack resultItem, int cookTime, VatTemperature temperature) {
        this.id = id;
        this.ingredients = ingredients;
        this.container = container;
        this.result = SlotContent.of(resultItem);
        this.cookTime = cookTime;
        this.temperature = temperature;
    }

    protected static void drawCookTime(int cookTime, GuiWidgetAccess builder, int y, int width) {
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("emi.cooking.time", cookTimeSeconds);
            builder.addFillingArrow(62, 10, cookTime * 100).tooltipText(Collections.singletonList(timeString));
        }
    }

    @Override
    public @Nullable Identifier getId() {
        return this.id;
    }

    @Override
    public List<SlotContent> getIngredients() {
        if (container.isEmpty()) {
            return ingredients;
        }
        List<SlotContent> inputs = new ArrayList<>(ingredients);
        inputs.add(container);
        return inputs;
    }

    @Override
    public List<SlotContent> getResults() {
        return List.of(result);
    }
}
