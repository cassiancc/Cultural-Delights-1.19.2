package com.baisylia.culturaldelights.block.custom;

import com.baisylia.culturaldelights.block.entity.ModBlockEntities;
import com.baisylia.culturaldelights.block.entity.custom.VatBlockEntity;
import com.baisylia.culturaldelights.util.VatTemperature;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.Nullable;

public class VatBlock extends BaseEntityBlock {
    public static final MapCodec<VatBlock> CODEC = null;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final EnumProperty<VatTemperature> TEMPERATURE =
            EnumProperty.create("temperature", VatTemperature.class);
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public VatBlock(Properties properties) {
        super(properties);
    }

    public MapCodec<VatBlock> codec() {
        return CODEC;
    }

    /* FACING */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite()).setValue(TEMPERATURE, VatTemperature.NORMAL).setValue(OPEN, false);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
        if (state.getValue(TEMPERATURE) == VatTemperature.HOT) {
            double x = (double) pos.getX() + (double) 0.5F;
            double y = pos.getY();
            double z = (double) pos.getZ() + (double) 0.5F;
            Direction direction = state.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double r1 = randomSource.nextDouble() * 0.6 - 0.3;
            double r2 = axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52 : r1;
            double r3 = randomSource.nextDouble() * (double) 6.0F / (double) 16.0F;
            double r4 = axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52 : r1;
            level.addParticle(ParticleTypes.SMOKE, x + r2, y + r3, z + r4, 0.0F, 0.0F, 0.0F);
            level.addParticle(ParticleTypes.FLAME, x + r2, y + r3, z + r4, 0.0, 0.0F, 0.0F);
        }
        if (state.getValue(TEMPERATURE) == VatTemperature.COLD) {
            double x = (double) pos.getX() + (double) 0.5F;
            double y = pos.getY();
            double z = (double) pos.getZ() + (double) 0.5F;
            Direction direction = state.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double r1 = randomSource.nextDouble() * 0.6 - 0.3;
            double r2 = axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52 : r1;
            double r3 = randomSource.nextDouble() * (double) 6.0F / (double) 16.0F;
            double r4 = axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52 : r1;
            level.addParticle(ParticleTypes.SNOWFLAKE, x + r2, y + r3, z + r4, 0.0F, 0.0F, 0.0F);
            level.addParticle(ParticleTypes.BUBBLE, x + r2, y + r3, z + r4, 0.0, 0.0F, 0.0F);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TEMPERATURE, OPEN);
    }

    /* BLOCK ENTITY */

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof VatBlockEntity VatBlockEntity) {
            VatBlockEntity.drops();
        }
        super.affectNeighborsAfterRemoval(state, level, pos, movedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof VatBlockEntity vatBlockEntity && pPlayer instanceof ServerPlayer serverPlayer) {
                serverPlayer.openMenu(vatBlockEntity);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.SUCCESS_SERVER;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VatBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.VAT_BLOCK_ENTITY.get(),
                VatBlockEntity::tick);
    }
}
