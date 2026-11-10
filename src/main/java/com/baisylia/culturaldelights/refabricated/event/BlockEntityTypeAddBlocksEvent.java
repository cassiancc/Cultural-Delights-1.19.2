package com.baisylia.culturaldelights.refabricated.event;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class BlockEntityTypeAddBlocksEvent {
	public void modify(BlockEntityType<? extends BlockEntity> sign, Block... blocks) {
		for (Block block : blocks) {
			sign.addValidBlock(block);
		}
	}
}
