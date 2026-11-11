package com.baisylia.culturaldelights.integration.rrv.type;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

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
