package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.recipes.VatRecipe;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;
import java.util.List;

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

        builder.addTexture(AbstractVatClientRecipe.TEXTURE, 0, 0, 124, 58, 0, 0);

        builder.addSlot(ingredients.get(0), 19, 2);
        if (ingredients.size() > 1) {
            builder.addSlot(ingredients.get(1), 37, 2);
            if (ingredients.size() > 2) {
                builder.addSlot(ingredients.get(2), 19, 20);
                if (ingredients.size() > 3) {
                    builder.addSlot(ingredients.get(3), 37, 20);
                    if (ingredients.size() > 4) {
                        builder.addSlot(ingredients.get(4), 19, 38);
                        if (ingredients.size() > 5) {
                            builder.addSlot(ingredients.get(5), 37, 38);
                        }
                    }
                }
            }
        }
        builder.addSlot(container, 95, 38);
        drawCookTime(cookTime, builder, 50, getDisplayWidth());
        builder.addSlot(result, 95, 9).recipeContext(this).drawBack(false);

        int xOffset = switch (temperature) {
            case COLD -> 0;
            case NORMAL -> 13;
            case HOT -> 26;
        };
        builder.addTexture(AbstractVatClientRecipe.TEXTURE, 5, 6, 12, 46, 126 + xOffset, 20)
                .tooltip((mx, my) -> List.of(
                        ClientTooltipComponent.create(Component.translatable("container.culturaldelights.vat."
                                + temperature.getSerializedName()).getVisualOrderText())
                ));
    }
}
