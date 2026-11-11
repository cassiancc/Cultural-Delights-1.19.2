package com.baisylia.culturaldelights.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Optional;

public class SaltGrowthTrigger extends SimpleCriterionTrigger<SaltGrowthTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<Holder<LootItemCondition>> player)
            implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                        LootItemCondition.CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player)
                ).apply(builder, TriggerInstance::new)
        );

        public boolean test() {
            return true;
        }
    }
}
