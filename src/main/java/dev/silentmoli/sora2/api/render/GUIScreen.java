package dev.silentmoli.sora2.api.render;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.render.widget.Widget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GUIScreen extends Screen {

    protected List<Widget> components = new ArrayList<>();

    protected GUIScreen() {
        super(Text.literal("GUI"));
    }

    @Override
    public void applyBlur(DrawContext context) {}

    @Override
    protected void renderDarkening(DrawContext context, int x, int y, int width, int height) {}

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);

        for (Widget widget : components) {
            widget.render(context, mouseX, mouseY, deltaTicks);
        }

    }

    @Override
    public void close() {

        for (Widget widget : components) {
            Sora2.EVENT_BUS.unsubscribe(widget);
        }

        super.close();
    }

    public void addWidget(Widget widget) {

        components.add(widget);
        Sora2.EVENT_BUS.subscribe(widget);

    }
}
