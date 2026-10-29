package com.baisylia.culturaldelights.refabricated.util;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.refabricated.ItemAbility;

public interface ToolModifiableBlock {
	default @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
		return null;
	}
}

