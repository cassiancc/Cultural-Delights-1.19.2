package com.baisylia.culturaldelights.refabricated;

import com.baisylia.culturaldelights.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

import static com.baisylia.culturaldelights.CulturalDelights.ClientModEvents.*;

public class CulturalDelightsRefabricatedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerScreens();
		afterBlockRegistration();
		onClientSetup();
		registerClientExtensions();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(), ModBlocks.AGAVE.get(), ModBlocks.AVOCADO_LEAVES.get(), ModBlocks.AVOCADO_SAPLING.get(), ModBlocks.BEANS.get(), ModBlocks.CUCUMBERS.get(), ModBlocks.EGGPLANTS.get(), ModBlocks.FRUITING_LEMON_LEAVES.get(), ModBlocks.LEMON_LEAVES.get(), ModBlocks.LEMON_SAPLING.get(), ModBlocks.MAGIC_BEANS.get(), ModBlocks.MINT.get(), ModBlocks.POTTED_AGAVE.get(), ModBlocks.POTTED_AVOCADO_SAPLING.get(), ModBlocks.POTTED_MINT.get(), ModBlocks.SALT_SPIKE.get(), ModBlocks.WILD_BEANS.get(), ModBlocks.WILD_CUCUMBERS.get(), ModBlocks.WILD_EGGPLANTS.get(), ModBlocks.ROPE_BEANS.get(), ModBlocks.BUDDING_BEANS.get(), ModBlocks.BEANSTALK_DOOR.get(), ModBlocks.BEANSTALK_TRAPDOOR.get(), ModBlocks.CORN.get());
	}
}
