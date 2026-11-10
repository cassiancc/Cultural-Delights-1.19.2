package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class OvenClientRecipeType extends AbstractOvenClientRecipeType {
	public static final ReliableClientRecipeType INSTANCE = new OvenClientRecipeType();

	@Override
	public Component getDisplayName() {
		return Component.translatable("emi.category.culturaldelights.shapeless_baking");
	}

	@Override
	public Identifier getId() {
		return CulturalDelightsRefabricated.id("shapeless_baking");
	}
}
