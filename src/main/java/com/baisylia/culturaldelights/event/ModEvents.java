package com.baisylia.culturaldelights.event;

import com.baisylia.culturaldelights.advancement.ModAdvancements;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.block.custom.SaltBlock;
import com.baisylia.culturaldelights.refabricated.event.BlockEvent;
import com.baisylia.culturaldelights.refabricated.event.LivingEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import com.baisylia.culturaldelights.block.custom.BeanstalkLeafBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Tilt;
import net.minecraft.world.phys.Vec3;

public class ModEvents {

    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            BlockPos pos = event.getPos();
            BlockState placed = event.getPlacedBlock();
            LevelAccessor level = event.getLevel();

            if (placed.is(Blocks.POINTED_DRIPSTONE) && placed.getValue(PointedDripstoneBlock.TIP_DIRECTION) == Direction.DOWN) {
                BlockState above = level.getBlockState(pos.above());
                if (above.is(ModBlocks.SALT_BLOCK.get()) && SaltBlock.isWaterAbove(level, pos.above())) {
                    ModAdvancements.GROW_SALT_SPIKE.get().trigger(player);
                }
            } else if (placed.is(ModBlocks.SALT_BLOCK.get())) {
                BlockState below = level.getBlockState(pos.below());
                if (below.is(Blocks.POINTED_DRIPSTONE) && below.getValue(PointedDripstoneBlock.TIP_DIRECTION) == Direction.DOWN) {
                    if (SaltBlock.isWaterAbove(level, pos)) {
                        ModAdvancements.GROW_SALT_SPIKE.get().trigger(player);
                    }
                }
            }
        }
    }

    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        BlockPos pos = entity.getOnPos();
        BlockState state = level.getBlockState(pos);

        if (!state.is(ModBlocks.BEANSTALK_LEAF.get())) {
            pos = entity.blockPosition();
            state = level.getBlockState(pos);
            if (!state.is(ModBlocks.BEANSTALK_LEAF.get())) {
                pos = entity.blockPosition().below();
                state = level.getBlockState(pos);
            }
        }

        if (state.is(ModBlocks.BEANSTALK_LEAF.get())) {
            Tilt tilt = state.getValue(BeanstalkLeafBlock.TILT);
            double boost;
            if (tilt == Tilt.FULL) {
                boost = 0.60;
            } else if (tilt == Tilt.PARTIAL) {
                boost = 0.38;
            } else {
                boost = 0.18;
            }

            Vec3 motion = entity.getDeltaMovement();
            entity.setDeltaMovement(motion.x, motion.y + boost, motion.z);
            entity.hurtMarked = true;

            if (!level.isClientSide() && tilt != Tilt.NONE) {
                BeanstalkLeafBlock.resetTilt(state, level, pos);
                level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.4F);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 0.9, pos.getZ() + 0.5, 6, 0.25, 0.1, 0.25, 0.02);
                }
            }
        }
    }
}
