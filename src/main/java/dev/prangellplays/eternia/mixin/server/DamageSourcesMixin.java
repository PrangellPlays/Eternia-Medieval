package dev.prangellplays.eternia.mixin.server;

import dev.prangellplays.eternia.damage.DamageSourcesExt;
import dev.prangellplays.eternia.damage.EterniaDamageSources;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.registry.DynamicRegistryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DamageSources.class)
public class DamageSourcesMixin implements DamageSourcesExt {
    @Unique
    private EterniaDamageSources eternia$damageSources;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(DynamicRegistryManager registryManager, CallbackInfo ci) {
        this.eternia$damageSources = new EterniaDamageSources((DamageSources) (Object) this);
    }
    @Override
    public EterniaDamageSources eSources() {
        return this.eternia$damageSources;
    }
}
