package com.baisylia.culturaldelights.effect.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

import static com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated.INTOXICATION_STUMBLE_X;
import static com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated.INTOXICATION_STUMBLE_Z;

public class IntoxicationEffect extends MobEffect {

    public IntoxicationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        var tag = entity;

        // Slowness
        double speedFactor = 1.0 - 0.05 * amplifier;
        speedFactor = Math.max(speedFactor, 0.2);
        Vec3 movement = entity.getDeltaMovement();
        movement = movement.multiply(speedFactor, 1.0, speedFactor);

        // Stumbling
        if (amplifier >= 4) {
            double stumbleX = tag.getAttachedOrCreate(INTOXICATION_STUMBLE_X);
            double stumbleZ = tag.getAttachedOrCreate(INTOXICATION_STUMBLE_Z);

            if (entity.getRandom().nextDouble() < 0.1) {
                stumbleX = (entity.getRandom().nextDouble() - 0.5) * 0.15;
                stumbleZ = (entity.getRandom().nextDouble() - 0.5) * 0.15;
            }

            tag.setAttached(INTOXICATION_STUMBLE_X, stumbleX);
            tag.setAttached(INTOXICATION_STUMBLE_Z, stumbleZ);

            movement = movement.add(stumbleX, 0, stumbleZ);
        }

        entity.setDeltaMovement(movement);

        // Nausea
        if (!entity.level().isClientSide() && amplifier >= 4) {
            entity.addEffect(new MobEffectInstance(
                    MobEffects.NAUSEA,
                    100 * amplifier,
                    amplifier - 3,
                    false,
                    true
            ));
        }
        // Poison
        if (!entity.level().isClientSide() && amplifier >= 6) {
            entity.addEffect(new MobEffectInstance(
                    MobEffects.POISON,
                    50 * amplifier,
                    amplifier - 5,
                    false,
                    true
            ));
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}