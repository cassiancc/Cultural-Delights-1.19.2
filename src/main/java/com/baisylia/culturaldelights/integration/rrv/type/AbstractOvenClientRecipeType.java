package com.baisylia.culturaldelights.integration.rrv.type;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.integration.rrv.RRVCulturalDelightsPlugin;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

import java.util.List;

public abstract class AbstractOvenClientRecipeType implements ReliableClientRecipeType {
	@Override
	public int getDisplayWidth() {
		return 128;
	}

	@Override
	public int getDisplayHeight() {
		return 62;
	}

	@Override
	public List<ItemStack> getCraftReferences() {
		return List.of(new ItemStack(ModBlocks.OVEN.get()));
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStack(ModBlocks.OVEN.get());
	}

	@Override
	public void placeSlots(RecipeViewMenu.SlotDefinition builder) {

		int x1 = 5;
		int x2 = x1+18;
		int x3 = x2+18;

		int y1 = 5;
		int y2 = y1+18;
		int y3 = y2+18;
		int xr = 99;
		int yr = 22;

		builder.addItemSlot(0, x1, y1);
		builder.addItemSlot(1, x2, y1);
		builder.addItemSlot(2, x3, y1);
		builder.addItemSlot(3, x1, y2);
		builder.addItemSlot(4, x2, y2);
		builder.addItemSlot(5, x3, y2);
		builder.addItemSlot(6, x1, y3);
		builder.addItemSlot(7, x2, y3);
		builder.addItemSlot(8, x3, y3);
		builder.addItemSlot(9, xr, yr);
	}

	@Override
	public @Nullable Identifier getGuiTexture() {
		return RRVCulturalDelightsPlugin.OVEN_TEXTURE;
	}
}
