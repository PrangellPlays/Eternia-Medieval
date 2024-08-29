package dev.prangellplays.eternia.item.godweapons.tier1.darkoakforest;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class WithersEdgeGlaiveItem extends SwordItem {
    public WithersEdgeGlaiveItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 600, 3, false, false, true), attacker);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 1, false, false, true), attacker);
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
