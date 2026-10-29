package com.baisylia.culturaldelights.refabricated.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class DeferredItem<I extends Item> extends DeferredHolder<Item, I> {

	public DeferredItem(ResourceLocation name, Supplier<I> item) {
		super(ResourceKey.create(Registries.ITEM, name), item);
	}
}
