package dev.silentmoli.sora2.impl.module.client;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.KeyEvent;
import dev.silentmoli.sora2.api.system.Module;
import dev.silentmoli.sora2.impl.gui.ClickUI;
import dev.silentmoli.sora2.impl.module.Category;
import org.lwjgl.glfw.GLFW;

public class UIModule extends Module {

    public UIModule() {
        super("UI", Category.Client);
        bind = GLFW.GLFW_KEY_RIGHT_SHIFT;
    }

    @Override
    public void onActivate() {
        Sora2.mc.execute(() -> Sora2.mc.setScreen(new ClickUI()));
    }

    @Override
    public void onDeactivate() {
        if (mc.currentScreen instanceof ClickUI)
            Sora2.mc.execute(() -> Sora2.mc.setScreen(null));
    }

    @Override
    public void onKey(KeyEvent event) {
        if (!enabled) super.onKey(event);
    }
}
