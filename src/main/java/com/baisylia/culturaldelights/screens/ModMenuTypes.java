package com.baisylia.culturaldelights.screens;

import com.baisylia.culturaldelights.CulturalDelights;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import com.baisylia.culturaldelights.refabricated.loader.IEventBus;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import com.baisylia.culturaldelights.refabricated.registry.DeferredHolder;
import com.baisylia.culturaldelights.refabricated.registry.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, CulturalDelights.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<VatMenu>> VAT_MENU =
            registerMenuType(new ExtendedScreenHandlerType<>(VatMenu::new, BlockPos.STREAM_CODEC), "vat_menu");

    public static final DeferredHolder<MenuType<?>, MenuType<OvenMenu>> OVEN_MENU =
            registerMenuType(new ExtendedScreenHandlerType<>(OvenMenu::new, BlockPos.STREAM_CODEC), "oven_menu");

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(ExtendedScreenHandlerType<T, BlockPos> factory, String name) {
        return MENUS.register(name, () -> factory);
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}