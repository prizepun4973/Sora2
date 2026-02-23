package dev.silentmoli.sora2.api.util.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class GUIScreen extends Screen {
    protected GUIScreen() {
        super(Text.literal("GUI"));
    }

    @Override
    public void applyBlur(DrawContext context) {
    }

    @Override
    protected void renderDarkening(DrawContext context, int x, int y, int width, int height) {
    }
}
