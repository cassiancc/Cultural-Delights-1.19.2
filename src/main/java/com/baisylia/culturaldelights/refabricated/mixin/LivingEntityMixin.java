package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.event.ModEvents;
import com.baisylia.culturaldelights.refabricated.event.LivingEvent;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
	private void jump(CallbackInfo ci) {
		LivingEvent.LivingJumpEvent event = new LivingEvent.LivingJumpEvent((LivingEntity) (Object) this);
		ModEvents.onLivingJump(event);
	}
}
