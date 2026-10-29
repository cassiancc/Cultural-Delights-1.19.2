package com.baisylia.culturaldelights.advancement;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.registries.Registries;
import com.baisylia.culturaldelights.refabricated.loader.IEventBus;
import com.baisylia.culturaldelights.refabricated.registry.DeferredHolder;
import com.baisylia.culturaldelights.refabricated.registry.DeferredRegister;

public class ModAdvancements {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS =
            DeferredRegister.create(Registries.TRIGGER_TYPE, CulturalDelights.MOD_ID);

    public static final DeferredHolder<CriterionTrigger<?>, SaltGrowthTrigger> GROW_SALT_SPIKE =
            TRIGGERS.register("grow_salt_spike", SaltGrowthTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, PlayerTrigger> GROW_BEANSTALK_TO_HEIGHT_LIMIT =
            TRIGGERS.register("grow_beanstalk_to_height_limit", PlayerTrigger::new);

    public static void register(IEventBus eventBus) {
        TRIGGERS.register(eventBus);
    }
}
