package com.baisylia.culturaldelights.world.feature.tree;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.world.feature.ModConfiguredFeatures;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class LemonTreeGrower {
    public static final TreeGrower LEMON_TREE_GROWER = new TreeGrower(
            CulturalDelights.MOD_ID + ":lemon",
            WeightedList.of(ModConfiguredFeatures.LEMON_KEY),
            WeightedList.of(),
            WeightedList.of(),
            ModConfiguredFeatures.LEMON_KEY
    );
}
