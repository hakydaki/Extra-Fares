package net.hakydaki.extrafares.content.gen;

import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ExtraFaresSaplingGenerators {

    public static final TreeGrower LIME_SAPLING_GENERATOR = new TreeGrower(
            "lime",
            0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ExtraFaresConfiguredFeatures.LIME_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
    );
}
