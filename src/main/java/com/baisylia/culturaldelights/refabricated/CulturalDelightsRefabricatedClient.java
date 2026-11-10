package com.baisylia.culturaldelights.refabricated;

import net.fabricmc.api.ClientModInitializer;

import static com.baisylia.culturaldelights.CulturalDelights.ClientModEvents.*;

public class CulturalDelightsRefabricatedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerScreens();
		afterBlockRegistration();
		onClientSetup();
	}
}
