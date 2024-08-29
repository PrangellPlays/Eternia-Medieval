package dev.prangellplays.eternia.item.godweapons.tier1.savanah;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class PiranhaBladeItem extends SwordItem {
    public PiranhaBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(Eternia.BLEED, 80, 0, false, false, true), attacker);
        return super.postHit(stack, target, attacker);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
