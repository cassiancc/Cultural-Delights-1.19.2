package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.block.ModBlocks;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public abstract class AbstractOvenClientRecipeType implements ReliableClientRecipeType {
	@Override
	public int getDisplayWidth() {
		return 124;
	}

	@Override
	public int getDisplayHeight() {
		return 58;
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
	public void placeSlots(RecipeViewMenu.SlotDefinition slotDefinition) {

	}
}
