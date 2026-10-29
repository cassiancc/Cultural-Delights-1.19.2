package com.baisylia.culturaldelights.refabricated.loader;

public class IEventBus {
	public void addListener(Runnable setup) {
		setup.run();
	}
}
