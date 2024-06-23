package dev.prangellplays.eternia.mixin.client;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Enchantment.class)
public class EnchantmentMixin {
    @ModifyArg(method = "getName", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;", ordinal = 1))
    private Formatting eternia$singleLevelMode(Formatting value) {
        return Formatting.GREEN;
    }
}