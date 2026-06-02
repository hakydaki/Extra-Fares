package net.hakydaki.extrafares.content.gen;

import net.hakydaki.extrafares.ExtraFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ExtraFaresConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(ExtraFares.MOD_ID, "lime")
    );
}
