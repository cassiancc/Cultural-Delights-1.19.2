package com.baisylia.culturaldelights.item;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.custom.BucketFoodItem;
import com.baisylia.culturaldelights.item.custom.MarshmallowOnAStickItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.Consumable;
import cc.cassian.asphodel.util.deferred_registry.DeferredItem;
import cc.cassian.asphodel.util.deferred_registry.DeferredRegister;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import net.minecraft.world.food.FoodProperties;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(CulturalDelights.MOD_ID);

    public static Item.Properties bowlFoodItem(FoodProperties food, Consumable consumable) {
        return (new Item.Properties()).food(food, consumable).craftRemainder(Items.BOWL).stacksTo(16);
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
            Item::new, new Item.Properties().food(ModFoods.BEAN_POD, ModConsumables.BEAN_POD));
    public static final DeferredItem<Item> TOFU = ITEMS.register("tofu",
            Item::new, new Item.Properties().food(ModFoods.TOFU, ModConsumables.TOFU));
    public static final DeferredItem<Item> REFRIED_BEANS = ITEMS.register("refried_beans",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.REFRIED_BEANS, ModConsumables.REFRIED_BEANS));

    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado",
            Item::new, new Item.Properties().food(ModFoods.AVOCADO, ModConsumables.AVOCADO));

    public static final DeferredItem<Item> CUT_AVOCADO = ITEMS.register("cut_avocado",
            Item::new, new Item.Properties().food(ModFoods.CUT_AVOCADO, ModConsumables.CUT_AVOCADO));

    public static final DeferredItem<Item> CUCUMBER = ITEMS.register("cucumber",
            Item::new, new Item.Properties().food(ModFoods.CUCUMBER, ModConsumables.CUCUMBER));

    public static final DeferredItem<Item> PICKLE = ITEMS.register("pickle",
            Item::new, new Item.Properties().food(ModFoods.PICKLE,  ModConsumables.PICKLE));

    public static final DeferredItem<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber",
            Item::new, new Item.Properties().food(ModFoods.CUT_CUCUMBER,  ModConsumables.CUT_CUCUMBER));

    public static final DeferredItem<Item> CUT_PICKLE = ITEMS.register("cut_pickle",
            Item::new, new Item.Properties().food(ModFoods.CUT_PICKLE,   ModConsumables.CUT_PICKLE));

    public static final DeferredItem<Item> EGGPLANT = ITEMS.register("eggplant",
            Item::new, new Item.Properties().food(ModFoods.EGGPLANT, ModConsumables.EGGPLANT));

    public static final DeferredItem<Item> CUT_EGGPLANT = ITEMS.register("cut_eggplant",
            Item::new, new Item.Properties().food(ModFoods.CUT_EGGPLANT, ModConsumables.CUT_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_EGGPLANT = ITEMS.register("smoked_eggplant",
            Item::new, new Item.Properties().food(ModFoods.SMOKED_EGGPLANT, ModConsumables.SMOKED_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_TOMATO = ITEMS.register("smoked_tomato",
            Item::new, new Item.Properties().food(ModFoods.SMOKED_TOMATO, ModConsumables.SMOKED_TOMATO));

    public static final DeferredItem<Item> SMOKED_CUT_EGGPLANT = ITEMS.register("smoked_cut_eggplant",
            Item::new, new Item.Properties().food(ModFoods.SMOKED_CUT_EGGPLANT, ModConsumables.SMOKED_CUT_EGGPLANT));

    public static final DeferredItem<Item> SMOKED_WHITE_EGGPLANT = ITEMS.register("smoked_white_eggplant",
            Item::new, new Item.Properties().food(ModFoods.SMOKED_WHITE_EGGPLANT, ModConsumables.SMOKED_WHITE_EGGPLANT));
    public static final DeferredItem<Item> WHITE_EGGPLANT = ITEMS.register("white_eggplant",
            Item::new, new Item.Properties().food(ModFoods.WHITE_EGGPLANT, ModConsumables.WHITE_EGGPLANT));
    public static final DeferredItem<Item> CORN_COB = ITEMS.register("corn_cob",
            Item::new, new Item.Properties().food(ModFoods.CORN_COB, ModConsumables.CORN_COB));

    public static final DeferredItem<Item> SQUID = ITEMS.register("squid",
            Item::new, new Item.Properties().food(ModFoods.SQUID, ModConsumables.SQUID));

    public static final DeferredItem<Item> COOKED_SQUID = ITEMS.register("cooked_squid",
            Item::new, new Item.Properties().food(ModFoods.COOKED_SQUID, ModConsumables.COOKED_SQUID));

    public static final DeferredItem<Item> GLOW_SQUID = ITEMS.register("glow_squid",
            Item::new, new Item.Properties().food(ModFoods.GLOW_SQUID, ModConsumables.GLOW_SQUID));

    public static final DeferredItem<Item> RAW_CALAMARI = ITEMS.register("raw_calamari",
            Item::new, new Item.Properties().food(ModFoods.RAW_CALAMARI, ModConsumables.RAW_CALAMARI));

    public static final DeferredItem<Item> COOKED_CALAMARI = ITEMS.register("cooked_calamari",
            Item::new, new Item.Properties().food(ModFoods.COOKED_CALAMARI, ModConsumables.COOKED_CALAMARI));


    public static final DeferredItem<Item> BUTTER = ITEMS.register("butter",
            Item::new, new Item.Properties().food(ModFoods.BUTTER, ModConsumables.BUTTER));

    public static final DeferredItem<Item> BUTTERED_TOAST = ITEMS.register("buttered_toast",
            Item::new, new Item.Properties().food(ModFoods.BUTTERED_TOAST, ModConsumables.BUTTERED_TOAST));

    public static final DeferredItem<Item> RAW_SAUSAGE = ITEMS.register("raw_sausage",
            Item::new, new Item.Properties().food(ModFoods.RAW_SAUSAGE, ModConsumables.RAW_SAUSAGE));

    public static final DeferredItem<Item> COOKED_SAUSAGE = ITEMS.register("cooked_sausage",
            Item::new, new Item.Properties().food(ModFoods.COOKED_SAUSAGE, ModConsumables.COOKED_SAUSAGE));

    public static final DeferredItem<Item> SNAG = ITEMS.register("snag",
            Item::new, new Item.Properties().food(ModFoods.SNAG, ModConsumables.SNAG));

    public static final DeferredItem<Item> SAUSAGES_AND_MASH = ITEMS.register("sausages_and_mash",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.SAUSAGES_AND_MASH, ModConsumables.SAUSAGES_AND_MASH));

    public static final DeferredItem<Item> POPCORN_BUCKET = ITEMS.register("popcorn_bucket",
			BucketFoodItem::new, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(16).food(ModFoods.POPCORN_BUCKET, ModConsumables.POPCORN_BUCKET));


    public static final DeferredItem<Item> BEER = ITEMS.register("beer",
            Item::new, drinkItem().food(ModFoods.BEER, ModConsumables.BEER).stacksTo(16));
    public static final DeferredItem<Item> WINE = ITEMS.register("wine",
            Item::new, drinkItem().food(ModFoods.WINE, ModConsumables.WINE).stacksTo(16));
    public static final DeferredItem<Item> GLOW_WINE = ITEMS.register("glow_wine",
            Item::new, drinkItem().food(ModFoods.GLOW_WINE, ModConsumables.GLOW_WINE).stacksTo(16));
    public static final DeferredItem<Item> GINGER_BEER = ITEMS.register("ginger_beer",
            Item::new, drinkItem().food(ModFoods.GINGER_BEER, ModConsumables.GINGER_BEER).stacksTo(16));
    public static final DeferredItem<Item> MEAD = ITEMS.register("mead",
            Item::new, drinkItem().food(ModFoods.MEAD, ModConsumables.MEAD).stacksTo(16));
    public static final DeferredItem<Item> APPLE_CIDER = ITEMS.register("apple_cider",
            Item::new, drinkItem().food(ModFoods.APPLE_CIDER, ModConsumables.APPLE_CIDER).stacksTo(16));
    public static final DeferredItem<Item> MOJITO = ITEMS.register("mojito",
            Item::new, drinkItem().food(ModFoods.MOJITO, ModConsumables.MOJITO).stacksTo(16));
    public static final DeferredItem<Item> MARGARITA = ITEMS.register("margarita",
            Item::new, drinkItem().food(ModFoods.MARGARITA, ModConsumables.MARGARITA).stacksTo(16));
    public static final DeferredItem<Item> BLOODY_MARY = ITEMS.register("bloody_mary",
            Item::new, drinkItem().food(ModFoods.BLOODY_MARY, ModConsumables.BLOODY_MARY).stacksTo(16));
    public static final DeferredItem<Item> LEMON_LIQUEUR = ITEMS.register("lemon_liqueur",
            Item::new, drinkItem().food(ModFoods.LEMON_LIQUEUR, ModConsumables.LEMON_LIQUEUR).stacksTo(16));
    public static final DeferredItem<Item> BUTTERBEER = ITEMS.register("butterbeer",
            Item::new, drinkItem().food(ModFoods.BUTTERBEER, ModConsumables.BUTTERBEER).stacksTo(16));
    public static final DeferredItem<Item> COLA = ITEMS.register("cola",
            Item::new, drinkItem().food(ModFoods.COLA, ModConsumables.COLA).stacksTo(16));
    public static final DeferredItem<Item> TEQUILA = ITEMS.register("tequila",
            Item::new, drinkItem().food(ModFoods.TEQUILA, ModConsumables.TEQUILA).stacksTo(16));
    public static final DeferredItem<Item> GIN = ITEMS.register("gin",
            Item::new, drinkItem().food(ModFoods.GIN, ModConsumables.GIN).stacksTo(16));
    public static final DeferredItem<Item> BRANDY = ITEMS.register("brandy",
            Item::new, drinkItem().food(ModFoods.BRANDY, ModConsumables.BRANDY).stacksTo(16));
    public static final DeferredItem<Item> VODKA = ITEMS.register("vodka",
            Item::new, drinkItem().food(ModFoods.VODKA, ModConsumables.VODKA).stacksTo(16));
    public static final DeferredItem<Item> WHISKEY = ITEMS.register("whiskey",
            Item::new, drinkItem().food(ModFoods.WHISKEY, ModConsumables.WHISKEY).stacksTo(16));
    public static final DeferredItem<Item> RUM = ITEMS.register("rum",
            Item::new, drinkItem().food(ModFoods.RUM, ModConsumables.RUM).stacksTo(16));

    public static final DeferredItem<Item> ACID = ITEMS.register("acid",
            Item::new, drinkItem().food(ModFoods.ACID, ModConsumables.ACID).stacksTo(16));
    public static final DeferredItem<Item> VINEGAR = ITEMS.register("vinegar",
            Item::new, drinkItem().food(ModFoods.VINEGAR, ModConsumables.VINEGAR).stacksTo(16));
    public static final DeferredItem<Item> PICKLED_EGG = ITEMS.register("pickled_egg",
            Item::new, new Item.Properties().food(ModFoods.PICKLED_EGG, ModConsumables.PICKLED_EGG));
    public static final DeferredItem<Item> CHEESE_WEDGE = ITEMS.register("cheese_wedge",
            Item::new, new Item.Properties().food(ModFoods.CHEESE_WEDGE, ModConsumables.CHEESE_WEDGE));

    public static final DeferredItem<Item> CORN_DOG = ITEMS.register("corn_dog",
            Item::new, new Item.Properties().craftRemainder(Items.STICK).food(ModFoods.CORN_DOG, ModConsumables.CORN_DOG));
    public static final DeferredItem<Item> HOT_DOG = ITEMS.register("hot_dog",
            Item::new, new Item.Properties().food(ModFoods.HOT_DOG, ModConsumables.HOT_DOG));
    public static final DeferredItem<Item> CHEESY_CHIP_WRAP = ITEMS.register("cheesy_chip_wrap",
            Item::new, new Item.Properties().food(ModFoods.CHEESY_CHIP_WRAP, ModConsumables.CHEESY_CHIP_WRAP));
    public static final DeferredItem<Item> CHEESE_CRACKER = ITEMS.register("cheese_cracker",
            Item::new, new Item.Properties().food(ModFoods.CHEESE_CRACKER, ModConsumables.CHEESE_CRACKER));
    public static final DeferredItem<Item> CHIPS_WITH_CHEESE = ITEMS.register("chips_with_cheese",
            Item::new, new Item.Properties().food(ModFoods.CHIPS_WITH_CHEESE, ModConsumables.CHIPS_WITH_CHEESE));
    public static final DeferredItem<Item> CINNAMON = ITEMS.register("cinnamon",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> CINNAMON_MINT_CURRY = ITEMS.register("cinnamon_mint_curry",
            Item::new, new Item.Properties().food(ModFoods.CINNAMON_MINT_CURRY, ModConsumables.CINNAMON_MINT_CURRY));
    public static final DeferredItem<Item> CINNAMON_CRACKER = ITEMS.register("cinnamon_cracker",
            Item::new, new Item.Properties().food(ModFoods.CINNAMON_CRACKER, ModConsumables.CINNAMON_CRACKER));
    public static final DeferredItem<Item> BUTTERSCOTCH_CINNAMON_PIE_SLICE = ITEMS.register("butterscotch_cinnamon_pie_slice",
            Item::new, new Item.Properties().food(FoodValues.PIE_SLICE));


    //Meals
    public static final DeferredItem<Item> POPCORN = ITEMS.register("popcorn",
            Item::new, new Item.Properties().food(ModFoods.POPCORN, ModConsumables.POPCORN));

    public static final DeferredItem<Item> CORN_DOUGH = ITEMS.register("corn_dough",
            Item::new, new Item.Properties().food(ModFoods.CORN_DOUGH, ModConsumables.CORN_DOUGH));

    public static final DeferredItem<Item> TORTILLA = ITEMS.register("tortilla",
            Item::new, new Item.Properties().food(ModFoods.TORTILLA, ModConsumables.TORTILLA));

    public static final DeferredItem<Item> TORTILLA_CHIPS = ITEMS.register("tortilla_chips",
            Item::new, new Item.Properties().food(ModFoods.TORTILLA_CHIPS, ModConsumables.TORTILLA_CHIPS));

    public static final DeferredItem<Item> ELOTE = ITEMS.register("elote",
            Item::new, new Item.Properties().craftRemainder(Items.STICK).food(ModFoods.ELOTE, ModConsumables.ELOTE));

    public static final DeferredItem<Item> EMPANADA = ITEMS.register("empanada",
            Item::new, new Item.Properties().food(ModFoods.EMPANADA, ModConsumables.EMPANADA));

    public static final DeferredItem<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.HEARTY_SALAD, ModConsumables.HEARTY_SALAD));

    public static final DeferredItem<Item> BEEF_BURRITO = ITEMS.register("beef_burrito",
            Item::new, new Item.Properties().food(ModFoods.BEEF_BURRITO, ModConsumables.BEEF_BURRITO));

    public static final DeferredItem<Item> MUTTON_SANDWICH = ITEMS.register("mutton_sandwich",
            Item::new, new Item.Properties().food(ModFoods.MUTTON_SANDWICH, ModConsumables.MUTTON_SANDWICH));

    public static final DeferredItem<Item> EGGPLANT_PARMESAN = ITEMS.register("eggplant_parmesan",
            ConsumableItem::new, new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16).food(ModFoods.EGGPLANT_PARMESAN, ModConsumables.EGGPLANT_PARMESAN));

    public static final DeferredItem<Item> POACHED_EGGPLANTS = ITEMS.register("poached_eggplants",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.POACHED_EGGPLANTS, ModConsumables.POACHED_EGGPLANTS));

    public static final DeferredItem<Item> EGGPLANT_BURGER = ITEMS.register("eggplant_burger",
            Item::new, new Item.Properties().food(ModFoods.EGGPLANT_BURGER, ModConsumables.EGGPLANT_BURGER));

    public static final DeferredItem<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            Item::new, new Item.Properties().food(ModFoods.AVOCADO_TOAST, ModConsumables.AVOCADO_TOAST));

    public static final DeferredItem<Item> CREAMED_CORN = ITEMS.register("creamed_corn",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.CREAMED_CORN, ModConsumables.CREAMED_CORN));

    public static final DeferredItem<Item> CHICKEN_TACO = ITEMS.register("chicken_taco",
            Item::new, new Item.Properties().food(ModFoods.CHICKEN_TACO, ModConsumables.CHICKEN_TACO));

    public static final DeferredItem<Item> SPICY_CURRY = ITEMS.register("spicy_curry",
            ConsumableItem::new, new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food(ModFoods.SPICY_CURRY, ModConsumables.SPICY_CURRY));

    public static final DeferredItem<Item> PORK_WRAP = ITEMS.register("pork_wrap",
            Item::new, new Item.Properties().food(ModFoods.PORK_WRAP, ModConsumables.PORK_WRAP));

    public static final DeferredItem<Item> FISH_TACO = ITEMS.register("fish_taco",
            Item::new, new Item.Properties().food(ModFoods.FISH_TACO, ModConsumables.FISH_TACO));

    public static final DeferredItem<Item> MIDORI_ROLL = ITEMS.register("midori_roll",
            Item::new, new Item.Properties().food(ModFoods.MIDORI_ROLL, ModConsumables.MIDORI_ROLL));

    public static final DeferredItem<Item> MIDORI_ROLL_SLICE = ITEMS.register("midori_roll_slice",
            Item::new, new Item.Properties().food(ModFoods.MIDORI_ROLL_SLICE, ModConsumables.MIDORI_ROLL_SLICE));

    public static final DeferredItem<Item> EGG_ROLL = ITEMS.register("egg_roll",
            Item::new, new Item.Properties().food(ModFoods.EGG_ROLL, ModConsumables.EGG_ROLL));

    public static final DeferredItem<Item> CHICKEN_ROLL = ITEMS.register("chicken_roll",
            Item::new, new Item.Properties().food(ModFoods.CHICKEN_ROLL, ModConsumables.CHICKEN_ROLL));

    public static final DeferredItem<Item> CHICKEN_ROLL_SLICE = ITEMS.register("chicken_roll_slice",
            Item::new, new Item.Properties().food(ModFoods.CHICKEN_ROLL_SLICE, ModConsumables.CHICKEN_ROLL_SLICE));

    public static final DeferredItem<Item> PUFFERFISH_ROLL = ITEMS.register("pufferfish_roll",
            Item::new, new Item.Properties().food(ModFoods.PUFFERFISH_ROLL, ModConsumables.PUFFERFISH_ROLL));

    public static final DeferredItem<Item> TROPICAL_ROLL = ITEMS.register("tropical_roll",
            Item::new, new Item.Properties().food(ModFoods.TROPICAL_ROLL, ModConsumables.TROPICAL_ROLL));

    public static final DeferredItem<Item> RICE_BALL = ITEMS.register("rice_ball",
            Item::new, new Item.Properties().food(ModFoods.RICE_BALL, ModConsumables.RICE_BALL));

    public static final DeferredItem<Item> CALAMARI_ROLL = ITEMS.register("calamari_roll",
            Item::new, new Item.Properties().food(ModFoods.CALAMARI_ROLL, ModConsumables.CALAMARI_ROLL));

    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.register("marshmallow",
            Item::new, new Item.Properties().food(ModFoods.MARSHMALLOW, ModConsumables.MARSHMALLOW));

    public static final DeferredItem<Item> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick",
            MarshmallowOnAStickItem::new, new Item.Properties().food(ModFoods.MARSHMALLOW_ON_A_STICK, ModConsumables.MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> CARAMELIZED_MARSHMALLOW_ON_A_STICK = ITEMS.register("caramelized_marshmallow_on_a_stick",
            MarshmallowOnAStickItem::new, new Item.Properties().food(ModFoods.CARAMELIZED_MARSHMALLOW_ON_A_STICK, ModConsumables.CARAMELIZED_MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> CHARRED_MARSHMALLOW_ON_A_STICK = ITEMS.register("charred_marshmallow_on_a_stick",
            MarshmallowOnAStickItem::new, new Item.Properties().food(ModFoods.CHARRED_MARSHMALLOW_ON_A_STICK, ModConsumables.CHARRED_MARSHMALLOW_ON_A_STICK));

    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            Item::new, new Item.Properties().food(ModFoods.LEMON, ModConsumables.LEMON));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> COOKING_OIL = ITEMS.register("cooking_oil",
            Item::new, drinkItem().food(ModFoods.COOKING_OIL, ModConsumables.COOKING_OIL));

    public static final DeferredItem<Item> CHOCOLATE_MUFFIN = ITEMS.register("chocolate_muffin",
            Item::new, new Item.Properties().food(ModFoods.CHOCOLATE_MUFFIN, ModConsumables.CHOCOLATE_MUFFIN));

    public static final DeferredItem<Item> LEMON_MUFFIN = ITEMS.register("lemon_muffin",
            Item::new, new Item.Properties().food(ModFoods.LEMON_MUFFIN, ModConsumables.LEMON_MUFFIN));

    public static final DeferredItem<Item> WAFER = ITEMS.register("wafer",
            Item::new, new Item.Properties().food(ModFoods.WAFER, ModConsumables.WAFER));

    public static final DeferredItem<Item> ICE_CREAM = ITEMS.register("ice_cream",
            Item::new, new Item.Properties().stacksTo(16).food(ModFoods.ICE_CREAM, ModConsumables.ICE_CREAM));

    public static final DeferredItem<Item> FRIED_POTATO = ITEMS.register("fried_potato",
            Item::new, new Item.Properties().food(ModFoods.FRIED_POTATO, ModConsumables.FRIED_POTATO));

    public static final DeferredItem<Item> LEMONADE = ITEMS.register("lemonade",
            Item::new, drinkItem().food(ModFoods.LEMONADE, ModConsumables.LEMONADE));

    public static final DeferredItem<Item> RUSTIC_LOAF_SLICE = ITEMS.register("rustic_loaf_slice",
            Item::new, new Item.Properties().food(ModFoods.RUSTIC_LOAF_SLICE, ModConsumables.RUSTIC_LOAF_SLICE));

    public static final DeferredItem<Item> FISH_AND_CHIPS = ITEMS.register("fish_and_chips",
            (p) -> new ConsumableItem(p, true), bowlFoodItem(ModFoods.FISH_AND_CHIPS, ModConsumables.FISH_AND_CHIPS));

    public static final DeferredItem<Item> BEANSTALK_SIGN = ITEMS.register("beanstalk_sign",
            (p -> new StandingAndWallBlockItem(ModBlocks.BEANSTALK_SIGN.get(), ModBlocks.BEANSTALK_WALL_SIGN.get(), Direction.DOWN, p)), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
    public static final DeferredItem<Item> BEANSTALK_HANGING_SIGN = ITEMS.register("beanstalk_hanging_sign",
            (p -> new HangingSignItem(ModBlocks.BEANSTALK_HANGING_SIGN.get(), ModBlocks.BEANSTALK_WALL_HANGING_SIGN.get(), p)), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
    public static final DeferredItem<Item> BEANSTALK_RAFT = ITEMS.register("beanstalk_raft",
            (p -> new BoatItem(ModBoatTypes.BEANSTALK, p)), new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> BEANSTALK_CHEST_RAFT = ITEMS.register("beanstalk_chest_raft",
            (p -> new BoatItem(ModBoatTypes.BEANSTALK_CHEST_RAFT, p)), new Item.Properties().stacksTo(1));

    public static void register() {
        ITEMS.register();
    }
}
