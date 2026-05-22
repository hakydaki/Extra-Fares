package net.hakydaki.extrafares.content;

import net.hecco.bountifulfares.definition.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.registry.content.BFBlocks.registerBlock;


public class ExtraFaresBlocks {

    //Tree woods
    public static final Supplier<Block> LIME_LOG = registerBlock("lime_log", () -> new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG.get())));
}
