package com.baisylia.culturaldelights.refabricated.event;

import net.minecraft.world.entity.LivingEntity;

public class LivingEvent {
	public static class LivingJumpEvent {
		private final LivingEntity livingEntity;

		public LivingJumpEvent(LivingEntity livingEntity) {
			this.livingEntity = livingEntity;
		}

		public LivingEntity getEntity() {
			return livingEntity;
		}
	}
}
