package com.baisylia.culturaldelights.refabricated;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;

public class FalseResourceCondition implements ResourceCondition {
	public static final MapCodec<FalseResourceCondition> CODEC = MapCodec.unit(FalseResourceCondition::new);

	@Override
	public ResourceConditionType<?> getType() {
		return CulturalDelightsRefabricated.FALSE;
	}

	@Override
	public boolean test(HolderLookup.@Nullable Provider provider) {
		return false;
	}

}