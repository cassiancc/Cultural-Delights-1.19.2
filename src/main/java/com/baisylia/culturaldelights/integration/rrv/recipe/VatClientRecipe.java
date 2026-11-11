package com.baisylia.culturaldelights.integration.rrv.recipe;

import cc.cassian.rrv.api.client.RecipeScreenContext;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.integration.rrv.type.VatClientRecipeType;
import com.baisylia.culturaldelights.recipes.VatRecipe;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;

public class VatClientRecipe extends AbstractVatClientRecipe {

    public VatClientRecipe(RecipeHolder<VatRecipe> holder) {
        super(holder.id().identifier(), getIngredients(holder.value()), SlotContent.of(holder.value().getContainer().orElse(null)), holder.value().getResultItem(), holder.value().getCookTime(), holder.value().getTemperature());
    }

    private static ArrayList<SlotContent> getIngredients(VatRecipe recipe) {
        ArrayList<SlotContent> i = new ArrayList<>();
        for (Ingredient ingredient : recipe.getIngredients()) {
            i.add(SlotContent.of(ingredient));
        }
        return i;
    }

    @Override
    public VatClientRecipeType getType() {
        return VatClientRecipeType.INSTANCE;
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext builder) {
        for (int i = 0; i < ingredients.size(); i++) {
            builder.bindSlot(i, ingredients.get(i));
        }

        builder.bindSlot(6, container);
        builder.bindSlot(7, result);
    }

    @Override
    public void addRecipeWidgets(RecipeScreenContext context) {
        drawCookTime(cookTime, context.widgets(), 50, getType().getDisplayWidth());
    }

    @Override
    public void renderRecipe(RecipeScreenContext context) {

        int xOffset = switch (temperature) {
            case COLD -> 0;
            case NORMAL -> 13;
            case HOT -> 26;
        };

        Rect2i rectangle = new Rect2i(3, 8, 12, 46);
        context.guiGraphics().blit(RenderPipelines.GUI_TEXTURED, AbstractVatClientRecipe.TEXTURE, rectangle.getX(), rectangle.getY(), 126 + xOffset, 20, rectangle.getWidth(), rectangle.getHeight(), 256, 256);
        context.setTooltip(Component.translatable("container.culturaldelights.vat." + temperature.getSerializedName()), rectangle);
    }
}
