package dev.prangellplays.eternia.damage;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EterniaDamageSources {
    public static final RegistryKey<DamageType> BLEED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Eternia.id("bleed"));
    public static final RegistryKey<DamageType> POISON_IVY = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Eternia.id("poison_ivy"));
    public static final RegistryKey<DamageType> FREEZE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Eternia.id("freeze"));
    public static final RegistryKey<DamageType> STRANGLED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Eternia.id("strangled"));
    public static final RegistryKey<DamageType> SLAMMED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Eternia.id("slammed"));

    private final DamageSource bleed;
    private final DamageSource poison_ivy;
    private final DamageSource freeze;
    private final DamageSource strangled;
    private final DamageSource slammed;

    public EterniaDamageSources(DamageSources damageSources) {
        this.bleed = damageSources.create(BLEED);
        this.poison_ivy = damageSources.create(POISON_IVY);
        this.freeze = damageSources.create(FREEZE);
        this.strangled = damageSources.create(STRANGLED);
        this.slammed = damageSources.create(SLAMMED);
    }

    public DamageSource bleed() {
        return bleed;
    }

    public DamageSource poison_ivy() {
        return poison_ivy;
    }

    public DamageSource freeze() {
        return freeze;
    }

    public DamageSource strangled() {
        return strangled;
    }

    public DamageSource slammed() {
        return slammed;
    }
}