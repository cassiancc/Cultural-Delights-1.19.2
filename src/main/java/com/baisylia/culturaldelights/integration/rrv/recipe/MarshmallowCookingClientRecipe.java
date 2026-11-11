package com.baisylia.culturaldelights.integration.rrv.recipe;

import cc.cassian.rrv.common.builtin.campfire.CampfireClientRecipe;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;

public class MarshmallowCookingClientRecipe extends CampfireClientRecipe {

    public MarshmallowCookingClientRecipe(int cookingTime, Item input, Item output) {
        var id = Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, "/" + BuiltInRegistries.ITEM.getKey(output).getPath());
        super((new RecipeHolder<>(ResourceKey.create(Registries.RECIPE, id), new CampfireCookingRecipe(null, null, Ingredient.of(input), new ItemStackTemplate(output), 0, cookingTime))));
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext widgets) {
        super.bindSlots(widgets);
        widgets.addAdditionalStackModifier(1, (itemStack, list) -> list.add(Component.translatable("emi.culturaldelights.marshmallow_on_a_stick.help")));
    }
}
