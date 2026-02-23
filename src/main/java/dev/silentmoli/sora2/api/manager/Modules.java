package dev.silentmoli.sora2.api.manager;

import dev.silentmoli.sora2.api.util.client.Module;
import dev.silentmoli.sora2.impl.module.client.*;

import java.util.ArrayList;
import java.util.List;

public class Modules {
    public static List<Module> modules = new ArrayList<Module>();

    public static void init() {
        add(new UIModule());
    }

    static void add(Module module) {
        modules.add(module);
    }
}
