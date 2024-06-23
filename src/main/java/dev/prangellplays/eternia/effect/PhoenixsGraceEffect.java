package dev.prangellplays.eternia.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class PhoenixsGraceEffect extends StatusEffect {
    public PhoenixsGraceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.fallDistance = 0;
        super.applyUpdateEffect(entity, amplifier);
    }
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
