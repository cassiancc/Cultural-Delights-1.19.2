package com.baisylia.culturaldelights.item;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.custom.BucketFoodItem;
import com.baisylia.culturaldelights.item.custom.MarshmallowOnAStickItem;
import com.baisylia.culturaldelights.refabricated.loader.ModList;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import com.baisylia.culturaldelights.refabricated.loader.IEventBus;
import cc.cassian.asphodel.util.deferred_registry.DeferredItem;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import com.baisylia.culturaldelights.item.custom.OilItem;
import net.minecraft.world.food.FoodProperties;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(CulturalDelights.MOD_ID);

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties drinkItem() {
        return (new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    //Items
    public static final DeferredItem<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            (p) -> new BlockItem(ModBlocks.CUCUMBERS.get(), p),
                    new Item.Properties());

    public static final DeferredItem<Item> CORN_KERNELS = ITEMS.register("corn_kernels",
            (p) -> new BlockItem(ModBlocks.CORN.get(), p),
                    new Item.Properties());

    public static final DeferredItem<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds",
            (p) -> new BlockItem(ModBlocks.EGGPLANTS.get(), p),
                    new Item.Properties());

    public static final DeferredItem<Item> BEANS = ITEMS.register("beans",
            (p) -> new BlockItem(ModBlocks.BUDDING_BEANS.get(), p),
                    new Item.Properties().food(ModFoods.BEANS, ModConsumables.BEANS));


    //Ingredients
    public static final DeferredItem<Item> BEAN_POD = ITEMS.register("bean_pod",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.BEAN_POD));
    public static final DeferredItem<Item> TOFU = ITEMS.register("tofu",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.TOFU));
    public static final DeferredItem<Item> REFRIED_BEANS = ITEMS.register("refried_beans",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.REFRIED_BEANS));

    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.AVOCADO, ModConsumables.AVOCADO));

    public static final DeferredItem<Item> CUT_AVOCADO = ITEMS.register("cut_avocado",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CUT_AVOCADO, ModConsumables.CUT_AVOCADO));

    public static final DeferredItem<Item> CUCUMBER = ITEMS.register("cucumber",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CUCUMBER, ModConsumables.CUCUMBER));

    public static final DeferredItem<Item> PICKLE = ITEMS.register("pickle",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.PICKLE,  ModConsumables.PICKLE));

    public static final DeferredItem<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CUT_CUCUMBER,  ModConsumables.CUT_CUCUMBER));

    public static final DeferredItem<Item> CUT_PICKLE = ITEMS.register("cut_pickle",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CUT_PICKLE,   ModConsumables.CUT_PICKLE));

    public static final DeferredItem<Item> EGGPLANT = ITEMS.register("eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.EGGPLANT, ModConsumables.EGGPLANT));

    public static final DeferredItem<Item> CUT_EGGPLANT = ITEMS.register("cut_eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CUT_EGGPLANT, ModConsumables.CUT_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_EGGPLANT = ITEMS.register("smoked_eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SMOKED_EGGPLANT, ModConsumables.SMOKED_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_TOMATO = ITEMS.register("smoked_tomato",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SMOKED_TOMATO, ModConsumables.SMOKED_TOMATO));

    public static final DeferredItem<Item> SMOKED_CUT_EGGPLANT = ITEMS.register("smoked_cut_eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SMOKED_CUT_EGGPLANT, ModConsumables.SMOKED_CUT_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_WHITE_EGGPLANT = ITEMS.register("smoked_white_eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SMOKED_WHITE_EGGPLANT, ModConsumables.SMOKED_WHITE_EGGPLANT));
    public static final DeferredItem<Item> WHITE_EGGPLANT = ITEMS.register("white_eggplant",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.WHITE_EGGPLANT));
    public static final DeferredItem<Item> CORN_COB = ITEMS.register("corn_cob",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CORN_COB));

    public static final DeferredItem<Item> SQUID = ITEMS.register("squid",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SQUID));

    public static final DeferredItem<Item> COOKED_SQUID = ITEMS.register("cooked_squid",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.COOKED_SQUID));

    public static final DeferredItem<Item> GLOW_SQUID = ITEMS.register("glow_squid",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.GLOW_SQUID));

    public static final DeferredItem<Item> RAW_CALAMARI = ITEMS.register("raw_calamari",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.RAW_CALAMARI));

    public static final DeferredItem<Item> COOKED_CALAMARI = ITEMS.register("cooked_calamari",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.COOKED_CALAMARI));


    public static final DeferredItem<Item> BUTTER = ITEMS.register("butter",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.BUTTER));

    public static final DeferredItem<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.BUTTERED_TOAST));

    public static final DeferredItem<Item> RAW_SAUSAGE = ITEMS.register("raw_sausage",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.RAW_SAUSAGE));

    public static final DeferredItem<Item> COOKED_SAUSAGE = ITEMS.register("cooked_sausage",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.COOKED_SAUSAGE));

    public static final DeferredItem<Item> SNAG = ITEMS.register("snag",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.SNAG));

    public static final DeferredItem<Item> SAUSAGES_AND_MASH = ITEMS.register("sausages_and_mash",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.SAUSAGES_AND_MASH));

    public static final DeferredItem<Item> POPCORN_BUCKET = ITEMS.register("popcorn_bucket",
            () -> new BucketFoodItem(new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(16).food(ModFoods.POPCORN_BUCKET)));


    public static final DeferredItem<Item> BEER = ITEMS.register("beer",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.BEER).stacksTo(16));
    public static final DeferredItem<Item> WINE = ITEMS.register("wine",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.WINE).stacksTo(16));
    public static final DeferredItem<Item> GLOW_WINE = ITEMS.register("glow_wine",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.GLOW_WINE).stacksTo(16));
    public static final DeferredItem<Item> GINGER_BEER = ITEMS.register("ginger_beer",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.GINGER_BEER).stacksTo(16));
    public static final DeferredItem<Item> MEAD = ITEMS.register("mead",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.MEAD).stacksTo(16));
    public static final DeferredItem<Item> APPLE_CIDER = ITEMS.register("apple_cider",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.APPLE_CIDER).stacksTo(16));
    public static final DeferredItem<Item> MOJITO = ITEMS.register("mojito",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.MOJITO).stacksTo(16));
    public static final DeferredItem<Item> MARGARITA = ITEMS.register("margarita",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.MARGARITA).stacksTo(16));
    public static final DeferredItem<Item> BLOODY_MARY = ITEMS.register("bloody_mary",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.BLOODY_MARY).stacksTo(16));
    public static final DeferredItem<Item> LEMON_LIQUEUR = ITEMS.register("lemon_liqueur",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.LEMON_LIQUEUR).stacksTo(16));
    public static final DeferredItem<Item> BUTTERBEER = ITEMS.register("butterbeer",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.BUTTERBEER).stacksTo(16));
    public static final DeferredItem<Item> COLA = ITEMS.register("cola",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.COLA).stacksTo(16));
    public static final DeferredItem<Item> TEQUILA = ITEMS.register("tequila",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.TEQUILA).stacksTo(16));
    public static final DeferredItem<Item> GIN = ITEMS.register("gin",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.GIN).stacksTo(16));
    public static final DeferredItem<Item> BRANDY = ITEMS.register("brandy",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.BRANDY).stacksTo(16));
    public static final DeferredItem<Item> VODKA = ITEMS.register("vodka",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.VODKA).stacksTo(16));
    public static final DeferredItem<Item> WHISKEY = ITEMS.register("whiskey",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.WHISKEY).stacksTo(16));
    public static final DeferredItem<Item> RUM = ITEMS.register("rum",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.RUM).stacksTo(16));

    public static final DeferredItem<Item> ACID = ITEMS.register("acid",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.ACID).stacksTo(16));
    public static final DeferredItem<Item> VINEGAR = ITEMS.register("vinegar",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.VINEGAR).stacksTo(16));
    public static final DeferredItem<Item> PICKLED_EGG = ITEMS.register("pickled_egg",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.PICKLED_EGG));
    public static final DeferredItem<Item> CHEESE_WEDGE = ITEMS.register("cheese_wedge",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHEESE_WEDGE));

    public static final DeferredItem<Item> CORN_DOG = ITEMS.register("corn_dog",
            (p) -> new Item(p), new Item.Properties().craftRemainder(Items.STICK).food(ModFoods.CORN_DOG));
    public static final DeferredItem<Item> HOT_DOG = ITEMS.register("hot_dog",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.HOT_DOG));
    public static final DeferredItem<Item> CHEESY_CHIP_WRAP = ITEMS.register("cheesy_chip_wrap",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHEESY_CHIP_WRAP));
    public static final DeferredItem<Item> CHEESE_CRACKER = ITEMS.register("cheese_cracker",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHEESE_CRACKER));
    public static final DeferredItem<Item> CHIPS_WITH_CHEESE = ITEMS.register("chips_with_cheese",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHIPS_WITH_CHEESE));
    public static final DeferredItem<Item> CINNAMON = ITEMS.register("cinnamon",
            (p) -> new Item(p), new Item.Properties());
    public static final DeferredItem<Item> CINNAMON_MINT_CURRY = ITEMS.register("cinnamon_mint_curry",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CINNAMON_MINT_CURRY));
    public static final DeferredItem<Item> CINNAMON_CRACKER = ITEMS.register("cinnamon_cracker",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CINNAMON_CRACKER));
    public static final DeferredItem<Item> BUTTERSCOTCH_CINNAMON_PIE_SLICE = ITEMS.register("butterscotch_cinnamon_pie_slice",
            (p) -> new Item(p), new Item.Properties().food(FoodValues.PIE_SLICE));


    //Meals
    public static final DeferredItem<Item> POPCORN = ITEMS.register("popcorn",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.POPCORN));

    public static final DeferredItem<Item> CORN_DOUGH = ITEMS.register("corn_dough",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CORN_DOUGH));

    public static final DeferredItem<Item> TORTILLA = ITEMS.register("tortilla",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.TORTILLA));

    public static final DeferredItem<Item> TORTILLA_CHIPS = ITEMS.register("tortilla_chips",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.TORTILLA_CHIPS));

    public static final DeferredItem<Item> ELOTE = ITEMS.register("elote",
            (p) -> new Item(p), new Item.Properties().craftRemainder(Items.STICK).food(ModFoods.ELOTE));

    public static final DeferredItem<Item> EMPANADA = ITEMS.register("empanada",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.EMPANADA));

    public static final DeferredItem<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.HEARTY_SALAD));

    public static final DeferredItem<Item> BEEF_BURRITO = ITEMS.register("beef_burrito",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.BEEF_BURRITO));

    public static final DeferredItem<Item> MUTTON_SANDWICH = ITEMS.register("mutton_sandwich",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.MUTTON_SANDWICH));

    public static final DeferredItem<Item> EGGPLANT_PARMESAN = ITEMS.register("eggplant_parmesan",
            (p) -> new ConsumableItem(p), new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16).food(ModFoods.EGGPLANT_PARMESAN));

    public static final DeferredItem<Item> POACHED_EGGPLANTS = ITEMS.register("poached_eggplants",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.POACHED_EGGPLANTS));

    public static final DeferredItem<Item> EGGPLANT_BURGER = ITEMS.register("eggplant_burger",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.EGGPLANT_BURGER));

    public static final DeferredItem<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.AVOCADO_TOAST));

    public static final DeferredItem<Item> CREAMED_CORN = ITEMS.register("creamed_corn",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.CREAMED_CORN));

    public static final DeferredItem<Item> CHICKEN_TACO = ITEMS.register("chicken_taco",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHICKEN_TACO));

    public static final DeferredItem<Item> SPICY_CURRY = ITEMS.register("spicy_curry",
            (p) -> new ConsumableItem(p), new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.SPICY_CURRY));

    public static final DeferredItem<Item> PORK_WRAP = ITEMS.register("pork_wrap",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.PORK_WRAP));

    public static final DeferredItem<Item> FISH_TACO = ITEMS.register("fish_taco",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.FISH_TACO));

    public static final DeferredItem<Item> MIDORI_ROLL = ITEMS.register("midori_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.MIDORI_ROLL));

    public static final DeferredItem<Item> MIDORI_ROLL_SLICE = ITEMS.register("midori_roll_slice",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.MIDORI_ROLL_SLICE));

    public static final DeferredItem<Item> EGG_ROLL = ITEMS.register("egg_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.EGG_ROLL));

    public static final DeferredItem<Item> CHICKEN_ROLL = ITEMS.register("chicken_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHICKEN_ROLL));

    public static final DeferredItem<Item> CHICKEN_ROLL_SLICE = ITEMS.register("chicken_roll_slice",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHICKEN_ROLL_SLICE));

    public static final DeferredItem<Item> PUFFERFISH_ROLL = ITEMS.register("pufferfish_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.PUFFERFISH_ROLL));

    public static final DeferredItem<Item> TROPICAL_ROLL = ITEMS.register("tropical_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.TROPICAL_ROLL));

    public static final DeferredItem<Item> RICE_BALL = ITEMS.register("rice_ball",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.RICE_BALL));

    public static final DeferredItem<Item> CALAMARI_ROLL = ITEMS.register("calamari_roll",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CALAMARI_ROLL));

    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.MARSHMALLOW));

    public static final DeferredItem<Item> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick",
            (p) -> new MarshmallowOnAStickItem(p), new Item.Properties().food(ModFoods.MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> CARAMELIZED_MARSHMALLOW_ON_A_STICK = ITEMS.register("caramelized_marshmallow_on_a_stick",
            (p) -> new MarshmallowOnAStickItem(p), new Item.Properties().food(ModFoods.CARAMELIZED_MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> CHARRED_MARSHMALLOW_ON_A_STICK = ITEMS.register("charred_marshmallow_on_a_stick",
            (p) -> new MarshmallowOnAStickItem(p), new Item.Properties().food(ModFoods.CHARRED_MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.LEMON));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            (p) -> new Item(p), new Item.Properties());

    public static final DeferredItem<Item> COOKING_OIL = ITEMS.register("cooking_oil",
            (p) -> new OilItem(p), drinkItem().food(ModFoods.COOKING_OIL));

    public static final DeferredItem<Item> CHOCOLATE_MUFFIN = ITEMS.register("chocolate_muffin",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.CHOCOLATE_MUFFIN));

    public static final DeferredItem<Item> LEMON_MUFFIN = ITEMS.register("lemon_muffin",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.LEMON_MUFFIN));

    public static final DeferredItem<Item> WAFER = ITEMS.register("wafer",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.WAFER));

    public static final DeferredItem<Item> ICE_CREAM = ITEMS.register("ice_cream",
            (p) -> new Item(p), new Item.Properties().stacksTo(16).food(ModFoods.ICE_CREAM));

    public static final DeferredItem<Item> FRIED_POTATO = ITEMS.register("fried_potato",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.FRIED_POTATO));

    public static final DeferredItem<Item> LEMONADE = ITEMS.register("lemonade",
            (p) -> new DrinkableItem(p), drinkItem().food(ModFoods.LEMONADE));

    public static final DeferredItem<Item> RUSTIC_LOAF_SLICE = ITEMS.register("rustic_loaf_slice",
            (p) -> new Item(p), new Item.Properties().food(ModFoods.RUSTIC_LOAF_SLICE));

    public static final DeferredItem<Item> FISH_AND_CHIPS = ITEMS.register("fish_and_chips",
            (p) -> new ConsumableItem(p, true), bowlFoodItem(ModFoods.FISH_AND_CHIPS));

    public static final DeferredItem<Item> BEANSTALK_SIGN = ITEMS.register("beanstalk_sign",
            (p -> new SignItem(ModBlocks.BEANSTALK_SIGN.get(), ModBlocks.BEANSTALK_WALL_SIGN.get(), p)), new Item.Properties().stacksTo(16));
    public static final DeferredItem<Item> BEANSTALK_HANGING_SIGN = ITEMS.register("beanstalk_hanging_sign",
            (p -> new HangingSignItem(ModBlocks.BEANSTALK_HANGING_SIGN.get(), ModBlocks.BEANSTALK_WALL_HANGING_SIGN.get(), p)), new Item.Properties().stacksTo(16));
    public static final DeferredItem<Item> BEANSTALK_RAFT = ITEMS.register("beanstalk_raft",
            (p -> new BoatItem(ModBoatTypes.BEANSTALK, p)), new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> BEANSTALK_CHEST_RAFT = ITEMS.register("beanstalk_chest_raft",
            (p -> new BoatItem(ModBoatTypes.BEANSTALK_CHEST_BOAT, p)), new Item.Properties().stacksTo(1));

    public static void register() {
        ITEMS.register();
    }
}
