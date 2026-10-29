package com.baisylia.culturaldelights.refabricated.loader;

import net.fabricmc.loader.api.FabricLoader;

public class ModList {
	public static ModList get() {
		return new ModList();
	}

	public boolean isLoaded(String mod) {
		return FabricLoader.getInstance().isModLoaded(mod);
	}
}
