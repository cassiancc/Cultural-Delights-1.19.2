package com.baisylia.culturaldelights.refabricated.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEvent {
	public static class EntityPlaceEvent {
		private final LivingEntity livingEntity;
		private BlockPos pos;
		private BlockState placedBlock;
		private LevelAccessor level;

		public EntityPlaceEvent(LivingEntity livingEntity, BlockPos pos, BlockState placedBlock, LevelAccessor level) {
			this.livingEntity = livingEntity;
			this.pos = pos;
			this.placedBlock = placedBlock;
			this.level = level;
		}

		public LivingEntity getEntity() {
			return livingEntity;
		}

		public BlockPos getPos() {
			return pos;
		}

		public BlockState getPlacedBlock() {
			return placedBlock;
		}

		public LevelAccessor getLevel() {
			return level;
		}
	}
}
