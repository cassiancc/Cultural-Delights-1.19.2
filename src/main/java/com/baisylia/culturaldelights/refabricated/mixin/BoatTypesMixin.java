package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.event.ModEvents;
import com.baisylia.culturaldelights.refabricated.event.LivingEvent;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Boat.Type.class)
public enum BoatTypesMixin {
	CULUTRALDELIGHTS_BEANSTALK(Blocks.AIR, CulturalDelights.MOD_ID + "_beanstalk");

	@Shadow
	BoatTypesMixin(final Block planks, final String name) {
	}

	@ModifyReturnValue(method = "getPlanks", at = @At("RETURN"))
	private Block deferPlanks(Block original) {
		if (this.equals(CULUTRALDELIGHTS_BEANSTALK)) {
			return ModBlocks.BEANSTALK_PLANKS.get();
		}
		return original;
	}
}
