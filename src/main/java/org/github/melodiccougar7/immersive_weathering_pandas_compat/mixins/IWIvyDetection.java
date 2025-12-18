package org.github.melodiccougar7.immersive_weathering_pandas_compat.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.ordana.immersive_weathering.reg.ModBlocks;
import me.pandamods.fallingtrees.trees.GenericTree;

import net.minecraft.core.HolderSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GenericTree.class)
public class IWIvyDetection {
    @ModifyExpressionValue(
            method = "gatherVines(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Ljava/util/Set;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z") //"Lblusunrize/immersiveengineering/api/crafting/StackWithChance;chance()F"
    )
    private boolean includeIWIvy(
        boolean original,
        @Local BlockState currentState
        ) {
        return original || currentState.is((HolderSet<Block>) ModBlocks.IVY);
    }
}
