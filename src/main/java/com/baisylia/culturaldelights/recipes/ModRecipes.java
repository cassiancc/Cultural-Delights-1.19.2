package com.baisylia.culturaldelights.recipes;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import com.baisylia.culturaldelights.refabricated.loader.IEventBus;
import com.baisylia.culturaldelights.refabricated.registry.DeferredHolder;
import com.baisylia.culturaldelights.refabricated.registry.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, CulturalDelights.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, CulturalDelights.MOD_ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<VatRecipe>> AGING_TYPE =
            RECIPE_TYPES.register("aging", () -> simple(ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "aging")));

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<VatRecipe>> AGING_SERIALIZER =
            SERIALIZERS.register("aging", VatRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<OvenRecipe>> BAKING =
            RECIPE_TYPES.register("baking", () -> simple(ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "baking")));

    public static final DeferredHolder<RecipeType<?>, RecipeType<OvenShapedRecipe>> BAKING_SHAPED =
            RECIPE_TYPES.register("baking_shaped", () -> simple(ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "baking_shaped")));

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OvenRecipe>> BAKING_SERIALIZER =
            SERIALIZERS.register("baking", OvenRecipe.Serializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OvenShapedRecipe>> BAKING_SHAPED_SERIALIZER =
            SERIALIZERS.register("baking_shaped", OvenShapedRecipe.Serializer::new);

    public static final DeferredRegister<RecipeType<?>> CC_RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, "cookscollection");

    public static final DeferredRegister<RecipeSerializer<?>> CC_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, "cookscollection");

    public static final DeferredHolder<RecipeType<?>, RecipeType<OvenRecipe>> CC_BAKING =
            CC_RECIPE_TYPES.register("baking", () -> simple(ResourceLocation.fromNamespaceAndPath("cookscollection", "baking")));

    public static final DeferredHolder<RecipeType<?>, RecipeType<OvenShapedRecipe>> CC_BAKING_SHAPED =
            CC_RECIPE_TYPES.register("baking_shaped", () -> simple(ResourceLocation.fromNamespaceAndPath("cookscollection", "baking_shaped")));

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OvenRecipe>> CC_BAKING_SERIALIZER =
            CC_SERIALIZERS.register("baking", OvenRecipe.Serializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OvenShapedRecipe>> CC_BAKING_SHAPED_SERIALIZER =
            CC_SERIALIZERS.register("baking_shaped", OvenShapedRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        SERIALIZERS.register(eventBus);
        CC_RECIPE_TYPES.register(eventBus);
        CC_SERIALIZERS.register(eventBus);
    }

    private static RecipeType<?> simple(ResourceLocation resourceLocation) {
        return new RecipeType<>() {
            public String toString() {
                return resourceLocation.toString();
            }
        };
    }
}
