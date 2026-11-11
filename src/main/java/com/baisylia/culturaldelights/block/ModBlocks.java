package com.baisylia.culturaldelights.block;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.custom.*;
import com.baisylia.culturaldelights.integration.supplementaries.SupplementariesCompat;
import com.baisylia.culturaldelights.item.ModItems;
import com.baisylia.culturaldelights.world.feature.tree.AvocadoPitGrower;
import com.baisylia.culturaldelights.world.feature.tree.AvocadoTreeGrower;
import com.baisylia.culturaldelights.world.feature.tree.LemonTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import com.baisylia.culturaldelights.refabricated.patch.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import com.baisylia.culturaldelights.refabricated.loader.ModList;
import vectorwing.farmersdelight.refabricated.ItemAbility;
import cc.cassian.asphodel.util.deferred_registry.DeferredBlock;
import cc.cassian.asphodel.util.deferred_registry.DeferredItem;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;
import com.baisylia.culturaldelights.refabricated.patch.LeavesBlock;
import com.baisylia.culturaldelights.refabricated.patch.RotatedPillarBlock;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import static vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE;
import static vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE;

import org.jetbrains.annotations.Nullable;
import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CulturalDelights.MOD_ID);

    public static final DeferredBlock<Block> VAT = registerBlock("vat",
			VatBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)
                    .strength(5.0f, 6.0f).requiresCorrectToolForDrops().sound(SoundType.METAL), false, 0);

    public static final DeferredBlock<Block> AGAVE = registerBlock("agave",
            (p) -> new WildCropBlock(MobEffects.NAUSEA, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), true, 40);
    public static final DeferredBlock<FlowerPotBlock> POTTED_AGAVE = registerBlockWithoutBlockItem("potted_agave",
            (p) -> new FlowerPotBlock(AGAVE.get(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));
    public static final DeferredBlock<Block> MINT = registerBlock("mint",
            (p) -> new WildCropBlock(MobEffects.STRENGTH, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), true, 40);
    public static final DeferredBlock<FlowerPotBlock> POTTED_MINT = registerBlockWithoutBlockItem("potted_mint",
            (p) -> new FlowerPotBlock(MINT.get(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM));

    public static final DeferredBlock<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers",
            (p) -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), false, 0);
    public static final DeferredBlock<Block> WILD_CORN = registerBlock("wild_corn",
            (p) -> new WildCropBlock(MobEffects.HUNGER, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), false, 0);
    public static final DeferredBlock<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants",
            (p) -> new WildCropBlock(MobEffects.STRENGTH, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), false, 0);
    public static final DeferredBlock<Block> WILD_BEANS = registerBlock("wild_beans",
            (p) -> new WildCropBlock(MobEffects.ABSORPTION, 6, p),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS), false, 0);

    public static final DeferredBlock<Block> BEANSTALK = registerBlock("beanstalk",
			BeanstalkBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                    .strength(1.0F).sound(SoundType.STEM).pushReaction(PushReaction.POPPED), false, 0);

    public static final DeferredBlock<Block> BEANSTALK_LEAF = registerBlock("beanstalk_leaf",
			BeanstalkLeafBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                    .noOcclusion().strength(0.2F).sound(SoundType.BIG_DRIPLEAF).pushReaction(PushReaction.POPPED), false, 0);

    public static final DeferredBlock<Block> MAGIC_BEANS = registerBlock("magic_beans",
			MagicBeansBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .noCollision().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.POPPED), false, 0);

    public static final DeferredBlock<Block> STRIPPED_BEANSTALK = registerBlock("stripped_beanstalk",
			StrippedBeanstalkBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASS).strength(1.0F).sound(SoundType.STEM).ignitedByLava(), false, 0);

    public static final DeferredBlock<Block> BEANSTALK_PLANKS = registerBlock("beanstalk_planks",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_STAIRS = registerBlock("beanstalk_stairs",
            (p) -> new StairBlock(BEANSTALK_PLANKS.get().defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_SLAB = registerBlock("beanstalk_slab",
			SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_FENCE = registerBlock("beanstalk_fence",
			FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_FENCE_GATE = registerBlock("beanstalk_fence_gate",
            (p) -> new FenceGateBlock(ModWoodTypes.BEANSTALK, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_DOOR = registerBlock("beanstalk_door",
            (p) -> new DoorBlock(ModWoodTypes.BEANSTALK_SET, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).mapColor(MapColor.COLOR_LIGHT_GREEN),
            block -> new DoubleHighBlockItem(block, blockItemProperties(block)));
    public static final DeferredBlock<Block> BEANSTALK_TRAPDOOR = registerBlock("beanstalk_trapdoor",
            (p) -> new TrapDoorBlock(ModWoodTypes.BEANSTALK_SET, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_PRESSURE_PLATE = registerBlock("beanstalk_pressure_plate",
            (p) -> new PressurePlateBlock(ModWoodTypes.BEANSTALK_SET, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_GREEN), false, 0);
    public static final DeferredBlock<Block> BEANSTALK_BUTTON = registerBlock("beanstalk_button",
            (p) -> new ButtonBlock(ModWoodTypes.BEANSTALK_SET, 30, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), false, 0);

    public static final DeferredBlock<Block> BEANSTALK_SIGN = registerBlockWithoutBlockItem("beanstalk_sign",
            (p) -> new StandingSignBlock(ModWoodTypes.BEANSTALK, p), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    public static final DeferredBlock<Block> BEANSTALK_WALL_SIGN = registerBlockWithoutBlockItem("beanstalk_wall_sign",
            (p) -> new WallSignBlock(ModWoodTypes.BEANSTALK, p), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F)
//                    .overrideLootTable(BEANSTALK_SIGN.get().getLootTable())
                    .ignitedByLava());
    public static final DeferredBlock<Block> BEANSTALK_HANGING_SIGN = registerBlockWithoutBlockItem("beanstalk_hanging_sign",
            (p) -> new CeilingHangingSignBlock(ModWoodTypes.BEANSTALK, p), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    public static final DeferredBlock<Block> BEANSTALK_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("beanstalk_wall_hanging_sign",
            (p) -> new WallHangingSignBlock(ModWoodTypes.BEANSTALK, p), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F)
//                    .overrideLootTable(BEANSTALK_HANGING_SIGN.get().getLootTable())
                    .ignitedByLava());

    public static final DeferredBlock<Block> BEANSTALK_CABINET = registerBlock("beanstalk_cabinet",
			CabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL), false, 0);

    public static final DeferredBlock<Block> AVOCADO_PIT = registerBlock("avocado_pit",
            (p) -> new AvocadoPitBlock(AvocadoPitGrower.AVOCADO_PIT_GROWER, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), false, 0);
    public static final DeferredBlock<Block> AVOCADO_SAPLING = registerBlock("avocado_sapling",
            (p) -> new SaplingBlock(AvocadoTreeGrower.AVOCADO_TREE_GROWER, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true, 100);
    public static final DeferredBlock<FlowerPotBlock> POTTED_AVOCADO_SAPLING = registerBlockWithoutBlockItem("potted_avocado_sapling",
            (p) -> new FlowerPotBlock(AVOCADO_SAPLING.get(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING));

    public static final DeferredBlock<Block> AVOCADO_LOG = registerBlock("avocado_log",
            (p) -> new RotatedPillarBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
                    if (itemAbility == ItemAbility.AXE_STRIP) {
                        return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                    }
                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            },  BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG),true, 300);

    public static final DeferredBlock<Block> AVOCADO_WOOD = registerBlock("avocado_wood",
            (p) -> new RotatedPillarBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
                    if (itemAbility == ItemAbility.AXE_STRIP) {
                        return Blocks.STRIPPED_JUNGLE_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                    }
                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD), true, 300);

    public static final DeferredBlock<Block> AVOCADO_LEAVES = registerBlock("avocado_leaves",
            (p) -> new LeavesBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), false, 0);

    public static final DeferredBlock<Block> FRUITING_AVOCADO_LEAVES = registerBlock("fruiting_avocado_leaves",
            (p) -> new FruitingLeaves(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES), false, 0);

    public static final DeferredBlock<Block> CUCUMBERS = registerBlockWithoutBlockItem("cucumbers",
			CucumbersBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion());

    public static final DeferredBlock<Block> EGGPLANTS = registerBlockWithoutBlockItem("eggplants",
			EggplantsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion());

    public static final DeferredBlock<Block> CORN = registerBlockWithoutBlockItem("corn",
			CornBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion());

    public static final DeferredBlock<Block> BEANS = registerBlockWithoutBlockItem("beans",
			BeansBlock::new, BlockBehaviour.Properties.of().noCollision().randomTicks().instabreak().sound(SoundType.CROP).noOcclusion());

    public static final DeferredBlock<Block> ROPE_BEANS = registerBlockWithoutBlockItem("rope_beans",
            (p) -> ModList.get().isLoaded("supplementaries")
                    ? SupplementariesCompat.makeRopeBeans(p)
                    : new BeansBlock(p), BlockBehaviour.Properties.of().noCollision().randomTicks().instabreak().sound(SoundType.CROP).noOcclusion());

    public static final DeferredBlock<Block> STICK_BEANS = registerBlockWithoutBlockItem("stick_beans",
            (p) -> ModList.get().isLoaded("supplementaries")
                    ? SupplementariesCompat.makeStickBeans(p)
                    : new BeansBlock(p), BlockBehaviour.Properties.of().noCollision().randomTicks().instabreak().sound(SoundType.CROP).noOcclusion());

    public static final DeferredBlock<Block> BUDDING_BEANS = registerBlockWithoutBlockItem("budding_beans",
			BuddingBeansBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.POPPED).noOcclusion());

    public static final DeferredBlock<Block> AVOCADO_CRATE = registerBlock("avocado_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> CUCUMBER_CRATE = registerBlock("cucumber_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> PICKLE_CRATE = registerBlock("pickle_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> CORN_COB_CRATE = registerBlock("corn_cob_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> EGGPLANT_CRATE = registerBlock("eggplant_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> WHITE_EGGPLANT_CRATE = registerBlock("white_eggplant_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> BEAN_CRATE = registerBlock("bean_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), false, 0);

    public static final DeferredBlock<Block> BEAN_BAG = registerBlock("bean_bag",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.white()), false, 0);

    public static final DeferredBlock<Block> EXOTIC_ROLL_MEDLEY = registerBlock("exotic_roll_medley",
			ExoticRollMedleyBlock::new, BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).mapColor(MapColor.WOOD).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED).noOcclusion(), ModBlocks::feastItem);

    public static final DeferredBlock<Block> EGGPLANT_PARMESAN_BLOCK = registerBlock("eggplant_parmesan_block",
            (p) -> new EggplantFeastBlock(p, ModItems.EGGPLANT_PARMESAN, true), BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).mapColor(MapColor.WOOD).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED).noOcclusion(), ModBlocks::feastItem);

    public static final DeferredBlock<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_WART_BLOCK), false, 0);

    public static final DeferredBlock<Block> CHEESE_WHEEL = registerBlock("cheese_wheel",
			SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_WART_BLOCK), false, 0);

    public static final DeferredBlock<Block> BUTTERSCOTCH_CINNAMONN_PIE = registerBlock("butterscotch_cinnamon_pie",
            (p) -> new PieBlock(p, ModItems.BUTTERSCOTCH_CINNAMON_PIE_SLICE), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), false, 0);

    public static final DeferredBlock<Block> BRICK_COUNTER = registerBlock("brick_counter",
			CounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS), false, 0);
    public static final @Nullable DeferredBlock<Block> ASH_BRICK_COUNTER = ModList.get().isLoaded("supplementaries")
            ? registerBlock("ash_brick_counter", CounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS), false, 0)
            : null;
    public static final @Nullable DeferredBlock<Block> SILT_BRICK_COUNTER = ModList.get().isLoaded("twigs")
            ? registerBlock("silt_brick_counter", CounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS), false, 0)
            : null;

    public static final DeferredBlock<Block> LEMON_CRATE = registerBlock("lemon_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(CARROT_CRATE.get()), false, 0);

    public static final DeferredBlock<Block> LEMON_SAPLING = registerBlock("lemon_sapling",
            (p) -> new SaplingBlock(LemonTreeGrower.LEMON_TREE_GROWER, p), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), true, 100);

    public static final DeferredBlock<Block> LEMON_LOG = registerBlock("lemon_log",
            (p) -> new RotatedPillarBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
                    if (itemAbility == ItemAbility.AXE_STRIP) {
                        return Blocks.STRIPPED_OAK_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                    }
                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG),true, 300);

    public static final DeferredBlock<Block> LEMON_WOOD = registerBlock("lemon_wood",
            (p) -> new RotatedPillarBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
                    if (itemAbility == ItemAbility.AXE_STRIP) {
                        return Blocks.STRIPPED_OAK_WOOD.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                    }
                    return super.getToolModifiedState(state, context, itemAbility, simulate);
                }
            },  BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD),true, 300);

    public static final DeferredBlock<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            (p) -> new LeavesBlock(p) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), false, 0);

    public static final DeferredBlock<Block> FRUITING_LEMON_LEAVES = registerBlock("fruiting_lemon_leaves",
            (p) -> new FruitingLeaves(p, ModItems.LEMON) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), false, 0);

    public static final DeferredBlock<Block> RUSTIC_LOAF = registerBlock("rustic_loaf",
            (p) -> new RusticLoafBlock(p, ModItems.RUSTIC_LOAF_SLICE), BlockBehaviour.Properties.ofFullCopy(APPLE_PIE.get()).noOcclusion()
                    , false, 0);

    public static final DeferredBlock<Block> SALT_BLOCK = registerBlock("salt_block",
			SaltBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).randomTicks(), false, 0);

    public static final DeferredBlock<Block> SALT_SPIKE = registerBlock("salt_spike",
			SaltSpikeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE)
                    .offsetType(BlockBehaviour.OffsetType.NONE)
                    .noOcclusion()
                    .sound(SoundType.POINTED_DRIPSTONE)
                    .strength(1.5F, 3.0F)
                    .pushReaction(PushReaction.POPPED), false, 0);

    public static final DeferredBlock<Block> OVEN = registerBlock("oven",
            OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS), false, 0);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties, boolean isFuel, int fuelAmount) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block, properties);
        registerBlockItem(name, toReturn, isFuel, fuelAmount);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties, Function<T, Item> item) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block, properties);
        ModItems.ITEMS.register(name, () -> item.apply(toReturn.get()));
        return toReturn;
    }

    private static Item feastItem(Block block) {
        return new BlockItem(block, blockItemProperties(block).stacksTo(1));
    }

    private static Item.Properties blockItemProperties(Block name) {
        return new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, name.properties().blockId().identifier()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, T> block, BlockBehaviour.Properties properties) {
        return BLOCKS.register(name, block, properties);
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block, boolean isFuel, int fuelAmount) {
        if (!isFuel) {
            return ModItems.ITEMS.register(name, (p) -> new BlockItem(block.get(),p), new Item.Properties().useBlockDescriptionPrefix());
        } else {
            return ModItems.ITEMS.register(name, (p) -> new BlockItem(block.get(),p) {
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return fuelAmount;
                }
            }, new Item.Properties().useBlockDescriptionPrefix());
        }
    }

    public static void register() {
        BLOCKS.register();
    }
}