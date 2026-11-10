package com.baisylia.culturaldelights.refabricated.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.VillagerTradesTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.item.trading.VillagerTrades;

import java.util.concurrent.CompletableFuture;

import static com.baisylia.culturaldelights.refabricated.datagen.VillagerTradesProvider.*;

public class VillagerTradesTagProvider extends FabricTagsProvider<VillagerTrade> {
	public VillagerTradesTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		builder(VillagerTradeTags.FARMER_LEVEL_1)
				.addOptional(CUCUMBER)
				.addOptional(EGGPLANT)
				.addOptional(WHITE_EGGPLANT)
				.addOptional(CORN)
				.addOptional(AVOCADO);
	}
}
