package com.baisylia.culturaldelights.refabricated.patch;

import com.baisylia.culturaldelights.refabricated.util.Flammable;
import net.minecraft.world.level.block.Block;

public class BlockItem extends net.minecraft.world.item.BlockItem implements Flammable {
	public BlockItem(Block block, Properties properties) {
		super(block, properties);
	}
}
