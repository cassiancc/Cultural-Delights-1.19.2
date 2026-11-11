package com.baisylia.culturaldelights.refabricated;

import com.baisylia.culturaldelights.item.ModBoatTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.model.object.boat.RaftModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.RaftRenderer;

import static com.baisylia.culturaldelights.CulturalDelights.ClientModEvents.*;

public class CulturalDelightsRefabricatedClient implements ClientModInitializer {
	public static final ModelLayerLocation BEANSTALK_CHEST_RAFT = register("chest_boat/beanstalk");
	public static final ModelLayerLocation BEANSTALK_RAFT = register("boat/beanstalk");

	private static ModelLayerLocation register(String model) {
		return new ModelLayerLocation(CulturalDelightsRefabricated.id(model), "main");
	}

	@Override
	public void onInitializeClient() {
		registerScreens();
		afterBlockRegistration();
		onClientSetup();
		ModelLayerRegistry.registerModelLayer(BEANSTALK_CHEST_RAFT, RaftModel::createChestRaftModel);
		ModelLayerRegistry.registerModelLayer(BEANSTALK_RAFT, RaftModel::createRaftModel);
		EntityRenderers.register(ModBoatTypes.BEANSTALK_CHEST_RAFT, (context) -> new RaftRenderer(context, BEANSTALK_CHEST_RAFT));
		EntityRenderers.register(ModBoatTypes.BEANSTALK, (context) -> new RaftRenderer(context, BEANSTALK_RAFT));
	}
}
