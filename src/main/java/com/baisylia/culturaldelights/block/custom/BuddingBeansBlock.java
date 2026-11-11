package com.baisylia.culturaldelights.block.custom;

import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import vectorwing.farmersdelight.common.block.BuddingBushBlock;
import vectorwing.farmersdelight.common.block.BuddingTomatoBlock;

public class BuddingBeansBlock extends BuddingTomatoBlock {
    public static final MapCodec<BuddingBeansBlock> CODEC = null;

    public BuddingBeansBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public MapCodec<BuddingBeansBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState updateShape(BlockState state, @NonNull LevelReader level, @NonNull ScheduledTickAccess scheduledTickAccess, @NonNull BlockPos pos, @NonNull Direction direction, @NonNull BlockPos neighborPos, @NonNull BlockState neighborState, @NonNull RandomSource random) {
        if (state.getValue(BuddingBushBlock.AGE) == 4 && level instanceof Level level1) {
            level1.setBlock(pos, ModBlocks.BEANS.get().defaultBlockState(), 3);
        }

        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void growPastMaxAge(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlockAndUpdate(pos, ModBlocks.BEANS.get().defaultBlockState());
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        int maxAge = this.getMaxAge();
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 7);
        if (ageGrowth <= maxAge) {
            level.setBlockAndUpdate(pos, state.setValue(AGE, ageGrowth));
        } else {
            int remainingGrowth = ageGrowth - maxAge - 1;
            level.setBlockAndUpdate(pos, ModBlocks.BEANS.get().defaultBlockState().setValue(BeansBlock.VINE_AGE, remainingGrowth));
        }
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.BEANS.get();
    }
}