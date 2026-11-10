package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import com.baisylia.culturaldelights.block.ModBlocks;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public abstract class AbstractVatClientRecipeType implements ReliableClientRecipeType {

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
		return List.of(new ItemStack(ModBlocks.VAT.get()));
	}

	@Override
	public ItemStack getIcon() {
		return new ItemStack(ModBlocks.VAT.get());
	}
}
