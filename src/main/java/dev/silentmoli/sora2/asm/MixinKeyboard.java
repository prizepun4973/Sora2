package dev.silentmoli.sora2.asm;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.KeyEvent;
import dev.silentmoli.sora2.api.util.client.KeyAction;
import net.minecraft.client.Keyboard;
import net.minecraft.client.input.KeyInput;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int action, KeyInput input, CallbackInfo ci) {
        if (input.key() != GLFW.GLFW_KEY_UNKNOWN) {
            if (Sora2.EVENT_BUS.post(KeyEvent.get(input.key(), input.modifiers(), KeyAction.get(action))).isCancelled()) ci.cancel();
        }
    }
}
