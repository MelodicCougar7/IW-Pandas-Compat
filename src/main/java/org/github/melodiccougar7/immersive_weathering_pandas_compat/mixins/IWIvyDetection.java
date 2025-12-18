package org.github.melodiccougar7.immersive_weathering_pandas_compat.mixins;

import org.spongepowered.asm.mixin.injection.At;

public class IWVineDetection {
    @ModifyExpressionValue(
            method = "targetMethod",
            at = @At(value = "INVOKE", target = "Ltarget/Class;shouldFly()Z")
    )
    private boolean includeIWVines(boolean original) {
        return original && YourMod.isFlyingAllowed();
    }
}
