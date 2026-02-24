package dev.silentmoli.sora2;

import dev.silentmoli.sora2.api.manager.Modules;
import dev.silentmoli.sora2.impl.module.client.*;

public class Registry {
    public static void init() {
        initModules();
    }

    static void initModules() {
        Modules.add(new UIModule());
    }
}
