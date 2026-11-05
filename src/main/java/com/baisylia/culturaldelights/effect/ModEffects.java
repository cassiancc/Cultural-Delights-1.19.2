package com.baisylia.culturaldelights.effect;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.effect.custom.CheesyEffect;
import com.baisylia.culturaldelights.effect.custom.IntoxicationEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import cc.cassian.asphodel.util.deferred_registry.DeferredHolder;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, CulturalDelights.MOD_ID);

    public static final DeferredHolder<MobEffect, CheesyEffect> CHEESY = MOB_EFFECTS.register("cheesy",
            () -> new CheesyEffect(MobEffectCategory.BENEFICIAL, 0xF8CD44));

    public static final DeferredHolder<MobEffect, IntoxicationEffect> INTOXICATION = MOB_EFFECTS.register("intoxication",
            () -> new IntoxicationEffect(MobEffectCategory.BENEFICIAL, 0xFFFCF2));

    public static void register() {
        MOB_EFFECTS.register();
    }
}