package com.baisylia.culturaldelights.refabricated.event;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BuildCreativeModeTabContentsEvent {

	private final FabricItemGroupEntries entries;
	private ResourceKey<CreativeModeTab> tabKey;

	public BuildCreativeModeTabContentsEvent(CreativeModeTab creativeModeTab, FabricItemGroupEntries fabricItemGroupEntries) {
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
