package dev.silentmoli.sora2.api.util;

import static dev.silentmoli.sora2.Sora2.mc;

public class Utils {
    public static boolean nullCheck() {
        return mc.world != null && mc.player != null;
    }
}
