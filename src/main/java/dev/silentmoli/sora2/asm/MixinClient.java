package dev.silentmoli.sora2.asm;

import dev.silentmoli.sora2.Sora2;
import dev.silentmoli.sora2.api.eventbus.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinClient {
    @Inject(method = "tick", at = @At("HEAD"))
    private void preTick(CallbackInfo ci) {
        Sora2.EVENT_BUS.post(TickEvent.Pre.get());
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void postTick(CallbackInfo ci) {
        Sora2.EVENT_BUS.post(TickEvent.Post.get());
    }
}
