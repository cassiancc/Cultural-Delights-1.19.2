package com.baisylia.culturaldelights.integration.rrv.type;

import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class OvenShapedClientRecipeType extends AbstractOvenClientRecipeType {
	public static OvenShapedClientRecipeType INSTANCE = new OvenShapedClientRecipeType();

	@Override
	public Component getDisplayName() {
		return Component.translatable("emi.category.culturaldelights.shaped_baking");
	}

	@Override
	public Identifier getId() {
		return CulturalDelightsRefabricated.id("oven_shaped");
	}
}
