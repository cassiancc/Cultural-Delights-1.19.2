package com.baisylia.culturaldelights.refabricated.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.ArrayList;
import java.util.List;

public class VillagerTradesEvent {
	private final Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = new Int2ObjectOpenHashMap<>();
	private static final VillagerProfession type = VillagerProfession.FARMER;

	public Int2ObjectMap<List<VillagerTrades.ItemListing>> getTrades() {
		if (trades.isEmpty()) {
			trades.put(1, new ArrayList<>());
		}
		return trades;
	}

	public VillagerProfession getType() {
		return type;
	}
}
