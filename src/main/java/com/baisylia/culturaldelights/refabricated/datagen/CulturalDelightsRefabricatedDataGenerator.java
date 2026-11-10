package com.baisylia.culturaldelights.refabricated.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;

public class CulturalDelightsRefabricatedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();
		pack.addProvider(VillagerTradesProvider::new);
		pack.addProvider(VillagerTradesTagProvider::new);
	}
}
