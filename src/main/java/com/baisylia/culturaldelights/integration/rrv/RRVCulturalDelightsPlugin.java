package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.ReliableRecipeViewerPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import cc.cassian.rrv.client.recipe.ClientRecipeManager;
import cc.cassian.rrv.common.recipe.ServerRecipeManager;
import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.item.ModItems;
import com.baisylia.culturaldelights.recipes.ModRecipes;
import com.baisylia.culturaldelights.recipes.OvenRecipe;
import com.baisylia.culturaldelights.recipes.OvenShapedRecipe;
import com.baisylia.culturaldelights.recipes.VatRecipe;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;

public class RRVCulturalDelightsPlugin implements ReliableRecipeViewerPlugin {

    static final Identifier VAT_TEXTURE = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "textures/gui/vat_gui_jei.png");
    static final Identifier OVEN_TEXTURE = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "textures/gui/oven_gui_jei.png");

    private static Renderable simplifiedRenderer(Identifier texture, int u, int v, int width, int height, int texWidth, int texHeight) {
        return (draw, x, y, delta) -> draw.blit(texture, x, y, u, v, width, height, texWidth, texHeight);
    }

    @Override
    public void onIntegrationInitialize() {
        ServerRecipeManager.INSTANCE.synchronizeRecipeType(ModRecipes.AGING_SERIALIZER.get(), ModRecipes.AGING_TYPE.get());
        ServerRecipeManager.INSTANCE.synchronizeRecipeType(ModRecipes.BAKING_SERIALIZER.get(), ModRecipes.BAKING.get());
        ServerRecipeManager.INSTANCE.synchronizeRecipeType(ModRecipes.BAKING_SHAPED_SERIALIZER.get(), ModRecipes.BAKING_SHAPED.get());

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
