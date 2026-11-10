package com.baisylia.culturaldelights.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

import static com.baisylia.culturaldelights.effect.ModEffects.CHEESY;
import static com.baisylia.culturaldelights.effect.ModEffects.INTOXICATION;

public class ModConsumables {

    //INGREDIENTS
    public static final Consumable BEANS = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable REFRIED_BEANS = Consumables.defaultFood().build();
    public static final Consumable TOFU = Consumables.defaultFood().build();
    public static final Consumable AVOCADO = Consumables.defaultFood().build();
    public static final Consumable CUCUMBER = Consumables.defaultFood().build();
    public static final Consumable PICKLE = Consumables.defaultFood().build();
    public static final Consumable EGGPLANT = Consumables.defaultFood().build();
    public static final Consumable SMOKED_EGGPLANT = Consumables.defaultFood().build();
    public static final Consumable SMOKED_TOMATO = Consumables.defaultFood().build();
    public static final Consumable SMOKED_WHITE_EGGPLANT = Consumables.defaultFood().build();
    public static final Consumable WHITE_EGGPLANT = Consumables.defaultFood().build();
    public static final Consumable CORN_COB = Consumables.defaultFood().build();
    public static final Consumable BEAN_POD = Consumables.defaultFood().build();
    public static final Consumable GINGER = Consumables.defaultFood().build();
    public static final Consumable SQUID = Consumables.defaultFood().build();
    public static final Consumable COOKED_SQUID = Consumables.defaultFood().build();
    public static final Consumable GLOW_SQUID = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 1), 1.0F)).consumeSeconds(0.8F).build();
    public static final Consumable RAW_CALAMARI = Consumables.defaultFood().build();
    public static final Consumable COOKED_CALAMARI = Consumables.defaultFood().build();

    public static final Consumable CUT_AVOCADO = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CUT_CUCUMBER = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CUT_PICKLE = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CUT_EGGPLANT = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable SMOKED_CUT_EGGPLANT = Consumables.defaultFood().consumeSeconds(0.8F).build();

    public static final Consumable CORN_DOG = Consumables.defaultFood().build();
    public static final Consumable HOT_DOG = Consumables.defaultFood().build();
    public static final Consumable CHEESY_CHIP_WRAP = Consumables.defaultFood().build();
    public static final Consumable CHEESE_CRACKER = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CHIPS_WITH_CHEESE = Consumables.defaultFood().build();
    public static final Consumable CINNAMON_MINT_CURRY = Consumables.defaultFood().build();
    public static final Consumable CINNAMON_CRACKER = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable MARSHMALLOW = Consumables.defaultFood().build();
    public static final Consumable MARSHMALLOW_ON_A_STICK = Consumables.defaultFood().build();
    public static final Consumable CARAMELIZED_MARSHMALLOW_ON_A_STICK = Consumables.defaultFood().build();
    public static final Consumable CHARRED_MARSHMALLOW_ON_A_STICK = Consumables.defaultFood().build();

    public static final Consumable BUTTER = Consumables.defaultFood().build();
    public static final Consumable BUTTERED_TOAST = Consumables.defaultFood().build();
    public static final Consumable RAW_SAUSAGE = Consumables.defaultFood().build();
    public static final Consumable COOKED_SAUSAGE = Consumables.defaultFood().build();
    public static final Consumable SNAG = Consumables.defaultFood().build();
    public static final Consumable SAUSAGES_AND_MASH = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();
    public static final Consumable POPCORN_BUCKET = Consumables.defaultFood().build();

    public static final Consumable BEER = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable WINE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable GLOW_WINE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable GINGER_BEER = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 0), 1.0F)).build();
    public static final Consumable MEAD = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable APPLE_CIDER = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable MOJITO = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 1), 1.0F)).build();
    public static final Consumable MARGARITA = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 1), 1.0F)).build();
    public static final Consumable BLOODY_MARY = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 1), 1.0F)).build();
    public static final Consumable LEMON_LIQUEUR = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable BUTTERBEER = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(new MobEffectInstance(INTOXICATION, 1200, 0), new MobEffectInstance(ModEffects.COMFORT, FoodValues.LONG_DURATION, 0)), 1.0F)).build();
    public static final Consumable COLA = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 1), 1.0F)).build();
    public static final Consumable TEQUILA = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable GIN = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable BRANDY = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable VODKA = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable WHISKEY = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();
    public static final Consumable RUM = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INTOXICATION, 1200, 0), 1.0F)).build();

    public static final Consumable ACID = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1200, 0), 1.0F)).build();
    public static final Consumable VINEGAR = Consumables.defaultDrink().build();
    public static final Consumable PICKLED_EGG = Consumables.defaultFood().build();
    public static final Consumable CHEESE_WHEEL = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(CHEESY, 200, 1), 1.0F)).consumeSeconds(0.8F).build();
    public static final Consumable CHEESE_WEDGE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(CHEESY, 200, 1), 1.0F)).consumeSeconds(0.8F).build();

    //SUSHI
    public static final Consumable MIDORI_ROLL = Consumables.defaultFood().build();
    public static final Consumable MIDORI_ROLL_SLICE = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable EGG_ROLL = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CHICKEN_ROLL = Consumables.defaultFood().build();
    public static final Consumable CHICKEN_ROLL_SLICE = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable PUFFERFISH_ROLL = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 0), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 1), 1.0F)).consumeSeconds(0.8F).build();
    public static final Consumable TROPICAL_ROLL = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable RICE_BALL = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable CALAMARI_ROLL = Consumables.defaultFood().consumeSeconds(0.8F).build();

    //MEALS
    public static final Consumable CORN_DOUGH = Consumables.defaultFood().build();
    public static final Consumable TORTILLA = Consumables.defaultFood().build();
    public static final Consumable POPCORN = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable TORTILLA_CHIPS = Consumables.defaultFood().consumeSeconds(0.8F).build();
    public static final Consumable ELOTE = Consumables.defaultFood().build();
    public static final Consumable EMPANADA = Consumables.defaultFood().build();
    public static final Consumable BEEF_BURRITO = Consumables.defaultFood().build();
    public static final Consumable MUTTON_SANDWICH = Consumables.defaultFood().build();
    public static final Consumable AVOCADO_TOAST = Consumables.defaultFood().build();
    public static final Consumable CREAMED_CORN = Consumables.defaultFood().build();
    public static final Consumable CHICKEN_TACO = Consumables.defaultFood().build();
    public static final Consumable PORK_WRAP = Consumables.defaultFood().build();
    public static final Consumable FISH_TACO = Consumables.defaultFood().build();
    public static final Consumable HEARTY_SALAD = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();
    public static final Consumable EGGPLANT_PARMESAN = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();
    public static final Consumable EGGPLANT_BURGER = Consumables.defaultFood().build();
    public static final Consumable SPICY_CURRY = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();
    public static final Consumable POACHED_EGGPLANTS = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();

    public static final Consumable LEMON = Consumables.defaultFood().build();
    public static final Consumable LEMONADE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 0), 1.0F)).build();
    public static final Consumable LEMON_MUFFIN = Consumables.defaultFood().build();
    public static final Consumable CHOCOLATE_MUFFIN = Consumables.defaultFood().build();
    public static final Consumable WAFER = Consumables.defaultFood().build();
    public static final Consumable ICE_CREAM = Consumables.defaultFood().build();
    public static final Consumable FRIED_POTATO = Consumables.defaultFood().build();
    public static final Consumable RUSTIC_LOAF_SLICE = Consumables.defaultFood().build();
    public static final Consumable FISH_AND_CHIPS = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0), 1.0F)).build();
    public static final Consumable COOKING_OIL = Consumables.defaultDrink().sound(SoundEvents.HONEY_DRINK).build();
}