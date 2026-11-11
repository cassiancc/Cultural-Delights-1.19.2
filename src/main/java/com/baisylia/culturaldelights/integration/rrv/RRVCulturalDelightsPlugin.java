package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.ReliableRecipeViewerPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import cc.cassian.rrv.client.recipe.ClientRecipeManager;
import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.integration.rrv.recipe.MarshmallowCookingClientRecipe;
import com.baisylia.culturaldelights.integration.rrv.recipe.OvenClientRecipe;
import com.baisylia.culturaldelights.integration.rrv.recipe.OvenShapedClientRecipe;
import com.baisylia.culturaldelights.integration.rrv.recipe.VatClientRecipe;
import com.baisylia.culturaldelights.item.ModItems;
import com.baisylia.culturaldelights.recipes.ModRecipes;
import com.baisylia.culturaldelights.recipes.OvenRecipe;
import com.baisylia.culturaldelights.recipes.OvenShapedRecipe;
import com.baisylia.culturaldelights.recipes.VatRecipe;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;

public class RRVCulturalDelightsPlugin implements ReliableRecipeViewerPlugin {

    public static final Identifier VAT_TEXTURE = CulturalDelightsRefabricated.id("textures/gui/vat_gui_rrv.png");
    public static final Identifier OVEN_TEXTURE = CulturalDelightsRefabricated.id("textures/gui/oven_gui_rrv.png");

    @Override
    public void onIntegrationInitialize() {
        ItemView.addClientRecipeProvider(list->{
            for (RecipeHolder<VatRecipe> recipe : ClientRecipeManager.INSTANCE.getRecipesForType(ModRecipes.AGING_TYPE.get())) {
                list.add(new VatClientRecipe(recipe));
            }
            for (RecipeHolder<OvenRecipe> recipe : ClientRecipeManager.INSTANCE.getRecipesForType(ModRecipes.BAKING.get())) {
                list.add(new OvenClientRecipe(recipe.value(), recipe.id().identifier()));
            }
            for (RecipeHolder<OvenShapedRecipe> recipe : ClientRecipeManager.INSTANCE.getRecipesForType(ModRecipes.BAKING_SHAPED.get())) {
                list.add(new OvenShapedClientRecipe(recipe.value(), recipe.id().identifier()));
            }
            list.add(new MarshmallowCookingClientRecipe(100, ModItems.MARSHMALLOW_ON_A_STICK.get(), ModItems.CARAMELIZED_MARSHMALLOW_ON_A_STICK.get()));
            list.add(new MarshmallowCookingClientRecipe(100, ModItems.CARAMELIZED_MARSHMALLOW_ON_A_STICK.get(), ModItems.CHARRED_MARSHMALLOW_ON_A_STICK.get()));
        });

    }
}
