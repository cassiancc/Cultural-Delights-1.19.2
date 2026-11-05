package com.baisylia.culturaldelights.refabricated;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.event.ModEvents;
import com.baisylia.culturaldelights.refabricated.event.BlockEvent;
import com.baisylia.culturaldelights.refabricated.event.VillagerTradesEvent;
import com.baisylia.culturaldelights.refabricated.util.Flammable;
import com.baisylia.culturaldelights.refabricated.util.ToolModifiableBlock;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.refabricated.ItemAbility;

public class CulturalDelightsRefabricated {
	static ResourceConditionType<FalseResourceCondition> FALSE = ResourceConditionType.create(ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "false"), FalseResourceCondition.CODEC);

	public static final AttachmentType<Double> INTOXICATION_STUMBLE_X = AttachmentRegistry.create(
			ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "cd_intox_stumble_x"), builder -> {
				builder.initializer(()->0d).syncWith(ByteBufCodecs.DOUBLE, AttachmentSyncPredicate.targetOnly());
			}
	);
	public static final AttachmentType<Double> INTOXICATION_STUMBLE_Z = AttachmentRegistry.create(
			ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, "cd_intox_stumble_z"), builder -> {
				builder.initializer(()->0d).syncWith(ByteBufCodecs.DOUBLE, AttachmentSyncPredicate.targetOnly());
			}
	);

	public static void init() {
		ResourceConditions.register(FALSE);
		for (Block block : BuiltInRegistries.BLOCK) {
			if (block instanceof Flammable flammable && flammable.isFlammable(null, null, null, null)) {
				FlammableBlockRegistry.getDefaultInstance().add(block, flammable.getFlammability(null, null, null, null), flammable.getFireSpreadSpeed(null, null, null, null));
			}
		}
		for (Item block : BuiltInRegistries.ITEM) {
			if (block instanceof Flammable flammable) {
				int burnTime = flammable.getBurnTime(block.getDefaultInstance(), null);
				if (burnTime > 0) {
					FuelRegistry.INSTANCE.add(block, burnTime);
				}
			}
		}
		UseBlockCallback.EVENT.register((player, world, hand, blockHitResult) -> {
			var state = world.getBlockState(blockHitResult.getBlockPos());
			if (state.getBlock() instanceof ToolModifiableBlock toolModifiableBlock && player.getItemInHand(hand).is(ItemTags.AXES)) {
				var newState = toolModifiableBlock.getToolModifiedState(state, new UseOnContext(player, hand, blockHitResult), ItemAbility.AXE_STRIP, false);
				if (newState != null) {
					world.setBlockAndUpdate(blockHitResult.getBlockPos(), newState);
					return InteractionResult.SUCCESS;
				}
			}
			if (player.getItemInHand(hand).getItem() instanceof BlockItem blockItem) {
				var event = new BlockEvent.EntityPlaceEvent(player, blockHitResult.getBlockPos(), state, world);
				ModEvents.onBlockPlace(event);
			}
			return InteractionResult.PASS;
		});
		var event = new VillagerTradesEvent();
		ModEvents.addCustomTrades(event);
		event.getTrades().forEach((integer, itemListings) -> {
			TradeOfferHelper.registerVillagerOffers(event.getType(), integer, (list)->list.addAll(itemListings));
		});
	}
}
