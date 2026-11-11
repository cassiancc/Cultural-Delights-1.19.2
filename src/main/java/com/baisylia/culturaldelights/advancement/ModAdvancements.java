package com.baisylia.culturaldelights.advancement;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.advancements.triggers.CriterionTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.registries.Registries;
import cc.cassian.asphodel.util.deferred_registry.DeferredHolder;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;

public class ModAdvancements {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS =
            DeferredRegister.create(Registries.TRIGGER_TYPE, CulturalDelights.MOD_ID);

    public static final DeferredHolder<CriterionTrigger<?>, SaltGrowthTrigger> GROW_SALT_SPIKE =
            TRIGGERS.register("grow_salt_spike", SaltGrowthTrigger::new);

    public static final DeferredHolder<CriterionTrigger<?>, PlayerTrigger> GROW_BEANSTALK_TO_HEIGHT_LIMIT =
            TRIGGERS.register("grow_beanstalk_to_height_limit", PlayerTrigger::new);

    public static void register() {
        TRIGGERS.register();
    }
}
