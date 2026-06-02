package net.hakydaki.extrafares.content;

import net.hakydaki.extrafares.ExtraFares;
import net.hakydaki.extrafares.content.definition.HangingLimeBlock;
import net.hakydaki.extrafares.content.gen.ExtraFaresSaplingGenerators;
import net.hecco.bountifulfares.definition.block.custom.*;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFSaplingGenerators;
import net.hecco.nexuslib.lib.publicBlocks.PublicSaplingBlock;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;


public class ExtraFaresBlocks {

    public static void registerBlocks() {
    }

    //Tree logs
    public static final Supplier<Block> LIME_LOG = registerBlock("lime_log", () -> new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG.get())));
    //Tree planks
    public static final Supplier<Block> LIME_WOOD = registerBlock("lime_wood", () -> new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_WOOD.get())));
    //Tree stripped logs
    public static final Supplier<Block> STRIPPED_LIME_LOG = registerBlock("stripped_lime_log", () -> new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_LOG.get())));
    //Tree stripped planks
    public static final Supplier<Block> STRIPPED_LIME_WOOD = registerBlock("stripped_lime_wood", () -> new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_WOOD.get())));
    //Hanging fruits
    public static final Supplier<Block> HANGING_LIME = registerBlockNoItem("hanging_lime", () -> new HangingLimeBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE.get())));
    //Fruit leaves — now correctly references HANGING_LIME instead of HANGING_LEMON
    public static final Supplier<Block> LIME_LEAVES = registerBlock("lime_leaves", () -> new FruitLeavesBlock(HANGING_LIME.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LEAVES.get())));
    //Flowering fruit leaves
    public static final Supplier<Block> FLOWERING_LIME_LEAVES = registerBlock("flowering_lime_leaves", () -> new FruitLeavesBlock(HANGING_LIME.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.FLOWERING_APPLE_LEAVES.get())));
    //Tree saplings
    public static final Supplier<Block> LIME_SAPLING = registerBlock("lime_sapling", () -> new PublicSaplingBlock(ExtraFaresSaplingGenerators.LIME_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_SAPLING.get())));
    //Potted saplings
    public static final Supplier<Block> POTTED_LIME_SAPLING = registerBlockNoItem("potted_lime_sapling", () -> new FlowerPotBlock(ExtraFaresBlocks.LIME_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.POTTED_APPLE_SAPLING.get())));
    //Fruit blocks
    public static final Supplier<Block> LIME_BLOCK = registerBlock("lime_block", () -> new LemonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD)));
    //Pies
    public static final Supplier<Block> LIME_PIE = registerBlock("lime_pie", () -> new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)), new Item.Properties().stacksTo(16));

    //Helper Methods
    private static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        return NLServices.REGISTRY.registerBlock(ExtraFares.MOD_ID, name, block);
    }

    private static Supplier<Block> registerBlock(String name, Supplier<Block> block, Item.Properties properties) {
        return NLServices.REGISTRY.registerBlock(ExtraFares.MOD_ID, name, block, properties);
    }

    private static Supplier<Block> registerBlockNoItem(String name, Supplier<Block> block) {
        return NLServices.REGISTRY.registerBlockNoItem(ExtraFares.MOD_ID, name, block);
    }
}