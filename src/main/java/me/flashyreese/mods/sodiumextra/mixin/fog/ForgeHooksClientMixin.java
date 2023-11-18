package me.flashyreese.mods.sodiumextra.mixin.fog;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import me.flashyreese.mods.sodiumextra.client.gui.SodiumExtraGameOptions;
import net.neoforged.neoforge.client.ClientHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ClientHooks.class, remap = false)
public class ForgeHooksClientMixin {
    @ModifyExpressionValue(
            method = "onFogRender",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/client/event/ViewportEvent$RenderFog;isCanceled()Z"
            )
    )
    private static boolean rubidiumextra$cancel(boolean original) { // If the rubidium-extra were to work the event normally, it would canceling
        return original || SodiumExtraClientMod.options().renderSettings.fogType == SodiumExtraGameOptions.RenderSettings.FogType.MOD_COMPAT;
    }
}
