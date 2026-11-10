package com.baisylia.culturaldelights.refabricated.loader;

public class EnumProxy<T> {
	private final T value;

	public EnumProxy(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
