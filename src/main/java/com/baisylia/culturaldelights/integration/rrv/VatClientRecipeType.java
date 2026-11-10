package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.Nullable;

public class VatClientRecipeType extends AbstractVatClientRecipeType {
	public static final VatClientRecipeType INSTANCE = new VatClientRecipeType();

	@Override
	public Component getDisplayName() {
		return Component.translatable("emi.category.culturaldelights.aging");
	}

	@Override
	public @Nullable Identifier getGuiTexture() {
		return RRVCulturalDelightsPlugin.VAT_TEXTURE;
	}

	@Override
	public void placeSlots(RecipeViewMenu.SlotDefinition slotDefinition) {

	}

	@Override
	public Identifier getId() {
		return CulturalDelightsRefabricated.id("aging");
	}
}
