package com.miruplayz.mirutier.mixin;

import com.miruplayz.mirutier.MiruTierClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void mirutier$render(GuiGraphics graphics, float tickDelta, CallbackInfo ci) {
        MiruTierClient.renderHud(graphics, Minecraft.getInstance());
    }
}
