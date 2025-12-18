package org.github.melodiccougar7.immersive_weathering_pandas_compat.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.ordana.immersive_weathering.reg.ModBlocks;
import me.pandamods.fallingtrees.trees.GenericTree;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GenericTree, remap = false)
public class IWIvyDetection {
    @ModifyExpressionValue(
            method = "targetMethod",
            at = @At(value = "INVOKE", target = "placeholder") //"Lblusunrize/immersiveengineering/api/crafting/StackWithChance;chance()F"
    )
    private boolean includeIWIvy(boolean original) {
        return original && currentState.is(ModBlocks.IVY);
    }
}
