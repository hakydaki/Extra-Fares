package net.hakydaki.extrafares.content.definition;

import net.hakydaki.extrafares.content.ExtraFaresItems;
import net.hecco.bountifulfares.definition.block.custom.HangingFruitBlock;
import net.hecco.bountifulfares.definition.block.custom.HangingLemonBlock;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class HangingLimeBlock extends HangingLemonBlock {

    public HangingLimeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        int age = state.getValue(AGE);
        if (age == 4) {
            HangingFruitBlock.popResource(level, pos, new ItemStack(ExtraFaresItems.LIME.get(), 1));
            level.playSound(null, pos,
                    BFSounds.HANGING_FRUIT_PICK.get(),
                    SoundSource.BLOCKS, 1.0f, 0.8f);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(state, level, pos, player, hit);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(ExtraFaresItems.LIME.get());
    }
}