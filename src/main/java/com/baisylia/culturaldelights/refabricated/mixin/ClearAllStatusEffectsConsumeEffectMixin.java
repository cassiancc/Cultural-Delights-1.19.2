package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.effect.ModEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Iterator;
import java.util.List;

@Mixin(ClearAllStatusEffectsConsumeEffect.class)
public class ClearAllStatusEffectsConsumeEffectMixin {
	@WrapOperation(method = "apply", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;removeAllEffects()Z"))
	private boolean init(LivingEntity instance, Operation<Boolean> original) {
		if (!instance.hasEffect(ModEffects.INTOXICATION)) return original.call(instance);
		if (instance.level().isClientSide()) {
			return false;
		} else {
			Iterator<MobEffectInstance> iterator = instance.getActiveEffectsMap().values().iterator();

			boolean bl;
			for(bl = false; iterator.hasNext(); bl = true) {
				MobEffectInstance next = iterator.next();
				if (!next.is(ModEffects.INTOXICATION)) {
					instance.onEffectsRemoved(List.of(next));
					iterator.remove();
				}

			}

			return bl;
		}
	}
}
