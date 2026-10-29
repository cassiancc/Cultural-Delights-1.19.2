package com.baisylia.culturaldelights.refabricated.event;

import com.baisylia.culturaldelights.CulturalDelights;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;

public class AddPackFindersEvent {
	public PackType getPackType() {
		return PackType.CLIENT_RESOURCES;
	}

	public void addPackFinders(ResourceLocation id, PackType packType, MutableComponent name, PackSource builtIn, boolean b, Pack.Position position) {
		ResourcePackActivationType resourcePackActivationType = b ? ResourcePackActivationType.DEFAULT_ENABLED : ResourcePackActivationType.NORMAL;
		ResourceManagerHelper.registerBuiltinResourcePack(id, FabricLoader.getInstance().getModContainer(CulturalDelights.MOD_ID).orElseThrow(), name, resourcePackActivationType);
	}
}
