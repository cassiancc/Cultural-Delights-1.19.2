package com.baisylia.culturaldelights.refabricated.registry;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class DeferredHolder<I, S extends I> extends Holder.Reference<I> implements Supplier<S> {
	private final ResourceLocation id;
	private Supplier<S> item;
	private final ResourceKey<I> key;

	public DeferredHolder(ResourceKey<I> id, Supplier<S> item) {
		super(Type.STAND_ALONE, null, id, null);
		this.id = id.location();
		this.key = id;
		this.item = item;
	}

	@Override
	public I value() {
		return get();
	}

	public ResourceLocation getId() {
		return id;
	}

	@Override
	public S get() {
		return item.get();
	}

	public ResourceKey<I> getKey() {
		return key;
	}

	public void setValue(S register) {
		item = ()-> register;
	}
}
