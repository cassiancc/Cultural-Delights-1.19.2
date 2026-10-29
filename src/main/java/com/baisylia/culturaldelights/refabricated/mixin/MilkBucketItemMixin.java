package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.effect.ModEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.MilkBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Iterator;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {
	@WrapOperation(method = "finishUsingItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;removeAllEffects()Z"))
	private boolean init(LivingEntity instance, Operation<Boolean> original) {
		if (instance.level().isClientSide) {
			return false;
		} else {
			Iterator<MobEffectInstance> iterator = instance.getActiveEffectsMap().values().iterator();

			boolean bl;
			for(bl = false; iterator.hasNext(); bl = true) {
				MobEffectInstance next = iterator.next();
				if (!next.is(ModEffects.INTOXICATION)) {
					instance.onEffectRemoved(next);
					iterator.remove();
				}

			}

			return bl;
		}
	}
}
