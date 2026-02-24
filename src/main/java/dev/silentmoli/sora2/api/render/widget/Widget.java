package dev.silentmoli.sora2.api.render.widget;

import dev.silentmoli.sora2.api.render.GUIScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class Widget {
    protected int x;
    protected int y;
    protected GUIScreen gui;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    protected Widget(GUIScreen gui) {
        this.gui = gui;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {}
}
