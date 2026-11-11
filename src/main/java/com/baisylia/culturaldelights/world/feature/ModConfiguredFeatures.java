package com.baisylia.culturaldelights.world.feature;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModConfiguredFeatures {
    public static final ResourceKey<Feature> AVOCADO_TREE_KEY = registerKey("avocado");
    public static final ResourceKey<Feature> AVOCADO_SPAWN_KEY = registerKey("avocado_spawn");
    public static final ResourceKey<Feature> AVOCADO_PIT_KEY = registerKey("avocado_pit");
    public static final ResourceKey<Feature> AGAVE_KEY = registerKey("agave");
    public static final ResourceKey<Feature> MINT_KEY = registerKey("mint");
    public static final ResourceKey<Feature> WILD_CORN_KEY = registerKey("wild_corn");
    public static final ResourceKey<Feature> WILD_CUCUMBERS_KEY = registerKey("wild_cucumbers");
    public static final ResourceKey<Feature> WILD_EGGPLANTS_KEY = registerKey("wild_eggplants");
    public static final ResourceKey<Feature> WILD_BEANS_KEY = registerKey("wild_beans");
    public static final ResourceKey<Feature> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<Feature> SALT_KEY = registerKey("salt");

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, name));
    }
}
