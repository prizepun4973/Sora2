package dev.silentmoli.sora2.api.render.widget;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.render.GUIScreen;
import net.minecraft.client.gui.DrawContext;

public class WWindow extends Widget {

    public int width;
    public int height;

    public WWindow(GUIScreen gui, int x, int y, int width, int height) {
        super(gui);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public WWindow(GUIScreen gui, int width, int height) {
        this(
            gui,
            (Sora2.mc.currentScreen.width - width) / 2,
            (Sora2.mc.currentScreen.height - height) / 2,
        width, height);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        context.fill(x, y, x + width, y + height, 0xFFAAAAAA);
    }
}
