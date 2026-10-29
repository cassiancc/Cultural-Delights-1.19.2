package com.baisylia.culturaldelights.refabricated.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public interface Flammable {
	default boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
		return false;
	}

	default int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
		return 0;
	}

	default int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
		return 0;
	}

	default int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
		return 0;
	}
}
