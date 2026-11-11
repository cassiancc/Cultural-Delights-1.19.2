package com.baisylia.culturaldelights.world.feature.tree;

import com.baisylia.culturaldelights.world.feature.ModConfiguredFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class AvocadoPitGrower {
    public static final TreeGrower AVOCADO_PIT_GROWER = new TreeGrower(
            "culturaldelights:avocado_pit",
            WeightedList.of(ModConfiguredFeatures.AVOCADO_PIT_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ModConfiguredFeatures.AVOCADO_PIT_KEY
    );
}