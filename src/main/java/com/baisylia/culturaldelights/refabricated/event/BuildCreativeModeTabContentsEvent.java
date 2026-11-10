package com.baisylia.culturaldelights.refabricated.event;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BuildCreativeModeTabContentsEvent {

	private final FabricCreativeModeTabOutput entries;
	private ResourceKey<CreativeModeTab> tabKey;

	public BuildCreativeModeTabContentsEvent(CreativeModeTab creativeModeTab, FabricCreativeModeTabOutput fabricItemGroupEntries) {
		this.tabKey = BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(creativeModeTab).orElse(null);
		this.entries = fabricItemGroupEntries;
	}

	public ResourceKey<CreativeModeTab> getTabKey() {
		return tabKey;
	}

	public void accept(Item item) {
		entries.accept(item);
	}
}
