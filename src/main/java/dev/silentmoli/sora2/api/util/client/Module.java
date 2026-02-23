package dev.silentmoli.sora2.api.util.client;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.impl.module.Category;
import net.minecraft.client.MinecraftClient;

public class Module {
    String name;
    Category category;
    protected MinecraftClient mc = Sora2.mc;

    public int bind = -1;

    boolean enabled = false;

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

    public void onActivate() {}
    public void onDeactivate() {}
}
