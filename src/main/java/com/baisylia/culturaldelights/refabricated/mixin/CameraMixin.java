package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.event.ClientEvents;
import com.baisylia.culturaldelights.event.EventBusEvents;
import com.baisylia.culturaldelights.refabricated.event.MobEffectEvent;
import com.baisylia.culturaldelights.refabricated.event.ViewportEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.Camera;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public class CameraMixin {

	@WrapOperation(method = "alignWithEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;setRotation(FF)V", ordinal = 0))
	private void init(Camera instance, float yRot, float xRot, Operation<Void> original, final float partialTicks) {
		var event = new ViewportEvent.ComputeCameraAngles(instance, partialTicks, yRot, xRot);
		ClientEvents.onComputeCameraAngles(event);
		original.call(instance, event.getYaw(), event.getPitch());
		//FIXME apply roll
	}
}
