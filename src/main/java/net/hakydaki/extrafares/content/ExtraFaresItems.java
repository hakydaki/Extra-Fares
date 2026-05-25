package net.hakydaki.extrafares.content;

import net.hakydaki.extrafares.ExtraFares;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.custom.*;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.registry.content.BFItems.CUP;


public class ExtraFaresItems {

    public static void registerItems() {
    }

    //Fruit Items
    public static final Supplier<Item> LIME = registerItem("lime", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    //Candied Fruits
    public static final Supplier<Item> CANDIED_LIME = registerItem("candied_lime", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).fast().build())));
    //Jars
    public static final Supplier<Item> LIME_COMPOTE_JAR = registerItem("lime_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(CUP.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(CUP.get())));

    //helper methods
    private static Supplier<Item> registerItem(String id, Supplier<Item> registry) {
        return NLServices.REGISTRY.register(ExtraFares.MOD_ID, id, BuiltInRegistries.ITEM, registry);
    }
}
