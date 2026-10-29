package com.baisylia.culturaldelights.refabricated.patch;

import com.baisylia.culturaldelights.refabricated.util.Flammable;
import com.baisylia.culturaldelights.refabricated.util.ToolModifiableBlock;

public class RotatedPillarBlock extends net.minecraft.world.level.block.RotatedPillarBlock implements Flammable, ToolModifiableBlock {
	public RotatedPillarBlock(Properties properties) {
		super(properties);
	}
}
