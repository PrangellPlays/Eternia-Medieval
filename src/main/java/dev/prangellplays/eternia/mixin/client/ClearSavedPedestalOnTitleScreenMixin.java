package dev.prangellplays.eternia.mixin.client;

import dev.prangellplays.eternia.utils.MapUtils;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ClearSavedPedestalOnTitleScreenMixin {
    @Inject(at = @At("HEAD"), method = "init")
    public void ClearSavedPedestalOnTitleScreen(CallbackInfo info) {
        MapUtils.pedestals.clear();
        MapUtils.lastItemStack = null;
        MapUtils.lastOpened = null;
    }

}
