package com.baisylia.culturaldelights;

import com.baisylia.culturaldelights.advancement.ModAdvancements;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.block.ModWoodTypes;
import com.baisylia.culturaldelights.block.entity.ModBlockEntities;
import com.baisylia.culturaldelights.block.entity.custom.VatBlockEntity;
import com.baisylia.culturaldelights.effect.ModEffects;
import com.baisylia.culturaldelights.integration.moonlight.MoonlightCompat;
import com.baisylia.culturaldelights.item.ModBoatTypes;
import com.baisylia.culturaldelights.item.ModDataComponents;
import com.baisylia.culturaldelights.item.ModItems;
import com.baisylia.culturaldelights.recipes.ModRecipes;
import com.baisylia.culturaldelights.refabricated.CulturalDelightsRefabricated;
import com.baisylia.culturaldelights.refabricated.event.AddPackFindersEvent;
import com.baisylia.culturaldelights.refabricated.event.BlockEntityTypeAddBlocksEvent;
import com.baisylia.culturaldelights.refabricated.event.BuildCreativeModeTabContentsEvent;
import com.baisylia.culturaldelights.refabricated.loader.IEventBus;
import com.baisylia.culturaldelights.screens.ModMenuTypes;
import com.baisylia.culturaldelights.screens.OvenScreen;
import com.baisylia.culturaldelights.screens.VatScreen;
import com.baisylia.culturaldelights.sound.ModSounds;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import com.baisylia.culturaldelights.refabricated.loader.ModList;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

public class CulturalDelights implements ModInitializer {
    public static final String MOD_ID = "culturaldelights";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        var eventBus = new IEventBus();
        ModDataComponents.register(eventBus);
        ModSounds.register(eventBus);
        ModEffects.register(eventBus);
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModAdvancements.register(eventBus);

        if (ModList.get().isLoaded("moonlight")) {
            MoonlightCompat.registerWoodTypes();
        }

        eventBus.addListener(this::setup);
        eventBus.addListener(this::registerCapabilities);
        eventBus.addListener(() -> addBlockEntityValidBlocks(new BlockEntityTypeAddBlocksEvent()));
        eventBus.addListener(() -> ItemGroupEvents.MODIFY_ENTRIES_ALL.register((creativeModeTab, fabricItemGroupEntries) -> buildCreativeTab(new BuildCreativeModeTabContentsEvent(creativeModeTab, fabricItemGroupEntries))));
        eventBus.addListener(() -> addPackFinders(new AddPackFindersEvent()));
        CulturalDelightsRefabricated.init();
    }

    public static void registerPottables() {
//        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
//        pot.addPlant(ModBlocks.AVOCADO_SAPLING.getId(), ModBlocks.POTTED_AVOCADO_SAPLING);
//        pot.addPlant(ModBlocks.AGAVE.getId(), ModBlocks.POTTED_AGAVE);
//        pot.addPlant(ModBlocks.MINT.getId(), ModBlocks.POTTED_MINT);
    }

    public static void registerFlammables() {
        FireBlock fire = (FireBlock) Blocks.FIRE;
        fire.setFlammable(ModBlocks.BEANSTALK.get(), 5, 5);
        fire.setFlammable(ModBlocks.STRIPPED_BEANSTALK.get(), 5, 5);
        fire.setFlammable(ModBlocks.BEANSTALK_PLANKS.get(), 5, 20);
        fire.setFlammable(ModBlocks.BEANSTALK_STAIRS.get(), 5, 20);
        fire.setFlammable(ModBlocks.BEANSTALK_SLAB.get(), 5, 20);
        fire.setFlammable(ModBlocks.BEANSTALK_FENCE.get(), 5, 20);
        fire.setFlammable(ModBlocks.BEANSTALK_FENCE_GATE.get(), 5, 20);
    }

    public static void registerDispenserBehaviors() {
        Boat.Type beanstalk = ModBoatTypes.BEANSTALK.getValue();
        DispenserBlock.registerBehavior(ModItems.BEANSTALK_RAFT.get(), new BoatDispenseItemBehavior(beanstalk));
        DispenserBlock.registerBehavior(ModItems.BEANSTALK_CHEST_RAFT.get(), new BoatDispenseItemBehavior(beanstalk, true));
    }

    private void setup() {
            registerPottables();
            registerFlammables();
            registerDispenserBehaviors();
    }

    private void addBlockEntityValidBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.SIGN, ModBlocks.BEANSTALK_SIGN.get(), ModBlocks.BEANSTALK_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, ModBlocks.BEANSTALK_HANGING_SIGN.get(), ModBlocks.BEANSTALK_WALL_HANGING_SIGN.get());
        event.modify(ModBlockEntityTypes.CABINET.get(), ModBlocks.BEANSTALK_CABINET.get());
    }

    private void registerCapabilities() {

    }

    private void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().equals(ResourceLocation.fromNamespaceAndPath("farmersdelight", "farmersdelight"))) {
            ModItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }

    public void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            event.addPackFinders(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resourcepacks/pastry_sheet"),
                    PackType.CLIENT_RESOURCES, Component.literal("Pastry Sheet"), PackSource.BUILT_IN, false, Pack.Position.TOP);
            event.addPackFinders(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resourcepacks/apple_juice"),
                    PackType.CLIENT_RESOURCES, Component.literal("Apple Juice"), PackSource.BUILT_IN, false, Pack.Position.TOP);
            event.addPackFinders(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resourcepacks/retextured_stove"),
                    PackType.CLIENT_RESOURCES, Component.literal("Retextured Stove"), PackSource.BUILT_IN, false, Pack.Position.TOP);
            if (ModList.get().isLoaded("supplementaries")) {
                event.addPackFinders(ResourceLocation.fromNamespaceAndPath(MOD_ID, "resourcepacks/supplementaries"),
                        PackType.CLIENT_RESOURCES, Component.literal("Supplementaries Beans"), PackSource.BUILT_IN, true, Pack.Position.TOP);
            }
        }
    }

    public static class ClientModEvents {

        public static void registerScreens() {
            MenuScreens.register(ModMenuTypes.VAT_MENU.get(), VatScreen::new);
            MenuScreens.register(ModMenuTypes.OVEN_MENU.get(), OvenScreen::new);
        }


        public static void afterBlockRegistration() {
            if (ModList.get().isLoaded("moonlight")) {
                MoonlightCompat.registerLogTextures();
            }
        }


        public static void onClientSetup() {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_SAPLING.get(), RenderType.cutoutMipped());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SALT_SPIKE.get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEANSTALK_LEAF.get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGIC_BEANS.get(), RenderType.cutout());
//            event.enqueueWork(() -> Sheets.addWoodType(ModWoodTypes.BEANSTALK));
        }

        public static boolean applyForgeHandTransform(PoseStack matrixStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTicks, float equipProcess, float swingProcess) {
            if (itemInHand.has(ModDataComponents.COOK_TIME.get())) {
                int i = arm == HumanoidArm.RIGHT ? 1 : -1;
                matrixStack.translate((float) i * 0.56F, -0.52F + equipProcess * -0.6F, -0.72F);
                matrixStack.translate(i * -0.5, 0.2, -0.05);
                matrixStack.mulPose(Axis.YP.rotationDegrees(2));
                matrixStack.mulPose(Axis.XP.rotationDegrees(185));
                matrixStack.mulPose(Axis.ZP.rotationDegrees(165));
                matrixStack.translate(-0.25, 0, 0);
                return true;
            }
            return false;
        }
    }
}