package dev.silentmoli.sora2.api.manager;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.KeyEvent;
import dev.silentmoli.sora2.api.system.Feature;
import dev.silentmoli.sora2.api.util.client.KeyAction;
import dev.silentmoli.sora2.api.system.Module;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import meteordevelopment.orbit.EventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Modules {
    public static Modules INSTANCE;

    public static List<Module> modules = new ArrayList<>();
    private static Map<Class<? extends Module>, Module> moduleClass = new Reference2ReferenceOpenHashMap<>();

    public Modules() {
        Sora2.EVENT_BUS.subscribe(this);
    }

    public static void init() {
        if (INSTANCE == null) INSTANCE = new Modules();
    }

    public static void add(Module module) {
        modules.add(module);
        moduleClass.put(module.getClass(), module);
    }

    public static Module get(Class<? extends Module> module) {
        return moduleClass.get(module);
    }

    @EventHandler
    private void onKey(KeyEvent event) {
        if (!modules.isEmpty())
            for (Module module : modules) {
                module.onKey(event);
            }
    }
}
