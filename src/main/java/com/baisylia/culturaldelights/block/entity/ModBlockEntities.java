package com.baisylia.culturaldelights.block.entity;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.block.entity.custom.OvenBlockEntity;
import com.baisylia.culturaldelights.block.entity.custom.VatBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CulturalDelights.MOD_ID);

    public static final Supplier<BlockEntityType<VatBlockEntity>> VAT_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("vat_block_entity", () ->
                    FabricBlockEntityTypeBuilder.create(VatBlockEntity::new,
                            ModBlocks.VAT.get()).build(null));

    public static final Supplier<BlockEntityType<OvenBlockEntity>> OVEN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("oven_block_entity", () ->
                    FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new,
                            ModBlocks.OVEN.get()).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}