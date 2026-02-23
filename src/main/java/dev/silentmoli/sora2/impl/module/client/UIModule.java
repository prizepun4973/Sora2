package dev.silentmoli.sora2.impl.module.client;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.KeyEvent;
import dev.silentmoli.sora2.api.util.Utils;
import dev.silentmoli.sora2.api.util.client.KeyAction;
import dev.silentmoli.sora2.api.util.client.Module;
import dev.silentmoli.sora2.impl.gui.ClickUI;
import dev.silentmoli.sora2.impl.module.Category;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import org.lwjgl.glfw.GLFW;

public class UIModule extends Module {

    public UIModule() {
        super("UI", Category.Client);
        setEnabled(true);
        bind = GLFW.GLFW_KEY_RIGHT_SHIFT;
    }

    @Override
    public void onDeactivate() {
        setEnabled(true);
    }

    @EventHandler
    private void onKey(KeyEvent event) {
        if (event.action == KeyAction.Press && event.key == bind) {
            if (
                mc.currentScreen instanceof TitleScreen ||
                mc.currentScreen instanceof MultiplayerScreen ||
                (Utils.nullCheck() && mc.currentScreen == null)
            ) Sora2.mc.execute(() -> Sora2.mc.setScreen(new ClickUI()));
        }
    }
}
