package dev.prangellplays.eternia.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class CallOfTheJungleEffect extends StatusEffect {
    protected final double modifier;
    public CallOfTheJungleEffect(StatusEffectCategory category, int color, double modifier) {
        super(category, color);
        this.modifier = modifier;
    }

    public double adjustModifierAmount(int amplifier, EntityAttributeModifier modifier) {
        return this.modifier * (double)(amplifier + 1);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
