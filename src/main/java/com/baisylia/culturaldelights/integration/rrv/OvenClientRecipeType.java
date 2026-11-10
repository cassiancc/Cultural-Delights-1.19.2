package com.baisylia.culturaldelights.integration.rrv;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import com.baisylia.culturaldelights.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class OvenClientRecipeType implements ReliableClientRecipeType {
	@Override
	public Component getDisplayName() {
		return null;
	}

	@Override
	public int getDisplayWidth() {
		return 0;
	}

	@Override
	public int getDisplayHeight() {
		return 0;
	}

	@Override
	public @Nullable Identifier getGuiTexture() {
		return AbstractOvenRecipe.TEXTURE;
	}

	@Override
	public void placeSlots(RecipeViewMenu.SlotDefinition builder) {

		builder.addItemSlot(0, 2, 2);
		builder.addItemSlot(1, 20, 2);
		builder.addItemSlot(2, 38, 2);
		builder.addItemSlot(3, 2, 20);
		builder.addItemSlot(4, 20, 20);
		builder.addItemSlot(5, 38, 20);
		builder.addItemSlot(6, 2, 38);
		builder.addItemSlot(7, 20, 38);
		builder.addItemSlot(8, 38, 38);
		builder.addItemSlot(9, 96, 20);
	}

	@Override
	public Identifier getId() {
		return null;
	}

	@Override
	public ItemStack getIcon() {
		return ModBlocks.OVEN.get().asItem().getDefaultInstance();
	}
}
