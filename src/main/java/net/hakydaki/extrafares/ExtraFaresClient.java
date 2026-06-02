package net.hakydaki.extrafares;

import net.hakydaki.extrafares.content.ExtraFaresBlocks;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

//Will have to change this post 1.21.1 but I'll keep this for now...
@EventBusSubscriber(modid = ExtraFares.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExtraFaresClient {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getAverageFoliageColor(world, pos)
                        : FoliageColor.getDefaultColor(),
                ExtraFaresBlocks.LIME_LEAVES.get(),
                ExtraFaresBlocks.FLOWERING_LIME_LEAVES.get(),
                ExtraFaresBlocks.LIME_LOG.get(),
                ExtraFaresBlocks.LIME_WOOD.get(),
                ExtraFaresBlocks.STRIPPED_LIME_LOG.get(),
                ExtraFaresBlocks.STRIPPED_LIME_WOOD.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> FoliageColor.getDefaultColor(),
                ExtraFaresBlocks.LIME_LEAVES.get(),
                ExtraFaresBlocks.FLOWERING_LIME_LEAVES.get(),
                ExtraFaresBlocks.LIME_LOG.get(),
                ExtraFaresBlocks.LIME_WOOD.get(),
                ExtraFaresBlocks.STRIPPED_LIME_LOG.get(),
                ExtraFaresBlocks.STRIPPED_LIME_WOOD.get()
        );
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.LIME_LOG.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.LIME_WOOD.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.STRIPPED_LIME_LOG.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.STRIPPED_LIME_WOOD.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.LIME_SAPLING.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.POTTED_LIME_SAPLING.get(), RenderType.cutout());
        NLServices.client().setBlockRenderType(ExtraFaresBlocks.HANGING_LIME.get(), RenderType.cutout());
    }

}