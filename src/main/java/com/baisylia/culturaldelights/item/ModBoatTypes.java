package com.baisylia.culturaldelights.item;

import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import com.baisylia.culturaldelights.refabricated.loader.EnumProxy;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestRaft;
import net.minecraft.world.entity.vehicle.boat.Raft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class ModBoatTypes {
    @SuppressWarnings("unused")
    public static final EntityType<Raft> BEANSTALK = register("beanstalk_raft",EntityType.Builder.of(raftFactory(ModItems.BEANSTALK_RAFT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    public static final EntityType<ChestRaft> BEANSTALK_CHEST_BOAT = register("beanstalk_chest_raft", EntityType.Builder.of(chestRaftFactory(ModItems.BEANSTALK_CHEST_RAFT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));


    private static <T extends Entity> EntityType<T> register(final String id, final EntityType.Builder<T> builder) {
        return register(CulturalDelightsRefabricated.id(id), builder);
    }

    private static <T extends Entity> EntityType<T> register(final Identifier id, final EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(ResourceKey.create(Registries.ENTITY_TYPE, id)));
    }

    private static EntityType.EntityFactory<Raft> raftFactory(final Supplier<Item> dropItem) {
        return (entityType, level) -> new Raft(entityType, level, dropItem);
    }

    private static EntityType.EntityFactory<ChestRaft> chestRaftFactory(final Supplier<Item> dropItem) {
        return (entityType, level) -> new ChestRaft(entityType, level, dropItem);
    }
}
