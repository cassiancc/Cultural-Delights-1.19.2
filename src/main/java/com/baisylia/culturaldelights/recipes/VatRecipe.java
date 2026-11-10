package com.baisylia.culturaldelights.recipes;

import com.baisylia.culturaldelights.util.VatTemperature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import vectorwing.farmersdelight.refabricated.inventory.RecipeWrapper;

import java.util.Optional;

public class VatRecipe implements Recipe<RecipeWrapper> {

    private final ItemStackTemplate output;
    private final NonNullList<Ingredient> recipeItems;
    private final VatTemperature temperature;
    private final @Nullable Ingredient containerItem;
    private final int cookTime;

    public VatRecipe(ItemStackTemplate output, NonNullList<Ingredient> recipeItems, VatTemperature temperature, Optional<Ingredient> containerItem, int cookTime) {
        this(output, recipeItems, temperature, containerItem.orElse(null), cookTime);
    }

    public VatRecipe(ItemStackTemplate output, NonNullList<Ingredient> recipeItems, VatTemperature temperature, @Nullable Ingredient containerItem, int cookTime) {
        this.output = output;
        this.recipeItems = recipeItems;
        this.temperature = temperature;
        this.containerItem = containerItem;
        this.cookTime = cookTime;
    }

    public VatTemperature getTemperature() {
        return this.temperature;
    }

    public Optional<Ingredient> getContainer() {
        return Optional.ofNullable(this.containerItem);
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeWrapper>> getSerializer() {
        return ModRecipes.AGING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<RecipeWrapper>> getType() {
        return ModRecipes.AGING_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return null;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    public ItemStack getResultItem() {
        return this.output.create();
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        // Check if output slot is already occupied with a different item
        ItemStack outputSlot = inv.getItem(7);
        if (!outputSlot.isEmpty() && !ItemStack.isSameItemSameComponents(this.output.create(), outputSlot)) {
            return false;
        }
        if (!outputSlot.isEmpty() && outputSlot.getCount() >= outputSlot.getMaxStackSize()) {
            return false;
        }

        // Container
        ItemStack containerSlot = inv.getItem(6);
        boolean containerMatches;
        if (this.containerItem.isEmpty()) {
            containerMatches = containerSlot.isEmpty();
        } else {
            containerMatches = this.containerItem.test(containerSlot);
        }
        if (!containerMatches) {
            return false;
        }

        StackedItemContents inputs = new StackedItemContents();
        int count = 0;
        for (int j = 0; j < 6; ++j) {
            ItemStack stack = inv.getItem(j);
            if (!stack.isEmpty()) {
                ++count;
                inputs.accountStack(stack, 1);
            }
        }

        return count == this.recipeItems.size() && inputs.canCraft(this, null);
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output.create();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "";
    }

    public static class Serializer {
        public static final StreamCodec<RegistryFriendlyByteBuf, VatRecipe> STREAM_CODEC = StreamCodec.of(
                VatRecipe.Serializer::toNetwork,
                VatRecipe.Serializer::fromNetwork
        );
        private static final MapCodec<VatRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                ItemStackTemplate.CODEC.fieldOf("result").forGetter(r -> r.output),
                Ingredient.CODEC.listOf().fieldOf("ingredients").xmap(ingredients -> {
                    NonNullList<Ingredient> nonNullList = NonNullList.create();
                    nonNullList.addAll(ingredients);
                    return nonNullList;
                }, ingredients -> ingredients).forGetter(VatRecipe::getIngredients),
                VatTemperature.CODEC.optionalFieldOf("temperature", VatTemperature.NORMAL).forGetter(VatRecipe::getTemperature),
                Ingredient.CODEC.optionalFieldOf("container").forGetter(VatRecipe::getContainer),
                Codec.INT.optionalFieldOf("cooktime", 200).forGetter(VatRecipe::getCookTime)
        ).apply(inst, VatRecipe::new));

        private static VatRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, null);
            inputs.replaceAll(ignored -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));

            Ingredient container = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            VatTemperature temperature = buffer.readEnum(VatTemperature.class);
            ItemStackTemplate output = ItemStackTemplate.STREAM_CODEC.decode(buffer);
            int cookTime = buffer.readVarInt();
            return new VatRecipe(output, inputs, temperature, container, cookTime);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, VatRecipe recipe) {
            buffer.writeVarInt(recipe.recipeItems.size());
            for (Ingredient ingredient : recipe.recipeItems) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.containerItem);
            buffer.writeEnum(recipe.temperature);
            ItemStackTemplate.STREAM_CODEC.encode(buffer, recipe.output);
            buffer.writeVarInt(recipe.cookTime);
        }

        public static RecipeSerializer<VatRecipe> create() {
            return new RecipeSerializer<>(CODEC, STREAM_CODEC);
        }

    }
}