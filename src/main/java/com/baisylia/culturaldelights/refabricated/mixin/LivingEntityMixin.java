package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.event.EventBusEvents;
import com.baisylia.culturaldelights.event.ModEvents;
import com.baisylia.culturaldelights.refabricated.event.LivingEvent;
import com.baisylia.culturaldelights.refabricated.event.MobEffectEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(method = "canBeAffected", at = @At("HEAD"), cancellable = true)
	private void preventIntoxicationFromRemoval(MobEffectInstance effectInstance, CallbackInfoReturnable<Boolean> cir) {
		MobEffectEvent.Applicable event = new MobEffectEvent.Applicable((LivingEntity) (Object) this, effectInstance);
		EventBusEvents.onEffectApplicable(event);
		EventBusEvents.intoxicationStack(event);
		if (event.getResult().equals(MobEffectEvent.Applicable.Result.DO_NOT_APPLY)) {
			cir.setReturnValue(false);
		}
	}

	@Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
	private void jump(CallbackInfo ci) {
		LivingEvent.LivingJumpEvent event = new LivingEvent.LivingJumpEvent((LivingEntity) (Object) this);
		ModEvents.onLivingJump(event);
	}
}
