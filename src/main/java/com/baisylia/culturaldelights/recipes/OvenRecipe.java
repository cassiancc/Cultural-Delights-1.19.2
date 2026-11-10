package com.baisylia.culturaldelights.recipes;

import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.util.VatTemperature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.refabricated.inventory.RecipeWrapper;

import java.util.List;

public class OvenRecipe implements Recipe<RecipeWrapper> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStackTemplate output;
    private final int cookTime;

    public OvenRecipe(NonNullList<Ingredient> inputItems, ItemStackTemplate output, int cookTime) {
        this.inputItems = inputItems;
        this.output = output;
        this.cookTime = cookTime;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    public ItemStack getResultItem() {
        return this.output.create();
    }

    public ItemStackTemplate getOutput() {
        return this.output;
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

    public int getCookTime() {
        return this.cookTime;
    }

    public static class Type implements RecipeType<OvenRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "baking";
    }

    public boolean matches(RecipeWrapper inv, Level level) {
        StackedItemContents inputs = new StackedItemContents();
        int i = 0;

        for (int j = 0; j < 9; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.accountStack(itemstack, 1);
            }
        }

        return i == this.inputItems.size() && inputs.canCraft(this, null);
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.inputItems.size();
    }

    public RecipeSerializer<? extends Recipe<RecipeWrapper>> getSerializer() {
        return ModRecipes.BAKING_SERIALIZER.get();
    }

    public RecipeType<? extends Recipe<RecipeWrapper>> getType() {
        return ModRecipes.BAKING.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItems);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.OVEN.get());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            OvenRecipe that = (OvenRecipe) o;
            if (this.getCookTime() != that.getCookTime()) {
                return false;
            } else if (!this.inputItems.equals(that.inputItems)) {
                return false;
            } else {
                return this.output.equals(that.output);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.inputItems.hashCode();
        result = 31 * result + this.output.hashCode();
        result = 31 * result + this.getCookTime();
        return result;
    }

    public static class Serializer {
        private static final MapCodec<OvenRecipe> CODEC = RecordCodecBuilder.mapCodec((inst) -> inst.group(
                Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(OvenRecipe::getIngredients),
                ItemStackTemplate.CODEC.fieldOf("result").forGetter((r) -> r.output),
                Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(OvenRecipe::getCookTime)
        ).apply(inst, (ingredients, output, cookTime) -> new OvenRecipe(copyOf(ingredients), output, cookTime)));

        public static final StreamCodec<RegistryFriendlyByteBuf, OvenRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.collection(NonNullList::createWithCapacity)),
                OvenRecipe::getIngredients,
                ItemStackTemplate.STREAM_CODEC,
                OvenRecipe::getOutput,
                ByteBufCodecs.INT,
                OvenRecipe::getCookTime,
                OvenRecipe::new
        );

        private static NonNullList<Ingredient> copyOf(List<Ingredient> ingredients) {
            NonNullList<Ingredient> withCapacity = NonNullList.createWithCapacity(ingredients.size());
            withCapacity.addAll(List.copyOf(ingredients));
            return withCapacity;
        }

        public static RecipeSerializer<OvenRecipe> create() {
            return new RecipeSerializer<>(CODEC, STREAM_CODEC);
        }
    }
}
