package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.ModItems;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Boat.Type.class)
public enum BoatTypesMixin {
	CULUTRALDELIGHTS_BEANSTALK(Blocks.AIR, CulturalDelights.MOD_ID + "_beanstalk");

	@Shadow
	BoatTypesMixin(final Block planks, final String name) {

	}
}
