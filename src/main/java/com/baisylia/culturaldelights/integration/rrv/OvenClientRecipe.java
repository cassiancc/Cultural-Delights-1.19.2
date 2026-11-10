package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.recipes.OvenRecipe;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;

public class OvenClientRecipe extends AbstractOvenRecipe {

    public OvenClientRecipe(OvenRecipe recipe, Identifier id) {
        super(id, getIngredients(recipe), recipe.getResultItem(), recipe.getCookTime());
    }

    private static ArrayList<SlotContent> getIngredients(OvenRecipe recipe) {
        ArrayList<SlotContent> i = new ArrayList<>();
        for (Ingredient ingredient : recipe.getIngredients()) {
            i.add(SlotContent.of(ingredient));
        }
        return i;
    }

    @Override
    public ReliableClientRecipeType getCategory() {
        return RRVCulturalDelightsPlugin.SHAPELESS_BAKING;
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext builder) {
        for (int i = 0; i < getIngredients().size(); i++) {
            builder.bindSlot(i, getIngredients().get(i));
        }

        drawCookTime(cookTime, builder, 50, getType().getDisplayWidth());
        builder.bindSlot(9, result);
    }
}
