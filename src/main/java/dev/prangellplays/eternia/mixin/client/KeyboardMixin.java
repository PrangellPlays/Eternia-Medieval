package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (Eternia.isFrozen(MinecraftClient.getInstance().player) && !MinecraftClient.getInstance().isPaused()) {
            KeyBinding.unpressAll();
            callbackInfo.cancel();
        }
    }
}