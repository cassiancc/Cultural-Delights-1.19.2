package com.baisylia.culturaldelights.refabricated.datagen;

import com.baisylia.culturaldelights.item.ModItems;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class VillagerTradesProvider extends FabricDynamicRegistryProvider {

	public static final ResourceKey<VillagerTrade> CUCUMBER = key("cucumber");
	public static final ResourceKey<VillagerTrade> EGGPLANT = key("eggplant");
	public static final ResourceKey<VillagerTrade> WHITE_EGGPLANT = key("white_eggplant");
	public static final ResourceKey<VillagerTrade> CORN = key("corn");
	public static final ResourceKey<VillagerTrade> AVOCADO = key("avocado");

	public VillagerTradesProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider provider, Entries entries) {
		addCustomTrades(entries);
	}

	public static void addCustomTrades(Entries event) {
		ItemStackTemplate stack = new ItemStackTemplate(Items.EMERALD, 1);

		event.add(CUCUMBER, offer(
				new TradeCost(ModItems.CUCUMBER.get(), 22),
				stack, 10, 2, 0.02F));

		event.add(EGGPLANT, offer(
				new TradeCost(ModItems.EGGPLANT.get(), 15),
				stack, 10, 2, 0.02F));

		event.add(WHITE_EGGPLANT, offer(
				new TradeCost(ModItems.WHITE_EGGPLANT.get(), 20),
				stack, 10, 2, 0.02F));

		event.add(CORN, offer(
				new TradeCost(ModItems.CORN_COB.get(), 15),
				stack, 10, 2, 0.02F));

		event.add(AVOCADO, offer(
				new TradeCost(ModItems.AVOCADO.get(), 20),
				stack, 10, 2, 0.02F));
	}

	private static ResourceKey<VillagerTrade> key(String path) {
		return ResourceKey.create(Registries.VILLAGER_TRADE, CulturalDelightsRefabricated.id("farmer/1/%s_emerald".formatted(path)));
	}

	private static VillagerTrade offer(TradeCost itemCost, ItemStackTemplate stack, int maxUses, int xp, float priceMultiplier) {
		return new VillagerTrade(itemCost, Optional.empty(), stack, maxUses, xp, priceMultiplier,Optional.empty(), List.of());
	}

	@Override
	public String getName() {
		return "CD Villager Trades";
	}
}
