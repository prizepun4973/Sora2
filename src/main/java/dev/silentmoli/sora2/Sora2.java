package dev.silentmoli.sora2;

import dev.silentmoli.sora2.api.manager.Modules;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;


public class Sora2 implements ClientModInitializer {
    public static String NAME = "Sora2";
    public static Logger LOG = Logger.getLogger(NAME);

    public static final IEventBus EVENT_BUS = new EventBus();
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        EVENT_BUS.registerLambdaFactory("dev.silentmoli.sora2", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        EVENT_BUS.subscribe(this);

        Modules.init();
    }
}
