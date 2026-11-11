package com.baisylia.culturaldelights.integration.rrv.type;

import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.integration.rrv.RRVCulturalDelightsPlugin;
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
	public void placeSlots(RecipeViewMenu.SlotDefinition builder) {
		int x1 = 17;
		int x2 = x1+18;
		int x3 = 93;
		int y1 = 4;
		int y2 = y1+18;
		int y3 = y2+18;
		builder.addItemSlot(0, x1, y1);
		builder.addItemSlot(1, x2, y1);
		builder.addItemSlot(2, x1, y2);
		builder.addItemSlot(3, x2, y2);
		builder.addItemSlot(4, x1, y3);
		builder.addItemSlot(5, x2, y3);
		builder.addItemSlot(6, x3, y3);
		builder.addItemSlot(7, x3, 9);
	}

	@Override
	public Identifier getId() {
		return CulturalDelightsRefabricated.id("aging");
	}
}
