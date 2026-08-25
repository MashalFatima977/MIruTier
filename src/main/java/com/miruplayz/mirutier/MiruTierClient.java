package com.miruplayz.mirutier;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class MiruTierClient implements ClientModInitializer {
    private static KeyMapping openKey;
    private static boolean enabled = true;

    @Override
    public void onInitializeClient() {
        openKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.mirutier.open", GLFW.GLFW_KEY_O, "category.mirutier"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openKey.consumeClick()) {
                enabled = !enabled;
            }
        });
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void renderHud(GuiGraphics graphics, Minecraft client) {
        if (!enabled || client.player == null) return;
        graphics.drawString(client.font, Component.literal("MiruTier • CPvP HT3"), 8, 8, 0xFFFFFF);
    }
}
