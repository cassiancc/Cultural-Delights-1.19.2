package com.baisylia.culturaldelights.refabricated.loader;

import net.minecraft.world.entity.vehicle.Boat;

public class EnumProxy<T> {
	private final T value;

	public EnumProxy(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
