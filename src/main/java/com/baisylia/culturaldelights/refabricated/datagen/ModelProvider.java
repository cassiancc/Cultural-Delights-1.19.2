package com.baisylia.culturaldelights.refabricated.datagen;

import cc.cassian.asphodel.util.deferred_registry.DeferredHolder;
import com.baisylia.culturaldelights.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.item.Item;

public class ModelProvider extends FabricModelProvider {

	public ModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerators) {
		for (DeferredHolder<Item, Item> entry : ModItems.ITEMS.getEntries()) {
			itemModelGenerators.declareCustomModelItem(entry.get());
		}
	}
}
