package com.baisylia.culturaldelights.refabricated;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.block.custom.CornBlock;
import com.baisylia.culturaldelights.effect.ModEffects;
import com.baisylia.culturaldelights.event.EventBusEvents;
import com.baisylia.culturaldelights.event.ModEvents;
import com.baisylia.culturaldelights.recipes.ModRecipes;
import com.baisylia.culturaldelights.refabricated.event.BlockEvent;
import com.baisylia.culturaldelights.refabricated.event.MobEffectEvent;
import com.baisylia.culturaldelights.refabricated.util.Flammable;
import com.baisylia.culturaldelights.refabricated.util.ToolModifiableBlock;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.effect.ServerMobEffectEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.refabricated.ItemAbility;

import java.util.List;
import java.util.Map;

public class CulturalDelightsRefabricated {
	public static final AttachmentType<Double> INTOXICATION_STUMBLE_X = AttachmentRegistry.create(
			id("cd_intox_stumble_x"), builder -> {
				builder.initializer(()->0d).syncWith(ByteBufCodecs.DOUBLE, AttachmentSyncPredicate.targetOnly());
			}
	);
	public static final AttachmentType<Double> INTOXICATION_STUMBLE_Z = AttachmentRegistry.create(
			id("cd_intox_stumble_z"), builder -> {
				builder.initializer(()->0d).syncWith(ByteBufCodecs.DOUBLE, AttachmentSyncPredicate.targetOnly());
			}
	);

	public static void init() {
		for (Block block : BuiltInRegistries.BLOCK) {
			if (block instanceof Flammable flammable && flammable.isFlammable(null, null, null, null)) {
				FlammableBlockRegistry.getDefaultInstance().add(block, flammable.getFlammability(null, null, null, null), flammable.getFireSpreadSpeed(null, null, null, null));
			}
		}
		FuelValueEvents.BUILD.register((builder, context) -> {
			for (Item block : BuiltInRegistries.ITEM) {
				if (block instanceof Flammable flammable) {
					int burnTime = flammable.getBurnTime(block.getDefaultInstance(), null);
					if (burnTime > 0) {
							builder.add(block, burnTime);
					}
				}
			}
		});
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
		LootTableEvents.MODIFY.register((resourceKey, builder, lootTableSource, provider) -> {
			if (resourceKey.equals(ModBlocks.CORN.get().getLootTable().orElse(null))) {
				LootItemCondition.Builder grown = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CORN.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
				LootItemCondition.Builder tool = MatchTool.toolMatches(ItemPredicate.Builder.item().of(provider.lookupOrThrow(Registries.ITEM), ModTags.Items.STRAW_HARVESTERS));

				builder.withPool(new LootPool.Builder().when(grown).when(tool).add(LootItem.lootTableItem(ModItems.STRAW.get())));
			}
		});
		addCompostables();
		addFeature("agave_placed", BiomeTags.IS_SAVANNA);
		addFeature("avocado_placed", BiomeTags.IS_JUNGLE);
		addFeature("mint_placed", BiomeTags.IS_MOUNTAIN);
		addFeature("salt_placed", Biomes.DRIPSTONE_CAVES);
		addFeature("lemon_placed", Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_SAVANNA);
		addFeature("wild_beans_placed", TagKey.create(Registries.BIOME, id("has_wild_beans")));
		addFeature("wild_corn_placed", ConventionalBiomeTags.IS_PLAINS);
		addFeature("wild_cucumbers_placed", ConventionalBiomeTags.IS_SWAMP);
		addFeature("wild_eggplants_placed", BiomeTags.IS_JUNGLE);
		ServerMobEffectEvents.ALLOW_ADD.register((effectInstance, entity, ctx) -> {
			MobEffectEvent.Applicable event = new MobEffectEvent.Applicable(entity, effectInstance);
			EventBusEvents.onEffectApplicable(event);
			EventBusEvents.intoxicationStack(event);
			if (event.getResult().equals(MobEffectEvent.Applicable.Result.DO_NOT_APPLY)) {
				return false;
			}
			return true;
		});
		ModRecipes.SERIALIZERS.addCallback(()->{
			List.of(ModRecipes.BAKING_SHAPED_SERIALIZER, ModRecipes.BAKING_SERIALIZER, ModRecipes.AGING_SERIALIZER).forEach(recipe->{
				RecipeSynchronization.synchronizeRecipeSerializer(recipe.get());
			});
		});
	}

	private static void addFeature(String path, TagKey<Biome> tag) {
		BiomeModifications.addFeature(BiomeSelectors.tag(tag), GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, id(path)));
	}

	private static void addFeature(String path, ResourceKey<Biome> tag) {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(tag), GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, id(path)));
	}

	@SafeVarargs
	private static void addFeature(String path, ResourceKey<Biome>... tag) {
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(tag), GenerationStep.Decoration.VEGETAL_DECORATION, ResourceKey.create(Registries.PLACED_FEATURE, id(path)));
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(CulturalDelights.MOD_ID, path);
	}

	private static final String COMPOSTABLES = "{\n" +
			"  \"values\": {\n" +
			"    \"culturaldelights:cucumber_seeds\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:corn_kernels\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:eggplant_seeds\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:avocado_pit\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:cut_cucumber\": {\n" +
			"      \"chance\": 0.5\n" +
			"    },\n" +
			"    \"culturaldelights:cut_avocado\": {\n" +
			"      \"chance\": 0.5\n" +
			"    },\n" +
			"    \"culturaldelights:cut_eggplant\": {\n" +
			"      \"chance\": 0.5\n" +
			"    },\n" +
			"    \"culturaldelights:avocado\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:cucumber\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:corn_cob\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:eggplant\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:white_eggplant\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:bean_pod\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:beans\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:agave\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:mint\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:wild_cucumbers\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:wild_corn\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:wild_eggplants\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:wild_beans\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:avocado_leaves\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:avocado_sapling\": {\n" +
			"      \"chance\": 0.65\n" +
			"    },\n" +
			"    \"culturaldelights:popcorn\": {\n" +
			"      \"chance\": 0.85\n" +
			"    },\n" +
			"    \"culturaldelights:lemon\": {\n" +
			"      \"chance\": 0.25\n" +
			"    },\n" +
			"    \"culturaldelights:fried_potato\": {\n" +
			"      \"chance\": 0.45\n" +
			"    },\n" +
			"    \"culturaldelights:lemon_leaves\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:fruiting_lemon_leaves\": {\n" +
			"      \"chance\": 0.3\n" +
			"    },\n" +
			"    \"culturaldelights:lemon_sapling\": {\n" +
			"      \"chance\": 0.3\n" +
			"    }\n" +
			"  }\n" +
			"}\n";

	public static void addCompostables() {
		JsonElement je = (new Gson()).fromJson(COMPOSTABLES, JsonElement.class);
		if (je != null) {
			JsonElement j = je.getAsJsonObject().get("values");

			for(Map.Entry<String, JsonElement> v : j.getAsJsonObject().asMap().entrySet()) {
				Item i = BuiltInRegistries.ITEM.getValue(Identifier.tryParse(v.getKey()));
				CompostableRegistry.INSTANCE.add(i, v.getValue().getAsJsonObject().get("chance").getAsFloat());
			}
		}

	}
}
