package dev.silentmoli.sora2.api.system;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.KeyEvent;
import dev.silentmoli.sora2.api.util.client.KeyAction;
import dev.silentmoli.sora2.impl.module.Category;
import net.minecraft.client.MinecraftClient;

public class Module extends Feature<Module> {
    String name;
    Category category;
    protected MinecraftClient mc = Sora2.mc;
    protected boolean enabled = false;
    public int bind = -1;


    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            Sora2.EVENT_BUS.subscribe(this);
            onActivate();
        } else {
            Sora2.EVENT_BUS.unsubscribe(this);
            onDeactivate();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void onActivate() {}
    public void onDeactivate() {}

    public void onKey(KeyEvent event) {
        if (event.key == bind)
            if (event.action == KeyAction.Press)
                toggle();
    }
}
