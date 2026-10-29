package com.baisylia.culturaldelights.refabricated.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class DeferredBlock<I extends Block> extends DeferredHolder<Block, I> {

	public DeferredBlock(ResourceLocation id, Supplier<I> item) {
		super(ResourceKey.create(Registries.BLOCK, id), item);
	}

}
