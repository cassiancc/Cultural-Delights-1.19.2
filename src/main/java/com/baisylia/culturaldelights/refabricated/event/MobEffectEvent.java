package com.baisylia.culturaldelights.refabricated.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class MobEffectEvent {
	public static class Applicable {
		private final LivingEntity entity;
		private final MobEffectInstance effect;
		private Result result;

		public Applicable(LivingEntity entity, MobEffectInstance effect) {
			result = Result.APPLY;
			this.entity = entity;
			this.effect = effect;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		public LivingEntity getEntity() {
			return entity;
		}

		public MobEffectInstance getEffectInstance() {
			return effect;
		}

		public Result getResult() {
			return result;
		}

		public enum Result {
			APPLY,
			DO_NOT_APPLY
		}
	}
}
