package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.client.RecipeScreenContext;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import com.baisylia.culturaldelights.recipes.OvenShapedRecipe;
import com.google.common.collect.Lists;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class OvenShapedClientRecipe extends AbstractOvenRecipe {

    private final List<SlotContent> ingredients;
    private final int height;
    private final int width;

    public OvenShapedClientRecipe(OvenShapedRecipe recipe, Identifier id) {
        super(id, padIngredients(recipe), recipe.getResultItem(), recipe.getCookTime());
        this.height = recipe.getHeight();
        this.width = recipe.getWidth();
        this.ingredients = recipe.getIngredients().stream().map(c->SlotContent.of(c.orElse(null))).toList();
    }

    @Override
    public AbstractOvenClientRecipeType getType() {
        return OvenShapedClientRecipeType.INSTANCE;
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext builder) {
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                builder.bindSlot(index, SlotContent.of(ingredients.get(index)));
                index++;
            }
        }
        builder.bindSlot(9, result);
    }

    @Override
    public void addRecipeWidgets(RecipeScreenContext context) {
        drawCookTime(cookTime, context.widgets(), 50, getType().getDisplayWidth());
    }

    private static List<SlotContent> padIngredients(OvenShapedRecipe recipe) {
        List<SlotContent> list = Lists.newArrayList();
        int i = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (x >= recipe.getWidth() || y >= recipe.getHeight() || i >= recipe.getIngredients().size()) {
                    list.add(SlotContent.of());
                } else {
                    list.add(SlotContent.of(recipe.getIngredients().get(i++).orElse(null)));
                }
            }
        }
        return list;
    }
}
